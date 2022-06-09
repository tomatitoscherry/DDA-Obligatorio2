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
    
    private ArrayList<ItemServicio> items;
    
    public Servicio() {
        this.items= new ArrayList<ItemServicio>();
    }

    public ArrayList<ItemServicio> getItems() {
        return items;
    }
    
    public void agregarItem(ItemServicio unItem){
        if(unItem!=null){
            items.add(unItem);
        }
    }
    
    public float montoServicio(){
        float total = 0;
        if(!this.items.isEmpty()){
            for(ItemServicio is : this.items){
                total= total+is.montoTotalItem();
            }
        }
        return total;
    }
    
    public boolean pedidosPendientes(){
        boolean pedidosPendientes=false;
        int aux= 0;
        while(aux < this.items.size() && !pedidosPendientes){
            ItemServicio is= this.items.get(aux);
            if(is.getEstado().equals(EstadoItemEnum.EN_ESPERA) || is.getEstado().equals(EstadoItemEnum.PREPARANDO)){
                pedidosPendientes=true;
            }
            aux++;
        }
        
        return pedidosPendientes;
    }
}
