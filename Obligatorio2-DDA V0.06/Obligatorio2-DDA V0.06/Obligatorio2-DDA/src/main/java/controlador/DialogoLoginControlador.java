/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.Usuario;
import exceptions.SesionDuplicada;
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
    
    public abstract Usuario loguinUsuario(String nombreUsuario, String password)throws SesionDuplicada;
    
    public void login(String nombreUsuario, String password) throws SesionDuplicada{
        try{
            Usuario usuario= loguinUsuario(nombreUsuario, password);
            if(usuario == null){
                vista.mostrarError("Nombre de usuario y/o contraseña incorrectos");
            }else{
                vista.ejecutarCasoDeUsoInicial(usuario);
                vista.cerrarVista();
            }
        }catch(SesionDuplicada e){
            vista.mostrarError(e.getMessage());
        }
    }
    
}
