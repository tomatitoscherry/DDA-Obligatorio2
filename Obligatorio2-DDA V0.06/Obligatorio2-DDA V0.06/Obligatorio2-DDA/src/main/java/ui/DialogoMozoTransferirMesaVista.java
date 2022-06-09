/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui;

import dominio.Mozo;
import java.util.ArrayList;

/**
 *
 * @author yamil
 */
public interface DialogoMozoTransferirMesaVista {
    
    public void cerrarVista(); 
    public void mostrarError(String mensaje);
    public void cargarMozosConectados(ArrayList<Mozo> mozosConectados);
}
