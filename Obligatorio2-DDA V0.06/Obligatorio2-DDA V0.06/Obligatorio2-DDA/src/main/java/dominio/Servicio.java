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
public class Servicio {
    
    private ArrayList<ItemServicio> items= new ArrayList();
    private float montoSinBeneficio;
    private float montoTotal;
    
    public Servicio() {
        this.montoSinBeneficio=0;
        this.montoTotal=0;
    }

    public ArrayList<ItemServicio> getItems() {
        return items;
    }
    
    public void agregarItem(ItemServicio unItem){
        if(unItem!=null){
            items.add(unItem);
        }
    }

    public float getMontoSinBeneficio() {
        return montoSinBeneficio;
    }

    public float getMontoTotal() {
        return montoTotal;
    }
    
    public float montoTotalServicioSinBeneficioAplicado(){
        float total = 0;
        if(!items.isEmpty()){
            for(ItemServicio is : items){
                total= total+is.montoTotalItem();
            }
        }
        return total;
    }
    
    
}
