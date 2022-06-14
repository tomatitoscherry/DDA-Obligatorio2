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
import dominio.EstadoItemEnum;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Producto;
import dominio.TipoCliente;
import dominio.UnidadProcesadora;
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
        
        Mozo mozo1= new Mozo("A", "A", "Mariana Martinez", "091445566");
        Mozo mozo2= new Mozo("B", "B", "Alberto Rolon", "098554466");
        Mozo mozo3= new Mozo("C", "C", "Gonzalo Perez", "094336588");
        Mozo mozo4= new Mozo("D", "D", "Alicia Cuadrado", "099885544");

        fachada.agregarMozo(mozo1);
        fachada.agregarMozo(mozo2);
        fachada.agregarMozo(mozo3);
        fachada.agregarMozo(mozo4);

        
         ////////////////////////////////////////////////////////
         //            // DATOS GESTOR                         //
         ////////////////////////////////////////////////////////
        
        Gestor gestor1= new Gestor("E", "E", "Mauricio Vilar");
        Gestor gestor2= new Gestor("F", "F", "Yamila Reyes");
        Gestor gestor3= new Gestor("G", "G", "Marina Migues");
        Gestor gestor4= new Gestor("H", "H", "Minerva McGonagall");

        fachada.agregarGestor(gestor1);
        fachada.agregarGestor(gestor2);
        fachada.agregarGestor(gestor3);
        fachada.agregarGestor(gestor4);
        
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

        /////////////////////////////////////////////////////////////////////
        //            // DATOS UNIDADES PROCESADORAS                      //
        ///////////////////////////////////////////////////////////////////
        
        UnidadProcesadora up1= new UnidadProcesadora("Bar");
        UnidadProcesadora up2= new UnidadProcesadora("Cocina");
        UnidadProcesadora up3= new UnidadProcesadora("Barra sushi");
        
        FachadaServicios.getInstance().agregarUnidadProcesadora(up1);
        FachadaServicios.getInstance().agregarUnidadProcesadora(up2);
        FachadaServicios.getInstance().agregarUnidadProcesadora(up3);
        
        /////////////////////////////////////////////
        //            // PRODUCTOS                //
        ///////////////////////////////////////////
        
        Producto p1= new Producto("Milanesa", 300, 20, up2);
        Producto p2= new Producto("Fritas", 170, 30, up2);
        Producto p3= new Producto("Chivito", 500, 10, up2);
        Producto p4= new Producto("Pizza", 200, 15, up2);
        Producto p5= new Producto("Faina", 150, 5, up2);
        Producto p6= new Producto("Agua", 100, 30, up1);
        Producto p7= new Producto("Cafe", 130, 20, up1);
        Producto p8= new Producto("Refresco", 180, 5, up1);
        Producto p9= new Producto("Cerveza", 280, 30, up1);
        Producto p10= new Producto("Nigiri", 150, 30, up3);
        Producto p11= new Producto("Sushi", 230, 30, up3);
        
        FachadaServicios.getInstance().agregarProductos(p1);
        FachadaServicios.getInstance().agregarProductos(p2);
        FachadaServicios.getInstance().agregarProductos(p3);
        FachadaServicios.getInstance().agregarProductos(p4);
        FachadaServicios.getInstance().agregarProductos(p5);
        FachadaServicios.getInstance().agregarProductos(p6);
        FachadaServicios.getInstance().agregarProductos(p7);
        FachadaServicios.getInstance().agregarProductos(p8);
        FachadaServicios.getInstance().agregarProductos(p9);
        FachadaServicios.getInstance().agregarProductos(p10);
        FachadaServicios.getInstance().agregarProductos(p11);
        
        /////////////////////////////////////////////////////////
        //            // DATOS GESTORES                       //
        ////////////////////////////////////////////////////////
        
        Gestor g1= new Gestor("E", "E", "Mario Rivera");
        Gestor g2= new Gestor("F", "F", "Arturo Caceres");
        Gestor g3= new Gestor("G", "G", "Mariana Rey");
        Gestor g4= new Gestor("H", "H", "Romina Rodao");
        
        FachadaServicios.getInstance().agregarGestor(g1);
        FachadaServicios.getInstance().agregarGestor(g2);
        FachadaServicios.getInstance().agregarGestor(g3);
        FachadaServicios.getInstance().agregarGestor(g4);
        
        /////////////////////////////////////////////////////////
        //            // DATOS CLIENTES                        //
        ////////////////////////////////////////////////////////
        //    //TIPO CLIENTE //
        ///////////////////////
        
        TipoCliente tpComun= new ClienteComun();
        TipoCliente tpPreferencial= new ClientePreferencial();
        TipoCliente tpCasa= new ClienteDeLaCasa();
        
        ///////////////////////
        //    //BENEFICIOS   //
        ///////////////////////
        
        Beneficio beneficio1= new Beneficio("Si el monto total del servicio supera los $2000 tienen un 5% de descuento sobre el total", 5, 2000);
        Beneficio beneficio2= new Beneficio("$500 de consumo gratis por servicio", 500);
        Beneficio beneficio3= new Beneficio("Pagan $0 por todos los cafés", p7);
        Beneficio beneficio4= new Beneficio("Pagan $0 por todas las aguas minerales", p6);
        
        tpPreferencial.agregarBeneficio(beneficio1);
        tpCasa.agregarBeneficio(beneficio2);
        tpComun.agregarBeneficio(beneficio3);
        tpPreferencial.agregarBeneficio(beneficio4);
        
        Cliente cli1= new Cliente("Mauricio", "mauri@gmail.com", tpComun);
        Cliente cli2= new Cliente("Adriana", "adri@gmail.com", tpPreferencial);
        Cliente cli3= new Cliente("Robert", "rob@gmail.com", tpCasa);
        
        fachada.agregarCliente(cli1);
        fachada.agregarCliente(cli2);
        fachada.agregarCliente(cli3);
        
        ItemServicio is= new ItemServicio(2, "",p1);//milanesa
        is.setEstado(EstadoItemEnum.FINALIZADO);
        is.setGestor(g4);
        ItemServicio is2= new ItemServicio(2, "",p1);//milanesa
        is2.setEstado(EstadoItemEnum.FINALIZADO);
        is2.setGestor(g4);
        ItemServicio is3= new ItemServicio(2, "",p7); //cafe
        is3.setEstado(EstadoItemEnum.FINALIZADO);
        is3.setGestor(g4);
        ItemServicio is4= new ItemServicio(2, "",p6); //agua
        is4.setEstado(EstadoItemEnum.FINALIZADO);
        is4.setGestor(g4);
        ItemServicio is5= new ItemServicio(2, "",p6); //agua
        is5.setEstado(EstadoItemEnum.FINALIZADO);
        is5.setGestor(g4);
        ItemServicio is6= new ItemServicio(5, "",p3); //chivito 2500 pesos
        is6.setEstado(EstadoItemEnum.FINALIZADO);
        is6.setGestor(g4);
        ItemServicio is7= new ItemServicio(1, "",p7); //cafe
        is7.setEstado(EstadoItemEnum.FINALIZADO);
        is7.setGestor(g4);
        
        mesa1.abrirMesa();
        mesa1.getServicio().agregarItem(is6);
        mesa1.getServicio().agregarItem(is3);
        mesa1.getServicio().agregarItem(is4);
    }
    
}
