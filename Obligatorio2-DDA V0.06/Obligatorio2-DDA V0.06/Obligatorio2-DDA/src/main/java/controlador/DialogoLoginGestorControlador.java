/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Logica.FachadaServicios;
import dominio.Usuario;
import ui.DialogoLoginVista;

/**
 *
 * @author yamil
 */
public class DialogoLoginGestorControlador extends DialogoLoginControlador{

    public DialogoLoginGestorControlador(DialogoLoginVista vista) {
        super(vista);
    }

    @Override
    public Usuario loguinUsuario(String nombreUsuario, String password) {
        return FachadaServicios.getInstance().loginGestor(nombreUsuario, password);
    }
    
}
