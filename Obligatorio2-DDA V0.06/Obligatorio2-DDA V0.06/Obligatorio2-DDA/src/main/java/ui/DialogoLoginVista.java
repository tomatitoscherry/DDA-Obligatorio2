/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui;

import dominio.Usuario;

/**
 *
 * @author yamil
 */
public interface DialogoLoginVista {
    
    public void mostrarError(String mensaje);
    
    public void ejecutarCasoDeUsoInicial(Usuario usuario);
    
    public void cerrarVista();
}
