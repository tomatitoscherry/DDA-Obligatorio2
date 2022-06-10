/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Logica.FachadaServicios;

/**
 *
 * @author yamil
 */
public class TransferenciaMesa {
    private static int cont=1;
    
    private Mozo mozoEmisor;
    private Mozo mozoReceptor;
    private Mesa mesa;
    private TransferenciaAprobacionEnum estado;
    private int id;

    public TransferenciaMesa(Mozo mozoEmisor, Mozo mozoReceptor, Mesa mesa) {
        this.mozoEmisor = mozoEmisor;
        this.mozoReceptor = mozoReceptor;
        this.mesa = mesa;
        this.estado = TransferenciaAprobacionEnum.ESPERANDO;
        this.id= cont;
        cont++;
    }

    public Mozo getMozoEmisor() {
        return mozoEmisor;
    }

    public Mozo getMozoReceptor() {
        return mozoReceptor;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public TransferenciaAprobacionEnum getEstado() {
        return estado;
    }
    
    public void cambiarEstado(TransferenciaAprobacionEnum estado){
        this.estado = estado;
    }

}
