package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Logica.observer.Observer;
import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Producto;
import dominio.Servicio;
import dominio.UnidadProcesadora;
import exceptions.ServicioException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServicioProcesadoraPedidos {
    
    //lista que tiene todos los pedidos generados
    ArrayList<Servicio> pedidosMonitor = new ArrayList<Servicio>();
    ArrayList<UnidadProcesadora> unidadesProcesadoras = new ArrayList<UnidadProcesadora>();
    
    //agrega unidad procesadora, no lo usa ususario.
    public void agregarUnidadProcesadora(UnidadProcesadora unaUnidadProcesadora){    
        unidadesProcesadoras.add(unaUnidadProcesadora);
    }
    
    public void tomarPedido(Servicio servicio){
        //cuando se toma un pedido se le asigna a un gestor y se quita de la lista de pedidosMonitor(la lista global)
    }
    
      public String finalizarPedido(Servicio servicio){
                //cuando se finaliza un pedido se le asigna a un gestor y se quita de la lista de pedidos del gestor que tomo el pedido. 
                // y devuelve un string mostrando el nombre del producto, la cantidad y el número de mesa
            return null;
    }

    void agregarProducto(ItemServicio is){
        Producto p= is.getProducto();
        for(UnidadProcesadora up : unidadesProcesadoras){
            if(up.equals(p.getUnidadProcesadora())){
                up.addItemServicio(is);
                FachadaServicios.getInstance().notifyObservers(Observer.Eventos.PEDIDOS_ACTUALIZADOS);
            }
        }
    }

    ArrayList<UnidadProcesadora> conjuntoUnidadesProcesadoras() {
        return unidadesProcesadoras;
    }
}
