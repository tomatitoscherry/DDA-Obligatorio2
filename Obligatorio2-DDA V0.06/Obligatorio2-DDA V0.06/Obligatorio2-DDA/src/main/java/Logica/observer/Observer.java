/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.observer;

/**
 *
 * @author admin
 */
public interface Observer {
    
    public enum Eventos {
        SESIONES_ACTUALIZADAS,
        MESAS_ACTUALIZADAS
    }

    public void update(Observable source, Object event);

}
