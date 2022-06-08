/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author yamil
 */
public class Beneficio {
    private static int contadorId=1;
    
    private int id;
    private String descripcion;
    private Producto producto;
    private float porcentaje;
    private int montoDescuento;

    public Beneficio(String descripcion, Producto producto) {
        this.id = contadorId;
        this.descripcion = descripcion;
        this.producto= producto;
        this.porcentaje=0;
        this.montoDescuento=0;
        contadorId++;
    }
    
    public Beneficio(String descripcion, float porcentaje) {
        this.id = contadorId;
        this.descripcion = descripcion;
        this.producto= null;
        this.porcentaje= porcentaje;
        this.montoDescuento=0;
        contadorId++;
    }

    public Beneficio(String descripcion, int montoDescuento){
        this.id = contadorId;
        this.descripcion = descripcion;
        this.producto= null;
        this.porcentaje= 0;
        this.montoDescuento= montoDescuento;
        contadorId++;
    }
    
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
