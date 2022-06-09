/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author yamil
 */
public class ClienteComun extends TipoCliente{

    //Pagan $0 por todos los cafés consumidos en el servicio.
    //-------------------------------------------------------
    @Override
    public float calcularTotalDescuentoPorBeneficio(Servicio unServicio) {
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
                
                if(unServicio.getMontoSinBeneficio() >= b.getMontoMinimoDescuento()){
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
       total+=((montoDescontarPorcentaje*unServicio.getMontoSinBeneficio())/100);
       
       return total;
    }


}
