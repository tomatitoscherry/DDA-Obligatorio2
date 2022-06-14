/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui;

import dominio.DetalleBeneficiosAplicados;
import dominio.Mesa;
import java.util.ArrayList;

/**
 *
 * @author yamil
 */
public interface DialogoCerrarMesaVista {
    public void cerrarVista(); 
    
    public void mostrarError(String mensaje);
    
    public void agregarClienteMesa();
    
    public void noAgregarClienteMesa();

    public void inicializarVista(Mesa mesa);

    public void desactivarActivarBotones(boolean b);

    public void setLebelsDatosCli(String string);

    public void cargarBeneficiosCliente(ArrayList<DetalleBeneficiosAplicados> beneficiosAplicados);

    public void setLabelsServicio(String string, String string0, String string1);
}
