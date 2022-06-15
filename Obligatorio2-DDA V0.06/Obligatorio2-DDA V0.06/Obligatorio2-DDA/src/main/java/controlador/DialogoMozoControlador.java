/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.Mesa;
import dominio.Producto;
import dominio.Usuario;
import java.util.ArrayList;
import Logica.FachadaServicios;
import Logica.observer.Observable;
import Logica.observer.Observer;
import dominio.ItemServicio;
import dominio.Mozo;
import dominio.Pedido;
import dominio.Servicio;
import dominio.Sesion;
import dominio.TransferenciaAprobacionEnum;
import dominio.TransferenciaMesa;
import exceptions.ServicioException;
import exceptions.MesaException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.DialogoMozo;
import ui.DialogoMozoVista;

/**
 *
 * @author yamil
 */
public class DialogoMozoControlador implements Observer {

    private DialogoMozoVista vista;
    private Mozo mozo;
    private Sesion sesion;

    public DialogoMozoControlador(DialogoMozoVista vista, Mozo mozo) {
        this.vista = vista;
        this.mozo = mozo;
        sesion = new Sesion(mozo, new Date());
        FachadaServicios.getInstance().iniciar(sesion);
        FachadaServicios.getInstance().addObserver(this);
        inicializarVista();
    }

    //////////////////////////////////////////////////////////////////
    //   //*CU:  Ingresar a la aplicación                           //               
    ////////////////////////////////////////////////////////////////// 
    private void inicializarVista() {
        cargarNombre();
        cargarMesasMozo();
        actualizarListaProductos();
    }

    private void cargarNombre() {
        vista.cargarNombreMozo(mozo.getNombreCompleto());
    }

    public void cargarMesasMozo() {
        ArrayList<Mesa> mesasMozo = FachadaServicios.getInstance().conjuntoMesasDeMozo(mozo);
        vista.cargarMesasMozo(mesasMozo);
    }

    //////////////////////////////////////////////////////////////////
    //   //*CU: Abrir una mesa                                      //               
    ////////////////////////////////////////////////////////////////// 
    public void abrirMesa(Mesa mesa) throws MesaException {
        if (mesa == null) {
            vista.mostrarError("Debe seleccionar una mesa.");
        } else {
            try {
                FachadaServicios.getInstance().abrirMesa(mesa);
                vista.mesaAbierta("Servicio de la mesa: " + mesa.getNumero(), mozo.getMesas());
            } catch (MesaException e) {
                vista.mostrarError(e.getMessage());
            }
        }

    }

    //////////////////////////////////////////////////////////////////
    //   //CU: Agregar un producto al servicio                      //               
    //////////////////////////////////////////////////////////////////
    public void cargarServicioMesa(Mesa mesa) {
        vista.listaProductosDesactivar();
        if (mesa.isAbierta()) {
            Servicio servicio = FachadaServicios.getInstance().getServicioMesa(mesa);
            vista.setLblServicioMesa("Servicio de la mesa: " + mesa.getNumero());
            if (!servicio.getItems().isEmpty()) {
                vista.cargarServicioCompleto(servicio);
            }
        } else {
            vista.setLblServicioMesa("La mesa " + mesa.getNumero() + " está cerrada.");
        }
    }

    public void listaProductosDisponibles(Mesa mesa) {
        if (mesa != null && mesa.isAbierta()) {
            vista.listaProductosActivar();
            actualizarListaProductos();
        } else {
            vista.mostrarError("Seleccione una mesa abierta");
        }
    }

    public void actualizarListaProductos() {
        ArrayList<Producto> productos = FachadaServicios.getInstance().getProductosDisponibles();
        vista.setListProductos(productos);
    }

    public void agregarProductoAlServicio(Mesa mesa, Producto producto, String descripcion, String cantidad) throws ServicioException {
        try {

            ItemServicio is = FachadaServicios.getInstance().agregarProductoAServicio(mesa, producto, cantidad, descripcion);
            Pedido pedido = new Pedido(this.mozo, is, mesa);
            vista.agregarItemTablaServicio(is);
            FachadaServicios.getInstance().agregarPedidoUnidadProcesadora(pedido);
            vista.clearTextField();
        } catch (ServicioException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////
    //   //CU: Transferir una mesa                                  //               
    //////////////////////////////////////////////////////////////////
    public void transferirMesa(Mesa mesa) {
        if (mesa != null) {
            vista.callDialogoMozoTransferirMesa(mozo, mesa);
        } else {
            vista.mostrarError("Debe seleccionar una mesa.");
        }
    }

    public void cambioEstadoTransferenciaMesa(int opcionSeleccionada, TransferenciaMesa transferencia) {
        FachadaServicios.getInstance().cambioEstadoTransferenciaMesa(opcionSeleccionada, transferencia);
    }

    //////////////////////////////////////////////////////////////////
    //   //CU: Cerrar una mesa                                      //               
    //////////////////////////////////////////////////////////////////
    public void cerrarMesa(Mesa mesa) throws MesaException {
        if (mesa == null) {
            vista.mostrarError("Debe seleccionar una mesa.");
        } else {
            try {
                mesa.cerrarMesa();
                cargarMesasMozo();
                vista.limpiarTablaServicio();
                vista.callDialogoCerrarMesa(mozo, mesa);
            } catch (MesaException e) {
                vista.mostrarError(e.getMessage());
            }
        }

    }

    //////////////////////////////////////////////////////////////////
    //   //CU: Salir del sistema                                    //               
    //////////////////////////////////////////////////////////////////
    public void salirDelSistema() {
        boolean mesasAbiertas = false;
        mesasAbiertas = FachadaServicios.getInstance().tieneMesasAbiertas(mozo);
        if (!mesasAbiertas) {
            cerrarSesion();
            vista.cerrarVista();
        } else {
            vista.mostrarError("Debe cerrar las mesas abiertas antes de salir");
        }
    }

    public void cerrarSesion() {
        FachadaServicios.getInstance().deleteObserver(this);
        FachadaServicios.getInstance().cerrar(sesion);
    }

    @Override
    public void update(Observable source, Object event) {
        if (event.equals(Observer.Eventos.STOCK_ACTUALIZADO)) {
            actualizarListaProductos();
        }
        if (event.equals(Observer.Eventos.PEDIDO_FINALIZADO)) {
            Mesa mesa = FachadaServicios.getInstance().finalizaronMiPedido(mozo);
            if (mesa != null) {
                ItemServicio isFinalizado = FachadaServicios.getInstance().isFinalizado(mesa);
                String detallePedido = "Mesa: " + mesa.toString() + ", Producto: " + isFinalizado.getProducto() + ", Cant.: " + isFinalizado.getUnidades();
                isFinalizado.setActualizado(false);
                vista.notificarPedidoFinalizado(detallePedido);
            }
        }
        if (event.equals(Observer.Eventos.NUEVA_TRANSFERENCIA)) {
            if (this.mozo.getTransferenciaRecepcion() != null) {
                vista.notificarNuevaTransferenciaMesa(this.mozo.getTransferenciaRecepcion());
            }
        }
        if (event.equals(Observer.Eventos.CAMBIO_ESTADO_TRANSFERENCIA_APROBADA)) {
            if (this.mozo.getTransferenciaEmitida() != null) {
                if (this.mozo.getTransferenciaEmitida().getEstado().equals(TransferenciaAprobacionEnum.APROBADA)) {
                    vista.notificarEstadoTransferenciaEmitida("Aprobada");
                    try {
                        FachadaServicios.getInstance().tramitarTransferenciaMesa(this.mozo);
                        cargarMesasMozo();
                        vista.limpiarTablaServicio();
                    } catch (MesaException ex) {
                        vista.mostrarError(ex.getMessage());
                    }
                }
            }
        }
        if (event.equals(Observer.Eventos.CAMBIO_ESTADO_TRANSFERENCIA_RECHAZADA)) {
            if (this.mozo.getTransferenciaEmitida() != null) {
                if (this.mozo.getTransferenciaEmitida().getEstado().equals(TransferenciaAprobacionEnum.RECHAZADA)) {
                    vista.notificarEstadoTransferenciaEmitida("Rechazada");
                    try {
                        FachadaServicios.getInstance().tramitarTransferenciaMesa(this.mozo);
                    } catch (MesaException ex) {
                        vista.mostrarError(ex.getMessage());
                    }
                }
            }
        }
        if (event.equals(Observer.Eventos.TRANSFERENCIA_CONCLUIDA)) {
            if (this.mozo.getTransferenciaRecepcion() != null) {
                if (this.mozo.getTransferenciaRecepcion().getEstado().equals(TransferenciaAprobacionEnum.APROBADA)) {
                    FachadaServicios.getInstance().eliminarTransferencias(this.mozo.getTransferenciaRecepcion());
                    cargarMesasMozo();
                }
            }

        }
    }

}
