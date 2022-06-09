/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author yamil
 */
public class UnidadProcesadora {
    private String nombre;
    private ArrayList<ItemServicio> itemServicios;
     
    public UnidadProcesadora (String nombre){
        this.nombre = nombre;
        this.itemServicios= new ArrayList<ItemServicio>();
    }
    
    public void addItemServicio(ItemServicio itemServicio){
        itemServicios.add(itemServicio);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<ItemServicio> getItemServicios() {
        return itemServicios;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadProcesadora other = (UnidadProcesadora) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
}
