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
    private TipoBeneficioEnum tipoBeneficio;
    private Producto producto;
    private float porcentaje;
    private int montoDescuento;
    private int montoMinimoDescuento;

    public Beneficio(String descripcion, Producto producto) {
        this.id = contadorId;
        this.descripcion = descripcion;
        this.producto= producto;
        this.porcentaje=0;
        this.montoDescuento=0;
        this.tipoBeneficio= TipoBeneficioEnum.DESCUENTO_PRODUCTO;
        this.montoMinimoDescuento= 0;
        contadorId++;
    }
    
    public Beneficio(String descripcion, float porcentaje, int montoMinimoDescuento) {
        this.id = contadorId;
        this.descripcion = descripcion;
        this.producto= null;
        this.porcentaje= porcentaje;
        this.montoDescuento=0;
        this.tipoBeneficio= TipoBeneficioEnum.DESCUENTO_PORCENTAJE;
        this.montoMinimoDescuento= montoMinimoDescuento;
        contadorId++;
    }

    public Beneficio(String descripcion, int montoDescuento){
        this.id = contadorId;
        this.descripcion = descripcion;
        this.producto= null;
        this.porcentaje= 0;
        this.montoDescuento= montoDescuento;
        this.tipoBeneficio= TipoBeneficioEnum.DESCUENTO_DINERO;
        this.montoMinimoDescuento=0;
        contadorId++;
    }
    
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public int getMontoDescuento() {
        return montoDescuento;
    }

    public TipoBeneficioEnum getTipoBeneficio() {
        return tipoBeneficio;
    }

    public int getMontoMinimoDescuento() {
        return montoMinimoDescuento;
    }
}
