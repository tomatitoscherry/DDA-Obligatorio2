/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author yamil
 */
public class TipoCliente {
    
    protected ArrayList<Beneficio> beneficios;

    public TipoCliente() {
        this.beneficios= new ArrayList<Beneficio>();
    }

    public ArrayList<Beneficio> getBeneficios() {
        return beneficios;
    }
    
    public void agregarBeneficio(Beneficio unBeneficio){
        beneficios.add(unBeneficio);
    }

    protected ArrayList<DetalleBeneficiosAplicados> beneficiosAplicados(Servicio unServicio){
        ArrayList<DetalleBeneficiosAplicados> beneficiosAplicados= new ArrayList<DetalleBeneficiosAplicados>();
        
        for(Beneficio b : this.beneficios){
            if(b.getTipoBeneficio().equals(TipoBeneficioEnum.DESCUENTO_PRODUCTO)){
                int cantProdutos= buscarCantProductosBeneficio(b.getProducto().getCodigo(), unServicio);
                float montoDescontarProductos= (cantProdutos * b.getProducto().getPrecioUnidad());
                beneficiosAplicados.add(new DetalleBeneficiosAplicados(b, montoDescontarProductos));
                
            }else if(b.getTipoBeneficio().equals(TipoBeneficioEnum.DESCUENTO_DINERO)){
                float montoDescontarDinero= b.getMontoDescuento();
                beneficiosAplicados.add(new DetalleBeneficiosAplicados(b, montoDescontarDinero));
            
            }else if(b.getTipoBeneficio().equals(TipoBeneficioEnum.DESCUENTO_PORCENTAJE)){
                
                if(unServicio.montoServicio() >= b.getMontoMinimoDescuento()){
                    float montoDescontarPorcentaje= calcularMontoDescontarPorPorcentaje(b.getPorcentaje(), unServicio.montoServicio());
                    beneficiosAplicados.add(new DetalleBeneficiosAplicados(b, montoDescontarPorcentaje));
                }
            }
        } 
        return beneficiosAplicados;
    }
    
    private float calcularMontoDescontarPorPorcentaje(float porcentaje, float montoServicio){
       float p= porcentaje*montoServicio;
       return (p/100);
    }
    
    private int buscarCantProductosBeneficio(int codigo, Servicio unServicio) {
        int contador=0;
        for(ItemServicio is : unServicio.getItems()){
            if(is.getProducto().getCodigo() == codigo){
                contador=contador+is.getUnidades();
            }
        }
        return contador;
    }
}
