/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Admin
 */
public class Pedido {
    
    private Mozo mozo;
    private ItemServicio item;
    private Mesa mesa;

    public Pedido(Mozo mozo, ItemServicio is, Mesa mesa) {
        this.mozo = mozo;
        this.item = is;
        this.mesa = mesa;
    }

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public ItemServicio getItem() {
        return item;
    }

    public void setItem(ItemServicio item) {
        this.item = item;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return item + " " + mesa;
    }

    
}
