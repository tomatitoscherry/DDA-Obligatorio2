/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controlador.DialogoLoginGestorControlador;
import dominio.Gestor;
import dominio.Usuario;
import java.awt.Frame;


/**
 *
 * @author ddauser
 */
public class DialogoLoginGestor extends DialogoLogin {

    public DialogoLoginGestor(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese sus credenciales de gestor");
        this.setControlador(new DialogoLoginGestorControlador(this));
    }

    @Override
    public void ejecutarCasoDeUsoInicial(Usuario usuario) {
        new DialogoGestorSeleccionarUnidadProcesadora((java.awt.Frame) this.getParent(), false, (Gestor) usuario).setVisible(true);
//        new DialogoGestor((java.awt.Frame) this.getParent(), false, (Gestor) usuario).setVisible(true);
    }

}
