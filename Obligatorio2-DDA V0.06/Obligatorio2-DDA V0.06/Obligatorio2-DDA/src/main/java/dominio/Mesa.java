/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

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

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void cerrarMesa(){
        this.abierta = false;
    }
    
    public void abrirMesa(){
        this.abierta = true;
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
