/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Logica.FachadaServicios;
import java.util.ArrayList;
import Logica.observer.Observable;
import Logica.observer.Observer;
import dominio.EstadoItemEnum;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.Pedido;
import dominio.Sesion;
import dominio.UnidadProcesadora;
import exceptions.ServicioException;
import exceptions.MesaException;
import exceptions.PedidoException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ui.DialogoGestor;
import ui.DialogoGestorVista;
import ui.DialogoMozoVista;

/**
 *
 * @author yamil
 */
public class DialogoGestorControlador implements Observer {

    private DialogoGestorVista vista;
    private Gestor gestor;
    private UnidadProcesadora unidadProcesadora;
    private Sesion sesion;

    public DialogoGestorControlador(DialogoGestorVista vista, Gestor gestor, UnidadProcesadora unidadProcesadora) {

        this.vista = vista;
        this.gestor = gestor;
        sesion = new Sesion(gestor, new Date());
        this.unidadProcesadora = unidadProcesadora;
        FachadaServicios.getInstance().iniciar(sesion);
        FachadaServicios.getInstance().addObserver(this);
        inicializarVista();

    }

    //////////////////////////////////////////////////////////////////
    //   //*CU:  Ingresar a la aplicación                           //               
    ////////////////////////////////////////////////////////////////// 
    private void inicializarVista() {
        cargarNombre();
        cargarTabla();
    }

    private void cargarNombre() {
        vista.cargarNombreGestor(gestor.getNombreCompleto());
    }

    public void cargarTabla() {
        vista.vaciarTabla();
        ArrayList<Pedido> pedidos = unidadProcesadora.getItemPedidos();
        vista.cargarTabla(pedidos);

    }

    //////////////////////////////////////////////////////////////////
    //   //*CU: Tomar un pedido                                     //               
    ////////////////////////////////////////////////////////////////// 
    public void tomarPedido(int pos) throws PedidoException {
        if (pos == -1) {
            vista.mostrarError("No ha seleccionado un item.");
        } else {
            try {
                Pedido pedido = unidadProcesadora.getItemPedidos().get(pos);
                FachadaServicios.getInstance().setearPedidoParaGestor(pedido, gestor, unidadProcesadora);
                cargarTabla();
                vista.cargarPedidosGestor(gestor.getPedidos());
            } catch (PedidoException ex) {
                vista.mostrarError(ex.getMessage());
            }
        }

    }

    public Gestor getGestor() {
        return gestor;
    }

    //////////////////////////////////////////////////////////////////
    //   //*CU: Finalizar un pedido                                 //               
    ////////////////////////////////////////////////////////////////// 
    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public void finalizarPedido(Pedido pedido) throws PedidoException {
        try {
            FachadaServicios.getInstance().finalizarPedidoParaGestor(pedido, gestor);
            vista.cargarPedidosGestor(gestor.getPedidos());
        } catch (PedidoException ex) {
            vista.mostrarError(ex.getMessage());
        }

    }


    @Override
    public void update(Observable source, Object event) {
        if (event.equals(Observer.Eventos.PEDIDOS_ACTUALIZADOS)) {
            cargarTabla();
        }

    }

    public void salirDelSistema() {
        boolean pedidosPendientes = false;
        pedidosPendientes = FachadaServicios.getInstance().tienePedidosPendientes(gestor);
        if(!pedidosPendientes){
            cerrarSesion();
            vista.cerrarVista();
        }else{
            vista.mostrarError("Debe finalizar los pedidos pendientes antes de salir.");
        }
    }

    public void cerrarSesion() {
        FachadaServicios.getInstance().deleteObserver(this);
        FachadaServicios.getInstance().cerrar(sesion);
    }
}
