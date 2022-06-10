package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Logica.observer.Observer;
import dominio.Beneficio;
import dominio.Cliente;
import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Producto;
import dominio.Servicio;
import dominio.TransferenciaAprobacionEnum;
import dominio.TransferenciaMesa;
import exceptions.ServicioException;
import exceptions.MesaException;
import java.util.ArrayList;
import java.lang.Exception;

/**
 *
 * @author Admin
 */
public class ServicioMesa {
    ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    ArrayList<Producto> todosLosProductos = new ArrayList<Producto>();
    ArrayList<Cliente> todosLosClientes= new ArrayList<Cliente>();
    
    /////////////////////////////////////////////
    //      //Logica precarga de datos         //
    ////////////////////////////////////////////
    
    public void agregarMesa(int numero){
        //Logica para agregar mesa, no lo usa usuario
    }
    
    public void agregarProducto(int codigo, String nombre, float precioUnidad, int stock) {
         //Logica para agregar producto, no lo usa usuario
    }
    
    public void agregarCliente(Cliente cli){
        todosLosClientes.add(cli);
    }
    
    public void cerrarMesa(Mozo mozo, Mesa mesa){
        mozo.quitarMesa(mesa);
       // mesa.cerrarMesa();
        //2) El sistema muestra los datos del servicio de la mesa.
        //3) El mozo indica que desea cerrar la mesa.
        //4) Opcionalmente el mozo ingresa el id del cliente (Si el cliente es un cliente registrado).
        //5) Si el mozo ingreso un id de cliente, el sistema aplica el beneficio correspondiente al
        //cliente, muestra el nombre del cliente, el monto total sin beneficio aplicado, un texto que
        //describe el beneficio aplicado (“Café invitación” p.ej.) el monto del beneficio aplicado y el
        //monto total a pagar.
        //6) El sistema cierra la mesa

    }
      
    public Servicio getServiciosMesa(Mesa mesa){
       return mesa.getServicio();
    }
    
    
    public ArrayList<Producto> getProductosDisponibles() {
        ArrayList<Producto> productosConStock = new ArrayList<Producto>();
        for(Producto p : todosLosProductos){
            if (p.getStock() > 0){
                productosConStock.add(p);
            }
        }
        return productosConStock;
    }
      
    public ItemServicio agregarProductoAServicio(Mesa mesa, Producto producto, int cantidad, String descripcion) throws ServicioException{
        ItemServicio is;
        if(cantidad > producto.getStock()){
          //  “Sin stock, solo quedan (n)”
          throw new ServicioException("Sin stock, solo quedan "+producto.getStock());
        } else if (cantidad <= 0){
            //  “cantidad inválida”
            throw new ServicioException("Cantidad inválida");
        } else if (this.mesaEstaAbierta(mesa)){
            // “La mesa está cerrada”
            throw new ServicioException("La mesa está cerrada");
        } else {
            producto.actualizarStock(cantidad);
            is = new ItemServicio(cantidad, descripcion, producto);
            mesa.getServicio().agregarItem(is);
            FachadaServicios.getInstance().notifyObservers(Observer.Eventos.PEDIDOS_ACTUALIZADOS);
        }
        return is;
    }
    
    public void transferirMesa(Mesa mesa, Mozo mozo, Mozo mozoSeleccionado){
        TransferenciaMesa unaTransferencia= new TransferenciaMesa(mozo, mozoSeleccionado, mesa);
        if(mozoSeleccionado.cantMesas()<5){
            mozoSeleccionado.agregarTransferenciaRecepcion(unaTransferencia);
            mozo.agregarTransferenciaEmitida(unaTransferencia);
            FachadaServicios.getInstance().notifyObservers(Observer.Eventos.NUEVA_TRANSFERENCIA);
        }
    }
    
    public void cambioEstadoTransferenciaMesa(int opcionSeleccionada, TransferenciaMesa transferencia) {
        Mozo mozoEmisor= transferencia.getMozoEmisor();
        Mozo mozoReceptor= transferencia.getMozoReceptor();
        if(opcionSeleccionada==0){
            transferencia.cambiarEstado(TransferenciaAprobacionEnum.APROBADA);
        }else{
            transferencia.cambiarEstado(TransferenciaAprobacionEnum.RECHAZADA);
        }
        FachadaServicios.getInstance().notifyObservers(Observer.Eventos.CAMBIO_ESTADO_TRANSFERENCIA);
    }  
    
    public void tramitarTransfernciaMesa(Mozo mozo) throws MesaException {
        TransferenciaMesa transferencia= mozo.getTransferenciaEmitida();
        Mozo mozoReceptor= transferencia.getMozoReceptor();
        
        if(transferencia.getEstado().equals(TransferenciaAprobacionEnum.APROBADA)){
            //agrega mesa al mozo receptor
            mozoReceptor.agregarMesa(transferencia.getMesa());
            //deja vacio el transfernciaRecepcion
            mozoReceptor.quitarTransferenciaRecepcion();
            //quita mesa al mozo emisor
            mozo.quitarMesa(transferencia.getMesa());
            //deja vacio el transferenciaEmitida
            mozo.quitarTransferenciaEmitida();
            
        }else if(transferencia.getEstado().equals(TransferenciaAprobacionEnum.RECHAZADA)){
            //deja vacio el transfernciaRecepcion
            mozoReceptor.quitarTransferenciaRecepcion();
            //quita mesa al mozo emisor
            mozo.quitarMesa(transferencia.getMesa());
        }
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

    public Cliente buscarCliente(int nroCliente) {
        boolean encontre= false;
        int aux=0;
        Cliente cliente= null;
        
        while(!encontre && aux < todosLosClientes.size()){
            Cliente cli= todosLosClientes.get(aux);
            if(nroCliente == cli.getId()){
                encontre= true;
                cliente = cli;
            }
            aux++;
        }  
        return cliente;
    }

}
