/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author yamil
 */
public class Mesa {
    
    private int numero;
    private boolean abierta;
    private Servicio servicio;

    public Mesa(int numero) {
        this.numero = numero;
        this.abierta = false;
        this.servicio = null;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public void cerrarMesa(){
        this.abierta = false;
    }
    
    public void abrirMesa(){
        this.abierta = true;
    }
}
