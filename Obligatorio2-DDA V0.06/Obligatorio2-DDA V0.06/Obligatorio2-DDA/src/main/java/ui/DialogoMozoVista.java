/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui;

import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Producto;
import dominio.Servicio;
import java.util.ArrayList;

/**
 *
 * @author yamil
 */
public interface DialogoMozoVista {
    
    public void cerrarVista(); 
    
    public void mostrarError(String mensaje);
    
    public void cargarNombreMozo(String nombreCompleto);
    
    public void cargarMesasMozo(ArrayList<Mesa> mesasMozo);

    public void setLblServicioMesa(String string);

    public void cargarServicioCompleto(Servicio servicio);

    public void setListProductos(ArrayList<Producto> productos);

    public void agregarItemTablaServicio(ItemServicio is);

    public void callDialogoCerrarMesa(Mozo mozo, Mesa mesa);
}
