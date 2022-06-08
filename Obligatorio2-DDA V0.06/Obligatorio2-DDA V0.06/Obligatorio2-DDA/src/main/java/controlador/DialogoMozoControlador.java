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
import Logica.observer.Observable;
import Logica.observer.Observer;
import dominio.Mozo;
import dominio.Sesion;
import ui.DialogoMozo;
import ui.DialogoMozoVista;

/**
 *
 * @author yamil
 */
public class DialogoMozoControlador implements Observer{
    
    private DialogoMozoVista vista;
    
    public DialogoMozoControlador(DialogoMozoVista vista) {
        this.vista = vista;
        FachadaServicios.getInstance().addObserver((Observer) vista);
    }

    public void iniciarSesion(Sesion sesion) {
        FachadaServicios.getInstance().iniciar(sesion);
    }

    public ArrayList<Mesa> conjuntoMesasDeMozo(Mozo mozo) {
        return FachadaServicios.getInstance().conjuntoMesasDeMozo(mozo);
    }

    public String nombreCompletoMozo(Mozo mozo) {
        return FachadaServicios.getInstance().mostrarNombreCompletoMozo(mozo);
    }
    
    public void abrirMesa(Mesa mesa, Mozo mozo) {
        //Valido si mesa esta cerrada
        if(!FachadaServicios.getInstance().mesaEstaAbierta(mesa)){
            
        }else{
            vista.mostrarError("La mesa ya está abierta");
        }
        
        //FachadaServicios.getInstance().abrirMesa(mesa, mozo, cliente);
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
    
    public void agregarProductoAlServicio(Mesa mesa, Producto producto, String descripcion, int cantidad) {
        //if(mesa==null || producto==null || descripcion==null || cantidad==null){
            vista.mostrarError("No se puede agregar el pedido, debe completar todos los campos");
        //}else{
            
        //}
    }

    @Override
    public void update(Observable source, Object event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
