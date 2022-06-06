/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.Usuario;
import ui.DialogoLoginVista;

/**
 *
 * @author yamil
 */
public abstract class DialogoLoginControlador {
    
    private DialogoLoginVista vista;

    public DialogoLoginControlador(DialogoLoginVista vista) {
        this.vista = vista;
    }
    
    public abstract Usuario loguinUsuario(String nombreUsuario, String password);
    
    public void login(String nombreUsuario, String password){
        Usuario usuario= loguinUsuario(nombreUsuario, password);
        
        if(usuario == null){
            vista.mostrarError("Login incorrecto. Ingrese nuevamente sus credenciales");
        }else{
            vista.ejecutarCasoDeUsoInicial(usuario);
            vista.cerrarVista();
        }
    }
    
}
