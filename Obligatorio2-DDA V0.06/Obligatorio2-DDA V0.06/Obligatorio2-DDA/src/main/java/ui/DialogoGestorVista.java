/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui;

import dominio.ItemServicio;


/**
 *
 * @author yamil
 */
public interface DialogoGestorVista {

    public void cargarNombreGestor(String nombreCompleto);

    public void cargarTabla();

    public void tomarPedido();

    public void vaciarTabla(); 

    public void finalizarPedido(ItemServicio pedido);
   
}
