/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import dominio.Beneficio;
import dominio.Cliente;
import dominio.ClienteComun;
import dominio.ClienteDeLaCasa;
import dominio.ClientePreferencial;
import dominio.Mesa;
import dominio.Mozo;
import exceptions.MesaException;

/**
 *
 * @author yamil
 */
public class DatosPrueba {
    
    public static void cargar() throws MesaException{
        
        FachadaServicios fachada= FachadaServicios.getInstance();
        
        /////////////////////////////////////////////////////////
        //            // DATOS MOZOS                          //
        ////////////////////////////////////////////////////////
        
        Mozo mozo1= new Mozo("M.Martinez", "ABC123", "Mariana Martinez", "091445566");
        Mozo mozo2= new Mozo("A.Rolon", "ABC123", "Alberto Rolon", "098554466");
        Mozo mozo3= new Mozo("G.Perez", "ABC123", "Gonzalo Perez", "094336588");
        Mozo mozo4= new Mozo("A.Cuadrado", "ABC123", "Alicia Cuadrado", "099885544");
        
        fachada.agregarMozo(mozo1);
        fachada.agregarMozo(mozo2);
        fachada.agregarMozo(mozo3);
        fachada.agregarMozo(mozo4);
        
        ///////////////////////
        //    //MESAS        //
        ///////////////////////
        
        Mesa mesa1= new Mesa(1);
        Mesa mesa2= new Mesa(2);
        Mesa mesa3= new Mesa(3);
        Mesa mesa4= new Mesa(4);
        Mesa mesa5= new Mesa(5);
        Mesa mesa6= new Mesa(6);
        Mesa mesa7= new Mesa(7);
        Mesa mesa8= new Mesa(8);
        Mesa mesa9= new Mesa(9);
        Mesa mesa10= new Mesa(10);
        Mesa mesa11= new Mesa(11);
        Mesa mesa12= new Mesa(12);
        
        fachada.agregarMesa(mozo1, mesa1);
        fachada.agregarMesa(mozo1, mesa2);
        fachada.agregarMesa(mozo1, mesa3);
        fachada.agregarMesa(mozo2, mesa4);
        fachada.agregarMesa(mozo2, mesa5);
        fachada.agregarMesa(mozo2, mesa6);
        fachada.agregarMesa(mozo2, mesa7);
        fachada.agregarMesa(mozo2, mesa8);
        fachada.agregarMesa(mozo3, mesa9);
        fachada.agregarMesa(mozo3, mesa10);
        fachada.agregarMesa(mozo3, mesa11);
        fachada.agregarMesa(mozo4, mesa12);
        
        /////////////////////////////////////////////////////////
        //            // DATOS CLIENTES                        //
        ////////////////////////////////////////////////////////
        
        Cliente cli1= new Cliente("Mauricio", "mauri@gmail.com", new ClienteComun());
        Cliente cli2= new Cliente("Adriana", "adri@gmail.com", new ClientePreferencial());
        Cliente cli3= new Cliente("Robert", "rob@gmail.com", new ClienteDeLaCasa());
        
        fachada.agregarCliente(cli1);
        fachada.agregarCliente(cli2);
        fachada.agregarCliente(cli3);
        
        ///////////////////////
        //    //BENEFICIOS   //
        ///////////////////////
        
        //FALTAN LOS BENEFICIOS POR PRODUCTO, HAY QUE PRECARGAR ESOS DATOS TAMBIEN
        
        Beneficio beneficio1= new Beneficio("Si el monto total del servicio supera los $2000 tienen un 5% de descuento sobre el total", 5, 2000);
        Beneficio beneficio2= new Beneficio("$500 de consumo gratis por servicio", 500);
        
        //falta metodo de agregar beneficio al cliente
    }
    
}
