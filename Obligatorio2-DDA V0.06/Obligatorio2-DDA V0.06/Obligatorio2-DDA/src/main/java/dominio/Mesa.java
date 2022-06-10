/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import exceptions.MesaException;

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
        return abierta;
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
    
    public float calcularMontoTotalConBeneficios(){
        float totalServicio=this.servicio.montoServicio();
        float totalDescuentos= descuentoBeneficios();
        float totalPagar=0;
        if(totalDescuentos < totalServicio){
            totalPagar= totalServicio-totalDescuentos;
        }
        return totalPagar;
    }
    
    public float descuentoBeneficios(){
        return this.cliente.getTipoCliente().calcularDescuentoBeneficios(this.servicio);
    }
}
