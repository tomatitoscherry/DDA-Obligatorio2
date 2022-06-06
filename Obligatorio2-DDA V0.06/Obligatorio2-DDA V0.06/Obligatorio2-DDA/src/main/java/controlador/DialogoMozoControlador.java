/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.Mesa;
import dominio.Producto;
import dominio.Usuario;
import java.util.ArrayList;
import Logica.FachadaServicios;
import dominio.Sesion;
import ui.DialogoMozoVista;

/**
 *
 * @author yamil
 */
public class DialogoMozoControlador {
    
    private DialogoMozoVista vista;

    public DialogoMozoControlador(DialogoMozoVista vista) {
        this.vista = vista;
    }

    public void abrirMesa(Mesa mesa) {
        if(mesa == null){
            vista.mostrarError("Debe seleccionar una mesa");
        }else{
            //tiene que ir a fachada y pedir los datos de la mesa.
            //if(){
            //Si la mesa ya esta abierta, muestra un error
            //}else{
            //Si la mesa esta cerrada, se abre.
            //Para abrir el backend debe crear un nuevo servicio a la mesa
            //Se trae desde fachada la lista de productos disponibles y
            // se le pasa a la vista la lista de Productos disponibles actualizada
            //vista.cargarProductosDisponibles(productosDisponibles);
            //}
        }
    }

    public void agregarProductoAlServicio(Mesa mesa, Producto producto, String descripcion, int cantidad) {
        //if(mesa==null || producto==null || descripcion==null || cantidad==null){
            vista.mostrarError("No se puede agregar el pedido, debe completar todos los campos");
        //}else{
            
        //}
    }

    public void iniciarSesion(Sesion sesion) {
        FachadaServicios.getInstance().iniciar(sesion);
    }

}
