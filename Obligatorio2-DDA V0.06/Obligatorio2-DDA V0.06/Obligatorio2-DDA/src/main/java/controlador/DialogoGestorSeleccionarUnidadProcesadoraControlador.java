/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Logica.FachadaServicios;
import Logica.observer.Observable;
import Logica.observer.Observer;
import dominio.Gestor;
import dominio.UnidadProcesadora;
import java.util.ArrayList;
import ui.DialogoGestorSeleccionarUnidadProcesadoraVista;
import ui.DialogoMozoTransferirMesaVista;

/**
 *
 * @author yamil
 */
public class DialogoGestorSeleccionarUnidadProcesadoraControlador implements Observer {

    private Gestor gestor;
    private DialogoGestorSeleccionarUnidadProcesadoraVista vista;

    public DialogoGestorSeleccionarUnidadProcesadoraControlador(DialogoGestorSeleccionarUnidadProcesadoraVista vista, Gestor gestor) {
        this.vista = vista;
        this.gestor = gestor;
        FachadaServicios.getInstance().addObserver(this);
        setLabelInicio();
        cargarListaUnidadProcesadoras();
    }

    @Override
    public void update(Observable source, Object event) {
        if (event.equals(Observer.Eventos.SESIONES_ACTUALIZADAS)) {
            cargarListaUnidadProcesadoras();
        }
    }

    private void setLabelInicio() {
        vista.setLabelInicio("Seleccionando Unidad Procesadora");
    }

    public void cerrarVista() {
        FachadaServicios.getInstance().deleteObserver(this);
        vista.cerrarVista();
    }

    private void cargarListaUnidadProcesadoras() {
        ArrayList<UnidadProcesadora> unidadesProcesadoras = FachadaServicios.getInstance().conjuntoUnidadesProcesadoras();
        vista.cargarListadoUnidadesProcesadoras(unidadesProcesadoras);
    }

    public void continuarUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        if (unidadProcesadora == null) {
            vista.mostrarError("Debe seleccionar una Unidad Procesadora.");
        } else {
            vista.callDialogoGestor(unidadProcesadora, gestor);
            FachadaServicios.getInstance().deleteObserver(this);
            vista.cerrarVista();
        }

    }

}
