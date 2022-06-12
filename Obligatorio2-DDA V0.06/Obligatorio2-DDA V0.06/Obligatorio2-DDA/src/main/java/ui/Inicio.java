/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import Logica.DatosPrueba;
import exceptions.MesaException;

/**
 *
 * @author yamil
 */
public class Inicio {
    
    public static void main(String args[]) throws MesaException {
        
        try {
           DatosPrueba.cargar();
        } catch (MesaException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        new VentanaInicio().setVisible(true);
    }
}
