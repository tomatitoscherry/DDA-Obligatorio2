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
    private Gestor gestorInicial;
    private Gestor gestorFinal;
    private float subTotal;
    private EstadoItemEnum estado;

    public ItemServicio(int unidades, String descripcion, Producto producto) {
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.producto = producto;
        this.gestorInicial = null;
        this.gestorFinal = null;
        this.subTotal= montoTotalItem();
        this.estado= EstadoItemEnum.EN_ESPERA;
    }
    
    public ItemServicio(){}

    public int getUnidades() {
        return unidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public Gestor getGestorInicial() {
        return gestorInicial;
    }

    public Gestor getGestorFinal() {
        return gestorFinal;
    }

    public void setGestorInicial(Gestor gestorInicial) {
        this.gestorInicial = gestorInicial;
    }

    public void setGestorFinal(Gestor gestorFinal) {
        this.gestorFinal = gestorFinal;
    }

    public float getSubTotal() {
        return subTotal;
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

    
    public Gestor getGestorActual(){
        if(this.estado.equals(EstadoItemEnum.PREPARANDO)){
            return this.gestorInicial; 
        } else if (this.gestorFinal.equals(EstadoItemEnum.FINALIZADO)){
            return this.gestorFinal;
        } else {
            //si devuelve null aun no ha sido tomado por un gestor.
            return null;
        }
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
