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
public class Mozo extends Usuario{
    
    private String telefono;
    private ArrayList<Mesa> mesas= new ArrayList();

    public Mozo(String nombreUsuario, String contrasenia, String nombreCompleto, String telefono) {
        super(nombreUsuario, contrasenia, nombreCompleto);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void agregarMesa(Mesa unaMesa){
        if(mesas.size()< 5){
             mesas.add(unaMesa);
        }
    }
    
    public void quitarMesa(Mesa unaMesa){
        boolean esLaMesa= false;
        int i=0;
        while(!esLaMesa && i<mesas.size()){
            int numeroMesaI= mesas.get(i).getNumero();
            if(numeroMesaI == unaMesa.getNumero()){
                mesas.remove(i);
                esLaMesa= true;
            }
            i++;
        }
    }
}
