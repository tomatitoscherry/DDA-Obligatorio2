/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author yamil
 */
public class Gestor extends Usuario{
    
    private ArrayList<ItemServicio> pedidosTomados;
    private Date ultimoAcceso;

    
    public Gestor(String nombreUsuario, String contrasenia, String nombreCompleto) {
        super(nombreUsuario, contrasenia, nombreCompleto);
        this.ultimoAcceso= null;
    }



    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    @Override
    public String toString() {
        return this.getNombreCompleto();
    }

    public ArrayList<ItemServicio> getPedidos() {
        return pedidosTomados;
    }

    public void setPedidosTomados(ItemServicio pedido) {
        this.pedidosTomados.add(pedido);
    }
    
        public void removePedidoTomado(ItemServicio pedido){
        this.pedidosTomados.remove(pedido);
    }
    
    
}
