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
    
    public Servicio getServiciosMesa(Mesa mesa){
       return mesa.getServicio();
    }
    
    /////////////////////////////////////////////
    //      //Logica precarga de datos         //
    ////////////////////////////////////////////
    
    public void agregarMesa(Mozo mozo, Mesa mesa) throws MesaException {
        mesas.add(mesa);
        mozo.agregarMesa(mesa);
    }
    
    public void agregarCliente(Cliente cli){
        todosLosClientes.add(cli);
    }
    
    public void agregarProductos(Producto producto){
        todosLosProductos.add(producto);
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //                   //LOGICA PROYECTO                                       //
    //////////////////////////////////////////////////////////////////////////////
    
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
       System.out.println("Estoy en servicio mesa");
        ItemServicio is;
        if(cantidad > 0){
            System.out.println("Cantidad > 0");
            if(cantidad <= producto.getStock()){
                System.out.println("Cantidad < STOCK");
                System.out.println(mesa);
                System.out.println(producto);
                if(cantidad > 0){
                    System.out.println("MESA ABIERTA");
                    System.out.println("Pase todos los if, voy a actualizar stock");
                    producto.actualizarStock(cantidad);
                    is = new ItemServicio(cantidad, descripcion, producto);
                    mesa.getServicio().agregarItem(is);
                    FachadaServicios.getInstance().notifyObservers(Observer.Eventos.STOCK_ACTUALIZADO);     
                }else{
                    System.out.println("La mesa está cerrada");
                    throw new ServicioException("La mesa está cerrada");
                }
            }else{
                System.out.println("Sin stock, solo quedan "+producto.getStock());
                throw new ServicioException("Sin stock, solo quedan "+producto.getStock());
            }
        }else{
            System.out.println("Cantidad inválida");
            throw new ServicioException("Cantidad inválida");
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

    public Mesa buscarMesaAsociada(ItemServicio isBuscado) {
        boolean encontre= false;
        int aux=0;
        Mesa mesa= null;
        
        while(!encontre && aux < mesas.size()){
            Servicio ser = mesas.get(aux).getServicio();
            for (ItemServicio is : ser.getItems()){
                if(is == isBuscado){
                    encontre= true;
                    mesa = mesas.get(aux);
                }
                aux++;
            }
        }  
        return mesa;
    }

}
