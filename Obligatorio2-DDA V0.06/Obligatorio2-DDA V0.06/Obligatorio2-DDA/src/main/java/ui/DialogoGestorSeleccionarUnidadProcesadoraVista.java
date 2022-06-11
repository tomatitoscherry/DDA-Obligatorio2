/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui;

import dominio.Gestor;
import dominio.Mozo;
import dominio.UnidadProcesadora;
import java.util.ArrayList;

/**
 *
 * @author yamil
 */
public interface DialogoGestorSeleccionarUnidadProcesadoraVista {
    
    public void cerrarVista(); 
    
    public void mostrarError(String mensaje);
    
    public void setLabelInicio(String string);

    public void cargarListadoUnidadesProcesadoras(ArrayList<UnidadProcesadora> unidadesProcesadoras);

    public void callDialogoGestor(UnidadProcesadora unidadProcesadora, Gestor gestor);
    
    
}
