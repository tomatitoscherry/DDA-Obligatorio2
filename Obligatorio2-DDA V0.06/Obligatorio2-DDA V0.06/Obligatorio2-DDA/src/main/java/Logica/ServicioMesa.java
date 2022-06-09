package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Logica.observer.Observer;
import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Producto;
import dominio.Servicio;
import exceptions.AgregarProductoServicioException;
import java.util.ArrayList;
import java.lang.Exception;

/**
 *
 * @author Admin
 */
public class ServicioMesa {
    ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    ArrayList<Producto> todosLosProductos = new ArrayList<Producto>();
    
    
    public void agregarMesa(int numero){
        //Logica para agregar mesa, no lo usa usuario
    }
    
    void agregarProducto(int codigo, String nombre, float precioUnidad, int stock) {
         //Logica para agregar producto, no lo usa usuario
    }
    
    public void cerrarMesa(Mozo mozo, Mesa mesa){
        mozo.quitarMesa(mesa);
        mesa.cerrarMesa();
        //2) El sistema muestra los datos del servicio de la mesa.
        //3) El mozo indica que desea cerrar la mesa.
        //4) Opcionalmente el mozo ingresa el id del cliente (Si el cliente es un cliente registrado).
        //5) Si el mozo ingreso un id de cliente, el sistema aplica el beneficio correspondiente al
        //cliente, muestra el nombre del cliente, el monto total sin beneficio aplicado, un texto que
        //describe el beneficio aplicado (“Café invitación” p.ej.) el monto del beneficio aplicado y el
        //monto total a pagar.
        //6) El sistema cierra la mesa

    }
      
    public Servicio mostrarServiciosMesa(Mesa mesa){
       return mesa.getServicio();
    }
    
    
    ArrayList<Producto> mostrarProductosDisponibles() {
        ArrayList<Producto> productosConStock = new ArrayList<Producto>();
        for(Producto p : todosLosProductos){
            if (p.getStock() > 0){
                productosConStock.add(p);
            }
        }
        return productosConStock;
    }
      
    public ItemServicio agregarProductoAServicio(Mesa mesa, Producto producto, int cantidad, String descripcion) throws AgregarProductoServicioException{
        if(cantidad > producto.getStock()){
          //  “Sin stock, solo quedan (n)”
          throw new AgregarProductoServicioException("Sin stock, solo quedan "+producto.getStock());
        } else if (cantidad <= 0){
            //  “cantidad inválida”
            throw new AgregarProductoServicioException("Cantidad inválida");
        } else if (this.mesaEstaAbierta(mesa)){
            // “La mesa está cerrada”
            throw new AgregarProductoServicioException("La mesa está cerrada");
        } else {
            producto.actualizarStock(cantidad);
            ItemServicio is = new ItemServicio(cantidad, descripcion, producto);
            mesa.getServicio().agregarItem(is);
            return is;
        }
    }
    
    public void transferirMesa(Mesa mesa, Mozo mozo){
        //transfiere mesa a otro mozo. faltan varias funciones internas no explicitas en la letra que serian creadas luego de analizar la IU como seria.
    }

    ArrayList<Mesa> conjuntoMesasDeMozo(Mozo mozo) {
        return mozo.getMesas();
    }

    public void abrirMesa(Mesa mesa, Mozo mozo) {
        if(!mesa.isAbierta()){
            mesa.abrirMesa();
            Servicio servicio = new Servicio();
            mesa.setServicio(servicio);
            //mozo.agregarMesa(mesa); cuando se abre la mesa es una mesa que ya pertence al mozo, 
            //por tanto no se le debe agregar.
        }
        
    }

    boolean mesaEstaAbierta(Mesa mesa) {
       return mesa.isAbierta();
    }



}
