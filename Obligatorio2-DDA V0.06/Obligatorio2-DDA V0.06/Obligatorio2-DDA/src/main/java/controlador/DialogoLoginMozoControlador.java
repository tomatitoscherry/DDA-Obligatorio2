/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.Usuario;
import Logica.FachadaServicios;
import ui.DialogoLoginVista;

/**
 *
 * @author yamil
 */
public class DialogoLoginMozoControlador extends DialogoLoginControlador{

    public DialogoLoginMozoControlador(DialogoLoginVista vista) {
        super(vista);
    }

    @Override
    public Usuario loguinUsuario(String nombreUsuario, String password) {
        return FachadaServicios.getInstance().loginMozo(nombreUsuario, password);
    }
    
}
