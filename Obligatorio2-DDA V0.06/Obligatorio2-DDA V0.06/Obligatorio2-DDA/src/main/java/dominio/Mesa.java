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
public class Mesa {
    
    private int numero;
    private boolean abierta;
    private Servicio servicio;
    private Cliente cliente;

    public Mesa(int numero) {
        this.numero = numero;
        this.abierta = false;
        this.servicio = null;
        this.cliente= null;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isAbierta() {
        return this.abierta;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void cerrarMesa() throws MesaException{
        if(this.isAbierta()){
            if(!servicio.pedidosPendientes()){
                this.abierta = false;
            }else{
                throw new MesaException("Tiene pedidos pendientes");
            }
        }else{
            throw new MesaException("La mesa no está abierta");
        }
    }
    
    public void abrirMesa() throws MesaException{
        if(!this.isAbierta()){
            this.abierta = true;
            this.servicio= new Servicio();
        }else{
            throw new MesaException("La mesa ya está abierta");
        }
    }
    
    public void agregarCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void limpiarMesa(){
        this.cliente= null;
        this.servicio=null;
    }
    
    public ArrayList<DetalleBeneficiosAplicados> detalleBeneficiosAplicados(){
        return this.cliente.getTipoCliente().beneficiosAplicados(this.servicio);
    }

    @Override
    public String toString() {
        return "Mesa "+ numero;
    }
}
