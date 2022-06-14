/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.observer.Observable;
import dominio.Beneficio;
import dominio.Cliente;
import dominio.DetalleBeneficiosAplicados;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Pedido;
import dominio.Producto;
import dominio.Servicio;
import dominio.Sesion;
import dominio.TransferenciaMesa;
import dominio.UnidadProcesadora;
import dominio.Usuario;
import exceptions.AgregarClienteMesaException;
import exceptions.ServicioException;
import exceptions.MesaException;
import exceptions.PedidoException;
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

    public void agregarMozo(Mozo mozo){
        servicioUsuario.agregarMozo(mozo);
    }
    
    public void agregarGestor(Gestor gestor){
        servicioUsuario.agregarGestor(gestor);
    }
    
    public void agregarMesa(Mozo mozo, Mesa mesa) throws MesaException{
        servicioMesa.agregarMesa(mozo, mesa);
    }
    
    public void agregarCliente(Cliente cli){
        servicioMesa.agregarCliente(cli);
    }
    
    public void agregarUnidadProcesadora(UnidadProcesadora unaUnidadProcesadora){    
        servicioProcesadoraPedidos.agregarUnidadProcesadora(unaUnidadProcesadora);
    }

    public void agregarProductos(Producto producto){
        servicioMesa.agregarProductos(producto);
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

    public ArrayList<Mesa> conjuntoMesasDeMozo (Mozo mozo){
        return servicioMesa.conjuntoMesasDeMozo(mozo);
    }
    
    public ArrayList<UnidadProcesadora> conjuntoUnidadesProcesadoras(){
        return servicioProcesadoraPedidos.conjuntoUnidadesProcesadoras();
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
    
    public ItemServicio agregarProductoAServicio(Mesa mesa, Producto producto, String cantidad, String descripcion) throws ServicioException{
        return servicioMesa.agregarProductoAServicio(mesa, producto, cantidad, descripcion);  
    }
    
    public void agregarPedidoUnidadProcesadora(Pedido is) {
        servicioProcesadoraPedidos.agregarProducto(is);
    }
    
    public Mesa finalizaronMiPedido(Mozo mozo) {
        return servicioMesa.finalizaronMiPedido(mozo);
    }
    
    public ItemServicio isFinalizado(Mesa mesa) {
       return servicioMesa.isFinalizado(mesa);
    }

    //////////////////////////////////////////////////////////////////
    //   //CU: Transferir una mesa                                   //               
    ////////////////////////////////////////////////////////////////// 
    
    public ArrayList<Mozo> getMozosConectados(Mozo mozo) {
        return servicioUsuario.getMozosConectados(mozo);
    }
    
    public void transferirMesa(Mozo mozo, Mesa mesa, Mozo mozoSeleccionado) {
        servicioMesa.transferirMesa(mesa, mozo, mozoSeleccionado);
    }
    
    public void cambioEstadoTransferenciaMesa(int opcionSeleccionada, TransferenciaMesa transferencia) {
        servicioMesa.cambioEstadoTransferenciaMesa(opcionSeleccionada, transferencia);
    }
    
    public void tramitarTransferenciaMesa(Mozo mozo) throws MesaException {
        servicioMesa.tramitarTransfernciaMesa(mozo);
    }
    
    public void eliminarTransferencias(TransferenciaMesa transferenciaRecepcion) {
        servicioMesa.eliminarTransferencias(transferenciaRecepcion);
    }
    
    //////////////////////////////////////////////////////////////////
    //   //CU: Cerrar una mesa                                       //               
    ////////////////////////////////////////////////////////////////// 
    
    public Cliente buscarCliente(String nroCliente) throws AgregarClienteMesaException {
        return servicioMesa.buscarCliente(nroCliente);
    }
    
    public boolean tieneMesasAbiertas(Mozo mozo) {
        return servicioUsuario.tieneMesasAbiertas(mozo);
    }
    
    public ArrayList<DetalleBeneficiosAplicados> beneficiosAplicados(Mesa mesa) {
        return servicioMesa.beneficiosAplicados(mesa);
    }

    public float totalDescuentos(ArrayList<DetalleBeneficiosAplicados> beneficiosAplicados) {
        return servicioMesa.totalDescuentos(beneficiosAplicados);
    }

    public float totalPagar(float totalDescuentos, float montoSinDescuentos) {
        return servicioMesa.totalPagar(totalDescuentos, montoSinDescuentos);
    }
    
         //////////////////////////////////////////////////////////////////
         //   //    Aplicación procesadora de pedidos                    //
         //////////////////////////////////////////////////////////////////
         //   //*CU: Monitor de pedidos                                  //               
         //////////////////////////////////////////////////////////////////   


    public void setearPedidoParaGestor(Pedido pedido, Gestor gestor, UnidadProcesadora unidadProcesadora) throws PedidoException {
        servicioProcesadoraPedidos.setearPedidoParaGestor(pedido, gestor, unidadProcesadora);
        
    }

    public void finalizarPedidoParaGestor(Pedido pedido, Gestor gestor) throws PedidoException {
        servicioProcesadoraPedidos.finalizarPedidoParaGestor(pedido, gestor);
    }

    public boolean tienePedidosPendientes(Gestor gestor) {
        return servicioUsuario.tienePedidosPendientes(gestor);
    }

}
