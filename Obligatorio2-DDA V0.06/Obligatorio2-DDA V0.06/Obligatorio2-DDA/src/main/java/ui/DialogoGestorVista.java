/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui;

import dominio.ItemServicio;
import dominio.Pedido;
import java.util.ArrayList;


/**
 *
 * @author yamil
 */
public interface DialogoGestorVista {

    public void cargarNombreGestor(String nombreCompleto);

    public void tomarPedido();

    public void finalizarPedido();

    public void cargarTabla(ArrayList<Pedido> pedidos);

    public void mostrarError(String message);

    public void cargarPedidosGestor(ArrayList<Pedido> pedidos);

    public void vaciarTabla();

    public void cerrarVista();
   
}
