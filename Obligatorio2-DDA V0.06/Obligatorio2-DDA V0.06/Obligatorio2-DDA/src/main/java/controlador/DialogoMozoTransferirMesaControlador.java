/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Logica.FachadaServicios;
import Logica.observer.Observable;
import Logica.observer.Observer;
import dominio.Mesa;
import dominio.Mozo;
import java.util.ArrayList;
import ui.DialogoMozoTransferirMesaVista;

/**
 *
 * @author yamil
 */
public class DialogoMozoTransferirMesaControlador implements Observer{
    
    private Mozo mozo;
    private Mesa mesa;
    private DialogoMozoTransferirMesaVista vista;

    public DialogoMozoTransferirMesaControlador(DialogoMozoTransferirMesaVista vista, Mozo mozo, Mesa mesa) {
        this.vista = vista;
        this.mozo= mozo;
        this.mesa=mesa;
        FachadaServicios.getInstance().addObserver(this);
        setLabelInicio();
        cargarMozosConectados();
    }

    @Override
    public void update(Observable source, Object event) {
        if(event.equals(Observer.Eventos.SESIONES_ACTUALIZADAS)){
            cargarMozosConectados();
        }
    }

    private void setLabelInicio() {
        vista.setLabelInicio("Transfiriendo mesa "+mesa.getNumero());
    }

    private void cargarMozosConectados(){
        ArrayList<Mozo> mozosConectados = FachadaServicios.getInstance().getMozosConectados(mozo);
        vista.cargarMozosConectados(mozosConectados);
    }

    public void transferirMesa(Mozo mozoSeleccionado) {
        FachadaServicios.getInstance().transferirMesa(mozo, mesa, mozoSeleccionado);
        cerrarVista();
    }
    
    public void cerrarVista(){
        FachadaServicios.getInstance().deleteObserver(this);
        vista.cerrarVista();
    }
}
