/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import exceptions.MesaException;
import java.util.ArrayList;

/**
 *
 * @author yamil
 */
public class Mozo extends Usuario{
    
    private String telefono;
    private ArrayList<Mesa> mesas;
    private TransferenciaMesa transferenciaRecepcion;
    private TransferenciaMesa transferenciaEmitida;

    public Mozo(String nombreUsuario, String contrasenia, String nombreCompleto, String telefono) {
        super(nombreUsuario, contrasenia, nombreCompleto);
        this.telefono = telefono;
        this.mesas= new ArrayList<Mesa>();
        this.transferenciaRecepcion= null;
        this.transferenciaEmitida= null;
    }

    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public TransferenciaMesa getTransferenciaRecepcion() {
        return transferenciaRecepcion;
    }

    public TransferenciaMesa getTransferenciaEmitida() {
        return transferenciaEmitida;
    }

    public void agregarMesa(Mesa unaMesa) throws MesaException{
        if(mesas.size()< 5){
             mesas.add(unaMesa);
        }else{
            throw new MesaException("No se pueden agregar mas mesas, tiene 5.");
        }
    }
    
    public int cantMesas(){
        return mesas.size();
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

    public boolean tengoMesasAbiertas() {
        boolean mesasAbiertas=false;
        if(!mesas.isEmpty()){
            int i=0;
            while(!mesasAbiertas && i<mesas.size()){
                Mesa mesa= mesas.get(i);
                if(mesa.isAbierta()){
                    mesasAbiertas=true;
                }  
                i++;
            }
        }
        return mesasAbiertas;
    }
    
    public void agregarTransferenciaRecepcion(TransferenciaMesa transferencia){
        this.transferenciaRecepcion=transferencia;
    }
    
    public void quitarTransferenciaRecepcion(){
        this.transferenciaRecepcion=null;
    }
    
    public void agregarTransferenciaEmitida(TransferenciaMesa transferencia){
        this.transferenciaEmitida=transferencia;
    }
    
    public void quitarTransferenciaEmitida(){
        this.transferenciaEmitida= null;
    }
}
