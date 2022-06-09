/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author yamil
 */
public class ClientePreferencial extends TipoCliente{

    //Pagan $0 por todas las aguas minerales consumidas en el servicio y si el 
    //monto total del servicio supera los $2000 tienen un 5% de descuento sobre el total.
    //------------------------------------------------------------------------------------
    @Override
    public float calcularDescuentoBeneficios(Servicio unServicio) {
         float total=0;
        float montoDescontarProductos= 0;
        float montoDescontarDinero= 0;
        float montoDescontarPorcentaje=0;
                
        for(Beneficio b : this.beneficios){
            if(b.getTipoBeneficio().equals(TipoBeneficioEnum.DESCUENTO_PRODUCTO)){
                int cantProdutos= buscarCantProductosBeneficio(b.getProducto().getCodigo(), unServicio);
                montoDescontarProductos+= (cantProdutos * b.getProducto().getPrecioUnidad());
                
            }else if(b.getTipoBeneficio().equals(TipoBeneficioEnum.DESCUENTO_DINERO)){
                montoDescontarDinero+= b.getMontoDescuento();
            
            }else if(b.getTipoBeneficio().equals(TipoBeneficioEnum.DESCUENTO_PORCENTAJE)){
                
                if(unServicio.montoServicio() >= b.getMontoMinimoDescuento()){
                    montoDescontarPorcentaje+=b.getPorcentaje();
                }
            }
        }
        
        total= calcularTotalDescuento(montoDescontarProductos, montoDescontarDinero, montoDescontarPorcentaje, unServicio);
        return total;
    }
    
    private int buscarCantProductosBeneficio(int codigo, Servicio unServicio) {
        int contador=0;
        for(ItemServicio is : unServicio.getItems()){
            if(is.getProducto().getCodigo() == codigo){
                contador++;
            }
        }
        return contador;
    }

    private float calcularTotalDescuento(float montoDescontarProductos, float montoDescontarDinero, float montoDescontarPorcentaje, Servicio unServicio) {
       float total=0;
       
       total+=montoDescontarProductos;
       total+=montoDescontarDinero;
       total+=((montoDescontarPorcentaje*unServicio.montoServicio())/100);
       
       return total;
    }
}
