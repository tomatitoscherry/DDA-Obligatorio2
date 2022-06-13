/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import Logica.FachadaServicios;
import java.util.ArrayList;
import Logica.observer.Observable;
import Logica.observer.Observer;
import dominio.EstadoItemEnum;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.Sesion;
import dominio.UnidadProcesadora;
import exceptions.ServicioException;
import exceptions.MesaException;
import exceptions.PedidoException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ui.DialogoGestorVista;
import ui.DialogoMozoVista;

/**
 *
 * @author yamil
 */
public class DialogoGestorControlador implements Observer{
    
    private DialogoGestorVista vista;
    private Gestor gestor;
    private UnidadProcesadora unidadProcesadora;
    private Sesion sesion;
    
    public DialogoGestorControlador(DialogoGestorVista vista, Gestor gestor, UnidadProcesadora unidadProcesadora) {

        this.vista = vista;
        this.gestor= gestor;
        sesion = new Sesion(gestor, new Date());
        this.unidadProcesadora = unidadProcesadora;
        FachadaServicios.getInstance().iniciar(sesion);
        FachadaServicios.getInstance().addObserver(this);
        inicializarVista();


    }

    //////////////////////////////////////////////////////////////////
    //   //*CU:  Ingresar a la aplicación                           //               
    ////////////////////////////////////////////////////////////////// 
    
    private void inicializarVista() {
        cargarNombre();
        cargarTabla();
    }
    
    private void cargarNombre() {
        vista.cargarNombreGestor(gestor.getNombreCompleto());
    }
  
     
    public void cargarTabla(){
        vaciarTabla();
        vista.cargarTabla();

    }

     public void vaciarTabla(){
        vista.vaciarTabla();
    }
    
    //////////////////////////////////////////////////////////////////
    //   //*CU: Tomar un pedido                                     //               
    ////////////////////////////////////////////////////////////////// 

    public void tomarPedido(ItemServicio pedido) throws PedidoException{
        
        FachadaServicios.getInstance().setearPedidoParaGestor(pedido, gestor, unidadProcesadora);
        vista.cargarTabla();
    }

    public Gestor getGestor() {
        return gestor;
    }
      
    //////////////////////////////////////////////////////////////////
    //   //*CU: Finalizar un pedido                                 //               
    ////////////////////////////////////////////////////////////////// 
    
    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }
    
    
    public void finalizarPedido(ItemServicio pedido) throws PedidoException {
        FachadaServicios.getInstance().finalizarPedidoParaGestor(pedido, gestor);
      
        vista.finalizarPedido(pedido);
        
    }
       
    
    @Override
    public void update(Observable source, Object event) {
        if(event.equals(Observer.Eventos.PEDIDOS_ACTUALIZADOS)){
            cargarTabla();
        }

        
    }

 

}
