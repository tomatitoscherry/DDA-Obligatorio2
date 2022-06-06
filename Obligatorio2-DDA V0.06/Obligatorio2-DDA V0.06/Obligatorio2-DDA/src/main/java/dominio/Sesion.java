/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Sesion {
    
    private Usuario usuario;
    
    private Date fechaAcceso;

    public Sesion(Usuario usuario, Date fechaAcceso) {
        this.usuario = usuario;
        this.fechaAcceso = fechaAcceso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFechaAcceso() {
        return fechaAcceso;
    }

    @Override
    public String toString() {
        //TODO: renderizar esto en la interfaz.
        return usuario.getNombreCompleto() + " " + fechaAcceso;
    }
}

