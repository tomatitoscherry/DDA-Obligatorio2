/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author yamil
 */
public class Producto {
    
    private int codigo;
    private String nombre;
    private float precioUnidad;
    private int stock;
    private UnidadProcesadora unidadProcesadora;

    public Producto(int codigo, String nombre, float precioUnidad, int stock, UnidadProcesadora up) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
        this.stock = stock;
        this.unidadProcesadora = up;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public int getStock() {
        return stock;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }
    
    public void bajarStock(int cant){
        //baja la cant de stock
    }
    
    public void actualizarStock(int unidades){
        if(this.getStock() != 0 && this.getStock() >= unidades){
            this.stock = this.stock - unidades;
        }
    }
}
