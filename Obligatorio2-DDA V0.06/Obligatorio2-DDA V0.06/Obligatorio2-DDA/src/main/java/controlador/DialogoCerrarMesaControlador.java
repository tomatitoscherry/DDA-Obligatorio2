/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Logica.FachadaServicios;
import dominio.Beneficio;
import dominio.Cliente;
import dominio.DetalleBeneficiosAplicados;
import dominio.Mesa;
import dominio.Mozo;
import exceptions.AgregarClienteMesaException;
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
    
    public void agregarCliente(String nroCliente) throws AgregarClienteMesaException {
        try{
           vista.desactivarActivarBotones(false);
           Cliente cli= buscarCliente(nroCliente);
            if(cli!=null){
                cargarDatosCliente(cli);
            }else{
                vista.mostrarError("No se encontró al cliente");
                vista.cerrarVista();
            }
        }catch(AgregarClienteMesaException ex){
            vista.mostrarError(ex.getMessage());
            vista.desactivarActivarBotones(true);
        }
        
    }
    
    public void noAgregarCliente(){
        vista.desactivarActivarBotones(false);
        Cliente cli= new Cliente();
        cargarDatosCliente(cli);
    }
    
    private void cargarDatosCliente(Cliente cli){
        this.mesa.agregarCliente(cli);
        float montoSinDescuentos= this.mesa.getServicio().montoServicio();
        ArrayList<DetalleBeneficiosAplicados> beneficiosAplicados= FachadaServicios.getInstance().beneficiosAplicados(this.mesa);
        float totalDescuentos= FachadaServicios.getInstance().totalDescuentos(beneficiosAplicados);
        float totalPagar= FachadaServicios.getInstance().totalPagar(totalDescuentos, montoSinDescuentos);
        
        vista.setLebelsDatosCli("Cliente: "+cli.getNombre());
        vista.cargarBeneficiosCliente(beneficiosAplicados);
        vista.setLabelsServicio(
            "Monto del servicio : $"+montoSinDescuentos,
            "Monto descuento por beneficios : $"+totalDescuentos,
            "Monto total a pagar : $"+totalPagar
        );
    }
    
    public Cliente buscarCliente(String nroCliente) throws AgregarClienteMesaException{
        return FachadaServicios.getInstance().buscarCliente(nroCliente);
    }

    public void cerrar() {
        mesa.limpiarMesa();
        vista.cerrarVista();
    }

}
