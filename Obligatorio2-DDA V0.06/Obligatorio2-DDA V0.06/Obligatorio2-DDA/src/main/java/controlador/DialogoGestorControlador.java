/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import Logica.FachadaServicios;
import java.util.ArrayList;
import Logica.observer.Observable;
import Logica.observer.Observer;
import dominio.Gestor;
import dominio.Sesion;
import dominio.UnidadProcesadora;
import exceptions.ServicioException;
import exceptions.MesaException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    }
    
    private void cargarNombre() {
        vista.cargarNombreGestor(gestor.getNombreCompleto());
    }

//    public void cargarUnidadesProcesadoras() {
//        ArrayList<UnidadProcesadora> listaUnidadesProcesadoras = FachadaServicios.getInstance().conjuntoUnidadesProcesadoras();
//        vista.cargarUnidadesProcesadoras();
//    }
    
    //////////////////////////////////////////////////////////////////
    //   //*CU: Tomar un pedido                                     //               
    ////////////////////////////////////////////////////////////////// 

    
    
    
    @Override
    public void update(Observable source, Object event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
