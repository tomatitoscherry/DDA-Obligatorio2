/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Logica.FachadaServicios;
import dominio.Beneficio;
import dominio.Cliente;
import dominio.Mesa;
import java.util.ArrayList;
import ui.DialogoCerrarMesa;

/**
 *
 * @author yamil
 */
public class DialogoCerrarMesaControlador{
    
    private DialogoCerrarMesa vista;

    public DialogoCerrarMesaControlador(DialogoCerrarMesa vista) {
        this.vista = vista;
    }
    
    public Cliente buscarCliente(int nroCliente){
        Cliente cliente= FachadaServicios.getInstance().buscarCliente(nroCliente);
        if(cliente==null){
            vista.mostrarError("No se encontró al cliente");
        }
        return cliente;
    }

    public void agregarClienteMesa(Cliente cliente, Mesa mesa) {
        FachadaServicios.getInstance().agregarClienteMesa(cliente, mesa);
    }

    public void agregarClienteMesa(Mesa mesa) {
        FachadaServicios.getInstance().agregarClienteMesa(mesa);
    }

    public float calcularMontoTotalServicio(Mesa mesa) {
       return FachadaServicios.getInstance().calcularMontoTotalServicio(mesa);
    }
}
