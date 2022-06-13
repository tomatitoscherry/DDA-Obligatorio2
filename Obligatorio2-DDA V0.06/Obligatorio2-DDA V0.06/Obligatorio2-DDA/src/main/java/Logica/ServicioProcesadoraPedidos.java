package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Logica.observer.Observer;
import dominio.EstadoItemEnum;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Producto;
import dominio.Servicio;
import dominio.UnidadProcesadora;
import exceptions.PedidoException;
import exceptions.ServicioException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServicioProcesadoraPedidos {

    //lista que tiene todos los pedidos generados
    ArrayList<ItemServicio> pedidosMonitor = new ArrayList<ItemServicio>();
    ArrayList<UnidadProcesadora> unidadesProcesadoras = new ArrayList<UnidadProcesadora>();

    /////////////////////////////////////////////
    //      //Logica precarga de datos         //
    ////////////////////////////////////////////
    //agrega unidad procesadora, no lo usa ususario.
    public void agregarUnidadProcesadora(UnidadProcesadora unaUnidadProcesadora) {
        unidadesProcesadoras.add(unaUnidadProcesadora);
    }

    public void agregarProducto(ItemServicio is) {
        Producto p = is.getProducto();
        for (UnidadProcesadora up : unidadesProcesadoras) {
            if (up.equals(p.getUnidadProcesadora())) {
                pedidosMonitor.add(is);
                up.addItemServicio(is);
                FachadaServicios.getInstance().notifyObservers(Observer.Eventos.PEDIDOS_ACTUALIZADOS);
            }
        }
    }

    public void setearPedidoParaGestor(ItemServicio pedido, Gestor gestor, UnidadProcesadora unidadProcesadora) throws PedidoException {

        if (pedido != null) {
            pedido.setGestor(gestor);
            pedido.setEstado(EstadoItemEnum.PREPARANDO);
            unidadProcesadora.removeItemServicio(pedido);
            gestor.setPedidosTomados(pedido);
        } else {
            throw new PedidoException("Debe seleccionar un item.");
        }

    }

    public ArrayList<UnidadProcesadora> conjuntoUnidadesProcesadoras() {
        return unidadesProcesadoras;
    }

    void finalizarPedidoParaGestor(ItemServicio pedido, Gestor gestor) throws PedidoException {

        if (pedido != null) {
            pedido.setEstado(EstadoItemEnum.FINALIZADO);
            pedido.setActualizado(true);
            gestor.removePedidoTomado(pedido);
            FachadaServicios.getInstance().notifyObservers(Observer.Eventos.PEDIDO_FINALIZADO);
        } else {
            throw new PedidoException("Debe seleccionar un item.");
        }

    }

}
