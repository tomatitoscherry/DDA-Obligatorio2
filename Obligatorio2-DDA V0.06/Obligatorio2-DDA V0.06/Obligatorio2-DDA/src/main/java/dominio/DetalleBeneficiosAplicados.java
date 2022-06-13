/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author yamil
 */
public class DetalleBeneficiosAplicados {
    
    private Beneficio beneficio;
    private float montoDescontado;

    public DetalleBeneficiosAplicados(Beneficio beneficio, float montoDescontado) {
        this.beneficio = beneficio;
        this.montoDescontado = montoDescontado;
    }

    public Beneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Beneficio beneficio) {
        this.beneficio = beneficio;
    }

    public float getMontoDescontado() {
        return montoDescontado;
    }

    public void setMontoDescontado(float montoDescontado) {
        this.montoDescontado = montoDescontado;
    }

    @Override
    public String toString() {
        return beneficio + ", Monto descontado: " + montoDescontado;
    } 
    
}
