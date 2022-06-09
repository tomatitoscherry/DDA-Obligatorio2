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
import dominio.ItemServicio;
import dominio.Mozo;
import dominio.Servicio;
import dominio.Sesion;
import exceptions.AgregarProductoServicioException;
import ui.DialogoMozo;
import ui.DialogoMozoVista;

/**
 *
 * @author yamil
 */
public class DialogoMozoControlador{
    
    private DialogoMozoVista vista;
    
    public DialogoMozoControlador(DialogoMozoVista vista) {
        this.vista = vista;
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
    
    public boolean abrirMesa(Mesa mesa, Mozo mozo) {
        if(!FachadaServicios.getInstance().mesaEstaAbierta(mesa)){
            FachadaServicios.getInstance().abrirMesa(mesa, mozo);
            return true;
        }else{
            vista.mostrarError("La mesa ya está abierta");
            return false;
        }
    }
    
    public ArrayList<Producto> getProductosDisponibles(){
        return FachadaServicios.getInstance().mostrarProductosDisponibles(); 
    }
     
    public void agregarProductoAlServicio(Mesa mesa, Producto producto, String descripcion, int cantidad) throws AgregarProductoServicioException {
        try{
            FachadaServicios.getInstance().agregarProductoAServicio(mesa, producto, cantidad, descripcion);
        }catch(AgregarProductoServicioException e){
            vista.mostrarError(e.getMessage());
        }
    }

    public Servicio getServicioMesa(Mesa mesa) {
        return FachadaServicios.getInstance().mostrarServicioMesa(mesa);
    }
    
    public boolean mesaEstaAbierta(Mesa mesa){
        return FachadaServicios.getInstance().mesaEstaAbierta(mesa);
    }

}
