/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.observer.Observable;
import dominio.Beneficio;
import dominio.Cliente;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Producto;
import dominio.Servicio;
import dominio.Sesion;
import dominio.Usuario;
import exceptions.ServicioException;
import exceptions.MesaException;
import exceptions.SesionDuplicada;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class FachadaServicios extends Observable {
    
    private static FachadaServicios instance; 
    private ServicioUsuario servicioUsuario;
    private ServicioMesa servicioMesa;
    private ServicioProcesadoraPedidos servicioProcesadoraPedidos;
    
        private FachadaServicios() {
        servicioMesa = new ServicioMesa();
        servicioUsuario = new ServicioUsuario();
        servicioProcesadoraPedidos = new ServicioProcesadoraPedidos();
        
    }
    
    public synchronized static FachadaServicios getInstance() {
        if(instance == null) {
            instance =  new FachadaServicios();
        }
        return instance;
    }
 //////////////////////////////////////////////////////////////////
 //   //Metodos para la precarga de datos                        //
 //////////////////////////////////////////////////////////////////

    public void agregarMozo(String nombreUsuario, String contrasenia, String nombreCompleto, String telefono){
        servicioUsuario.agregarMozo(nombreUsuario, contrasenia, nombreCompleto, telefono);
    }
    
    public void agregarGestor(String nombreUsuario, String contrasenia, String nombreCompleto){
        servicioUsuario.agregarGestor(nombreUsuario, contrasenia, nombreCompleto);
    }
    
    public void agregarProducto(int codigo, String nombre, float precioUnidad, int stock){
        servicioMesa.agregarProducto(codigo, nombre, precioUnidad, stock);
    }
    
 //////////////////////////////////////////////////////////////////
 //   //Metodos para la sesion                                   //
 //////////////////////////////////////////////////////////////////
            
    public void iniciar(Sesion sesion) {
        servicioUsuario.iniciar(sesion);
    }

    public void cerrar(Sesion sesion) {
        servicioUsuario.cerrar(sesion);
    }
    
    public ArrayList<Sesion> getUsuariosConectados() {
        return servicioUsuario.getUsuariosConectados();
    }
 //////////////////////////////////////////////////////////////////
 //   //Aplicación para la atención de mesas                     //
 //////////////////////////////////////////////////////////////////
 //   //*CU: Ingresar a la aplicación                            //               
 //////////////////////////////////////////////////////////////////   
    
    public Mozo loginMozo(String usuario, String password) throws SesionDuplicada {
        return servicioUsuario.loginMozo(usuario, password);
    }
        
    public Gestor loginGestor(String usuario, String password) throws SesionDuplicada {
        return servicioUsuario.loginGestor(usuario, password);
    }

    public String mostrarNombreCompletoMozo (Mozo mozo){
        return servicioUsuario.mostrarNombreCompletoMozo(mozo);
    }

    public ArrayList<Mesa> conjuntoMesasDeMozo (Mozo mozo){
        return servicioMesa.conjuntoMesasDeMozo(mozo);
    }

 //////////////////////////////////////////////////////////////////
 //   //*CU: Abrir una mesa                                      //               
 ////////////////////////////////////////////////////////////////// 

    public void abrirMesa (Mesa mesa) throws MesaException {
        servicioMesa.abrirMesa(mesa);
    }
    
 //////////////////////////////////////////////////////////////////
 //   //CU: Agregar un producto al servicio                      //               
 ////////////////////////////////////////////////////////////////// 
    
    public Servicio getServicioMesa (Mesa mesa){
        return servicioMesa.getServiciosMesa(mesa);
    }
    
    public boolean mesaEstaAbierta (Mesa mesa){
        return servicioMesa.mesaEstaAbierta(mesa);
    }
    
    public ArrayList<Producto> getProductosDisponibles(){
        return servicioMesa.getProductosDisponibles();
    }
    
    public ItemServicio agregarProductoAServicio(Mesa mesa, Producto producto, int cantidad, String descripcion) throws ServicioException{
        return servicioMesa.agregarProductoAServicio(mesa, producto, cantidad, descripcion);  
    }
    
    public void agregarPedidoUnidadProcesadora(ItemServicio is) {
        servicioProcesadoraPedidos.agregarProducto(is);
    }

     //////////////////////////////////////////////////////////////////
    //   //CU: Cerrar una mesa                                       //               
    ////////////////////////////////////////////////////////////////// 
    
    public Cliente buscarCliente(int nroCliente) {
        return servicioMesa.buscarCliente(nroCliente);
    }
    
    public boolean tieneMesasAbiertas(Mozo mozo) {
        return servicioUsuario.tieneMesasAbiertas(mozo);
    }
    
    public void siguienteFuncion(){
    
    }
}
