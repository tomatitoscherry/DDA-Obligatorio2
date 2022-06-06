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
    

    
    public Servicio() {
    
    }

    public ArrayList<ItemServicio> getItems() {
        return items;
    }
    
    public void agregarItem(ItemServicio unItem){
        if(unItem!=null){
            items.add(unItem);
        }
    }

    public float montoTotalServicio(){
        float total = 0;
        for(ItemServicio is : items){
                total= total+is.montoTotalItem();
            
        }

        return total;
    }
    
    
}
