/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import exceptions.ServicioException;

/**
 *
 * @author yamil
 */
public class Producto {
    private static int cont=1;
    
    private int codigo;
    private String nombre;
    private float precioUnidad;
    private int stock;
    private UnidadProcesadora unidadProcesadora;

    public Producto(String nombre, float precioUnidad, int stock, UnidadProcesadora up) {
        this.codigo = cont;
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
        this.stock = stock;
        this.unidadProcesadora = up;
        cont++;
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

    public void actualizarStock(int unidades) throws ServicioException {
        if(this.getStock() != 0 && this.getStock() >= unidades){
            this.stock = this.stock - unidades;
        }else{
            throw new ServicioException("Sin stock, solo quedan "+this.getStock());
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
