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
public abstract class TipoCliente {
    
    protected ArrayList<Beneficio> beneficios;

    public TipoCliente() {
        this.beneficios= new ArrayList<Beneficio>();
    }

    public ArrayList<Beneficio> getBeneficios() {
        return beneficios;
    }
    
    public void agregarBeneficio(Beneficio unBeneficio){
        beneficios.add(unBeneficio);
    }
    
    public abstract float calcularDescuentoBeneficios(Servicio unServicio);
    
}
