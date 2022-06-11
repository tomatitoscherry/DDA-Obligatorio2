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

    private float subTotal;

    private EstadoItemEnum estado;

    public ItemServicio(int unidades, String descripcion, Producto producto) {
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.producto = producto;
        this.gestor = null;
        this.subTotal= montoTotalItem();
        this.estado= EstadoItemEnum.EN_ESPERA;
    }

    public int getUnidades() {
        return unidades;
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

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public EstadoItemEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoItemEnum estado) {
        this.estado = estado;
    }
    
    /////////////////////////////////////////
    //El gestor inicial puede ser null cuando no lo han tomado, pero despues cuando pase al final,
    //Ninguno de los gestores va a ser null, por tanto siempre va a devolver el promer if, gestorInicial
    //Creo el getGestorActual() y cualquier cosa o discutimos
    //////////////////////////////////////
    /*public Gestor estadoItem(){
        if(this.gestorInicial != null){
            return this.gestorInicial; 
        } else if (this.gestorFinal != null){
            return this.gestorFinal;
        } else {
            //si devuelve null aun no ha sido tomado por un gestor.
            return null;
        }
    }*/
    
    
//    public Gestor getGestorActual(){
//        if(this.estado.equals(EstadoItemEnum.PREPARANDO)){
//            return this.gestorInicial; 
//        } else if (this.gestorFinal.equals(EstadoItemEnum.FINALIZADO)){
//            return this.gestorFinal;
//        } else {
//            //si devuelve null aun no ha sido tomado por un gestor.
//            return null;
//        }
//    }
    
    public float montoTotalItem(){
        float total=0;
        float precioUnidad=this.producto.getPrecioUnidad();
        if(precioUnidad!=0){
            total= this.unidades * precioUnidad;
        }
        return total;
    }
}
