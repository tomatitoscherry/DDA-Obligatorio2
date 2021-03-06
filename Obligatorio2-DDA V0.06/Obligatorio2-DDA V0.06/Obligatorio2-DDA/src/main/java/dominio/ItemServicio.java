/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import static dominio.EstadoItemEnum.EN_ESPERA;


/**
 *
 * @author yamil
 */
public class ItemServicio {

    
    private int unidades;
    private String descripcion;
    private Producto producto;
    private Gestor gestor;
    private boolean actualizado;

    private float subTotal;

    private EstadoItemEnum estado;

    public ItemServicio(int unidades, String descripcion, Producto producto) {
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.producto = producto;
        this.gestor = null;
        this.subTotal= montoTotalItem();
        this.estado= EstadoItemEnum.EN_ESPERA;
        this.actualizado= false;
    }
    
    public ItemServicio(){}

    public int getUnidades() {
        return unidades;
    }

    public boolean isActualizado() {
        return actualizado;
    }

    public void setActualizado(boolean actualizado) {
        this.actualizado = actualizado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestorInicial) {
        this.gestor = gestorInicial;
    }

    public float getSubTotal() {
        return subTotal;
    }

       @Override
    public String toString() {
       return unidades + " " + producto.getNombre();
    }
    
    
    
    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public EstadoItemEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoItemEnum estado) {
        this.estado = estado;
    }

    public float montoTotalItem(){
        float total=0;
        float precioUnidad=this.producto.getPrecioUnidad();
        if(precioUnidad!=0){
            total= this.unidades * precioUnidad;
        }
        return total;
    }
}
