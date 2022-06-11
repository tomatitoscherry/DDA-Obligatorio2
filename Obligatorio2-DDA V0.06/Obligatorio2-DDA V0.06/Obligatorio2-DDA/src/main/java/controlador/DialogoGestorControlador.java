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
    DefaultTableModel dtm;
    
    public DialogoGestorControlador(DialogoGestorVista vista, Gestor gestor, UnidadProcesadora unidadProcesadora, DefaultTableModel dtm) {
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
        int col = dtm.getColumnCount();
        Object[] newRow = new Object[col];
        for(ItemServicio is : unidadProcesadora.getItemServicios()){
              newRow[0]= is.getProducto().getNombre();
              newRow[1]= is.getUnidades();
              newRow[2]= is.getDescripcion();
              newRow[3]= FachadaServicios.getInstance().buscarMesaAsociada(is).getNumero();
              newRow[4]= FachadaServicios.getInstance().buscarMozoAsociado(is).getNombreCompleto();
    
        }
        dtm.addRow(newRow);
        vista.cargarTabla();
    }

     public void vaciarTabla(){

        int col = dtm.getColumnCount();
        Object[] newRow = new Object[col];
        for(ItemServicio is : unidadProcesadora.getItemServicios()){
              newRow[0]= "";
              newRow[1]= "";
              newRow[2]= "";
              newRow[3]= "";
              newRow[4]= "";
    
        }
        dtm.addRow(newRow);
        vista.vaciarTabla();
    }
    
    //////////////////////////////////////////////////////////////////
    //   //*CU: Tomar un pedido                                     //               
    ////////////////////////////////////////////////////////////////// 

    public void tomarPedido(ItemServicio pedido){
        pedido.setGestor(gestor);
        pedido.setEstado(EstadoItemEnum.PREPARANDO);
        unidadProcesadora.removeItemServicio(pedido);
        gestor.setPedidos(pedido);
        vista.tomarPedido(pedido);
    }

    public Gestor getGestor() {
        return gestor;
    }
      
    @Override
    public void update(Observable source, Object event) {
        if(event.equals(Observer.Eventos.PEDIDOS_ACTUALIZADOS)){
            cargarTabla();
        }

        
    }
    
}
