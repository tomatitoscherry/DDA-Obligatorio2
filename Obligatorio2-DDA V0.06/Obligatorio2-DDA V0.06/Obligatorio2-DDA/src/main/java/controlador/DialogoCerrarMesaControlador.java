/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Logica.FachadaServicios;
import dominio.Beneficio;
import dominio.Cliente;
import dominio.Mesa;
import dominio.Mozo;
import java.util.ArrayList;
import ui.DialogoCerrarMesa;

/**
 *
 * @author yamil
 */
public class DialogoCerrarMesaControlador{
    
    private DialogoCerrarMesa vista;
    private Mozo mozo;
    private Mesa mesa;

    public DialogoCerrarMesaControlador(DialogoCerrarMesa vista, Mozo mozo, Mesa mesa) {
        this.vista = vista;
        this.mozo = mozo;
        this.mesa = mesa;
        inicializarVista(mesa);
    }
    
    private void inicializarVista(Mesa mesa) {
        vista.inicializarVista(mesa);
    }
    
    public void agregarCliente(int nroCliente) {
        if(nroCliente!=-1){
            Cliente cli= buscarCliente(nroCliente);
            if(cli!=null){
                vista.desactivarBotones();
                this.mesa.agregarCliente(cli);
                vista.setLebelsDatosCli("Cliente: "+cli.getNombre());
                vista.cargarBeneficiosCliente(cli.getTipoCliente().getBeneficios());
                vista.setLabelsServicio(
                        "Monto del servicio : $"+this.mesa.getServicio().montoServicio(),
                        "Monto descuento por beneficios : $"+this.mesa.descuentoBeneficios(),
                        "Monto total a pagar : $"+this.mesa.calcularMontoTotalConBeneficios()
                    );   
            }else{
                vista.mostrarError("No se encontró al cliente");
                vista.cerrarVista();
            }
        }else{
            Cliente cli= new Cliente();
            this.mesa.agregarCliente(cli);
            vista.desactivarBotones();
            vista.setLebelsDatosCli("Cliente sin registrar");
            vista.cargarBeneficiosCliente(cli.getTipoCliente().getBeneficios());
            vista.setLabelsServicio(
                    "Monto del servicio : $"+this.mesa.getServicio().montoServicio(),
                    "Monto descuento por beneficios : $"+this.mesa.descuentoBeneficios(),
                    "Monto total a pagar : $"+this.mesa.calcularMontoTotalConBeneficios()
                );  
        }
        
    }
    
    public Cliente buscarCliente(int nroCliente){
        return FachadaServicios.getInstance().buscarCliente(nroCliente);
    }

    public void cerrar() {
        mesa.limpiarMesa();
        vista.cerrarVista();
    }

}
