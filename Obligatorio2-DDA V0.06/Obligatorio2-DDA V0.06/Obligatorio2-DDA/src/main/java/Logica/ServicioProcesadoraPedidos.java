package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Producto;
import dominio.Servicio;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServicioProcesadoraPedidos {
    
    //lista que tiene todos los pedidos generados
    ArrayList<Servicio> pedidosMonitor = new ArrayList<>();
    
    public void agregarUnidadProcesadora(){
     //agrega unidad procesadora, no lo usa ususario.
    }
    
    public void tomarPedido(Servicio servicio){
        //cuando se toma un pedido se le asigna a un gestor y se quita de la lista de pedidosMonitor(la lista global)
    }
    
      public String finalizarPedido(Servicio servicio){
                //cuando se finaliza un pedido se le asigna a un gestor y se quita de la lista de pedidos del gestor que tomo el pedido. 
                // y devuelve un string mostrando el nombre del producto, la cantidad y el número de mesa
            return null;
    }

    void agregarProducto(ItemServicio is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
