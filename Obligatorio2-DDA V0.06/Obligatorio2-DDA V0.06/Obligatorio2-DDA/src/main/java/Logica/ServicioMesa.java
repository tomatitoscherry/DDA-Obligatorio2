package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Logica.observer.Observer;
import dominio.Beneficio;
import dominio.Cliente;
import dominio.DetalleBeneficiosAplicados;
import dominio.EstadoItemEnum;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Producto;
import dominio.Servicio;
import dominio.TransferenciaAprobacionEnum;
import dominio.TransferenciaMesa;
import exceptions.AgregarClienteMesaException;
import dominio.UnidadProcesadora;
import exceptions.ServicioException;
import exceptions.MesaException;
import exceptions.PedidoException;
import java.util.ArrayList;
import java.lang.Exception;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class ServicioMesa {

    ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    ArrayList<Producto> todosLosProductos = new ArrayList<Producto>();
    ArrayList<Cliente> todosLosClientes = new ArrayList<Cliente>();

    public Servicio getServiciosMesa(Mesa mesa) {
        return mesa.getServicio();
    }

    /////////////////////////////////////////////
    //      //Logica precarga de datos         //
    ////////////////////////////////////////////
    public void agregarMesa(Mozo mozo, Mesa mesa) throws MesaException {
        mesas.add(mesa);
        mozo.agregarMesa(mesa);
    }

    public void agregarCliente(Cliente cli) {
        todosLosClientes.add(cli);
    }

    public void agregarProductos(Producto producto) {
        todosLosProductos.add(producto);
    }

    ///////////////////////////////////////////////////////////////////////////////
    //                   //LOGICA PROYECTO                                       //
    //////////////////////////////////////////////////////////////////////////////
    public ArrayList<Producto> getProductosDisponibles() {
        ArrayList<Producto> productosConStock = new ArrayList<Producto>();
        for (Producto p : todosLosProductos) {
            if (p.getStock() > 0) {
                productosConStock.add(p);
            }
        }
        return productosConStock;
    }

    public ItemServicio agregarProductoAServicio(Mesa mesa, Producto producto, String cantidad, String descripcion) throws ServicioException {
        String exReg="^[0-9]+$";
        ItemServicio is;
        if(validarString(exReg, cantidad)){
            if (producto != null) {
            if (!cantidad.isEmpty()) {
                int cantP = Integer.parseInt(cantidad);
                if (cantP > 0) {
                    if (cantP <= producto.getStock()) {
                        if (cantP > 0) {
                            producto.actualizarStock(cantP);
                            is = new ItemServicio(cantP, descripcion, producto);
                            mesa.getServicio().agregarItem(is);
                            FachadaServicios.getInstance().notifyObservers(Observer.Eventos.STOCK_ACTUALIZADO);
                        } else {
                            throw new ServicioException("La mesa está cerrada");
                        }
                    } else {
                        throw new ServicioException("Sin stock, solo quedan " + producto.getStock());
                    }
                } else {
                    throw new ServicioException("Cantidad inválida");
                }
            } else {
                throw new ServicioException("Cantidad inválida");
            }
        } else {
            throw new ServicioException("Seleccione un producto");
        }
        return is;
        } else {
               throw new ServicioException("Debe ingresar un número para la cantidad.");
        }
     
    }

    public void transferirMesa(Mesa mesa, Mozo mozo, Mozo mozoSeleccionado) {
        TransferenciaMesa unaTransferencia = new TransferenciaMesa(mozo, mozoSeleccionado, mesa);
        if (mozoSeleccionado.cantMesas() < 5) {
            mozoSeleccionado.agregarTransferenciaRecepcion(unaTransferencia);
            mozo.agregarTransferenciaEmitida(unaTransferencia);
            FachadaServicios.getInstance().notifyObservers(Observer.Eventos.NUEVA_TRANSFERENCIA);
        }
    }

    public void cambioEstadoTransferenciaMesa(int opcionSeleccionada, TransferenciaMesa transferencia) {
        Mozo mozoEmisor = transferencia.getMozoEmisor();
        Mozo mozoReceptor = transferencia.getMozoReceptor();
        if (opcionSeleccionada == 0) {
            transferencia.cambiarEstado(TransferenciaAprobacionEnum.APROBADA);
            FachadaServicios.getInstance().notifyObservers(Observer.Eventos.CAMBIO_ESTADO_TRANSFERENCIA_APROBADA);
        } else {
            transferencia.cambiarEstado(TransferenciaAprobacionEnum.RECHAZADA);
            FachadaServicios.getInstance().notifyObservers(Observer.Eventos.CAMBIO_ESTADO_TRANSFERENCIA_RECHAZADA);
        }
    }

    public void tramitarTransfernciaMesa(Mozo mozo) throws MesaException {
        TransferenciaMesa transferencia = mozo.getTransferenciaEmitida();
        Mozo mozoReceptor = transferencia.getMozoReceptor();
        Mesa mesa = transferencia.getMesa();

        if (transferencia.getEstado().equals(TransferenciaAprobacionEnum.APROBADA)) {
            //agrega mesa al mozo receptor
            mozoReceptor.agregarMesa(mesa);
            //quita mesa al mozo emisor
            mozo.quitarMesa(mesa);
            mozo.quitarTransferenciaEmitida();
            FachadaServicios.getInstance().notifyObservers(Observer.Eventos.TRANSFERENCIA_CONCLUIDA);
        }
        if (transferencia.getEstado().equals(TransferenciaAprobacionEnum.RECHAZADA)) {
            //deja vacio el transfernciaRecepcion
            mozoReceptor.quitarTransferenciaRecepcion();
            //quita mesa al mozo emisor
            mozo.quitarTransferenciaEmitida();
        }
    }

    public void eliminarTransferencias(TransferenciaMesa transferenciaRecepcion) {
        //Mozo emisor= transferenciaRecepcion.getMozoEmisor();
        Mozo receptor = transferenciaRecepcion.getMozoReceptor();

        receptor.quitarTransferenciaRecepcion();
    }

    public ArrayList<Mesa> conjuntoMesasDeMozo(Mozo mozo) {
        return mozo.getMesas();
    }

    public void abrirMesa(Mesa mesa) throws MesaException {
        mesa.abrirMesa();
    }

    public boolean mesaEstaAbierta(Mesa mesa) {
        return mesa.isAbierta();
    }

    private boolean validarString(String exReg, String cadena){
        Pattern pat = Pattern.compile(exReg);
        Matcher mat = pat.matcher(cadena);
        boolean match=false;
        if (mat.matches()) {
            match=true;
        }
     return match;
    }
    
    public Cliente buscarCliente(String nroCliente) throws AgregarClienteMesaException{
        String exReg="^[0-9]+$";
        if(validarString(exReg, nroCliente)){
            int parserNroCli= Integer.parseInt(nroCliente);
            boolean encontre= false;
            int aux=0;
            Cliente cliente= null;

            while(!encontre && aux < todosLosClientes.size()){
                Cliente cli= todosLosClientes.get(aux);
                if(parserNroCli == cli.getId()){
                    encontre= true;
                    cliente = cli;
                }
                aux++;
            }  
            return cliente;
        }else{
            throw new AgregarClienteMesaException("Tipo de dato invalido, ingrese un numero");
        }
    }

    public Mesa buscarMesaAsociada(ItemServicio isBuscado) {
        boolean encontre = false;
        int aux = 0;
        Mesa mesa = null;

        while (!encontre && aux < mesas.size()) {
            Servicio ser = mesas.get(aux).getServicio();
            for (ItemServicio is : ser.getItems()) {
                if (is == isBuscado) {
                    encontre = true;
                    mesa = mesas.get(aux);
                }
                aux++;
            }
        }
        return mesa;
    }

    public Mesa finalizaronMiPedido(Mozo mozo) {
        Mesa mesa = null;
        boolean esLaMesa = false;
        int i = 0;
        while (i < mozo.getMesas().size() && esLaMesa) {
            Mesa m = mozo.getMesas().get(i);
            if (m.isAbierta()) {
                boolean encontre = false;
                int aux = 0;
                while (aux < m.getServicio().getItems().size() && !encontre) {
                    ItemServicio is = m.getServicio().getItems().get(aux);
                    if (is.getEstado().equals(EstadoItemEnum.FINALIZADO) && is.isActualizado()) {
                        mesa = m;
                        encontre = true;
                        esLaMesa = true;
                    }
                    aux++;
                }
            }
        }
        return mesa;
    }

    public ItemServicio isFinalizado(Mesa mesa) {
        ItemServicio finalizado=null;
        for(ItemServicio is : mesa.getServicio().getItems()){
            if(is.getEstado().equals(EstadoItemEnum.FINALIZADO) && is.isActualizado()){
                finalizado=is;
            }
        }
        return finalizado;
    }

    public ArrayList<DetalleBeneficiosAplicados> beneficiosAplicados(Mesa mesa) {
        return mesa.detalleBeneficiosAplicados();
    }

    public float totalDescuentos(ArrayList<DetalleBeneficiosAplicados> beneficiosAplicados) {
       float total=0; 
       for(DetalleBeneficiosAplicados dba : beneficiosAplicados){
           total+= dba.getMontoDescontado();
       }
       return total;
    }

    public float totalPagar(float totalDescuentos, float montoSinDescuentos) {
        return montoSinDescuentos-totalDescuentos;
    }

}
