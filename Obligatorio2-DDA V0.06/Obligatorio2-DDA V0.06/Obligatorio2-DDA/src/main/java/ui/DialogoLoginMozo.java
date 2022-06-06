/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controlador.DialogoLoginMozoControlador;
import dominio.Mozo;
import java.awt.Frame;
import dominio.Usuario;

/**
 *
 * @author ddauser
 */
public class DialogoLoginMozo extends DialogoLogin {

    public DialogoLoginMozo(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese sus credenciales de mozo");
        this.setControlador(new DialogoLoginMozoControlador(this));
    }

    @Override
    public void ejecutarCasoDeUsoInicial(Usuario usuario) {
        new DialogoMozo((java.awt.Frame) this.getParent(), false, (Mozo) usuario).setVisible(true);
    }

}
