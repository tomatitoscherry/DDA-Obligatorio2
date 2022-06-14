/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import exceptions.PedidoException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author yamil
 */
public class UnidadProcesadora {
    private static int contId=1;
    
    private int id;
    private String nombre;
    private ArrayList<Pedido> itemPedidos;
     
    public UnidadProcesadora (String nombre){
        this.nombre = nombre;
        this.id= contId;
        this.itemPedidos= new ArrayList<Pedido>();
        contId++;
    }
    
    public void addItemServicio(Pedido itemPedido){
        itemPedidos.add(itemPedido);
    }

    public void removeItemServicio(Pedido itemPedido){
        itemPedidos.remove(itemPedido);
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pedido> getItemPedidos(){
        
        return itemPedidos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public String toString() {
       return nombre;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadProcesadora other = (UnidadProcesadora) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    

}
