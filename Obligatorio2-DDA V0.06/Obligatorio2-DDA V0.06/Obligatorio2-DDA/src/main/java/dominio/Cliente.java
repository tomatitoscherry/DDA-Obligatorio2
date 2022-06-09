/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author yamil
 */
public class Cliente {
    private static int contadorId=1;
    
    private int id;
    private String nombre;
    private String email;
    private TipoCliente tipoCliente;

    public Cliente(String nombre, String email, TipoCliente tipoCliente) {
        this.id = contadorId;
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = tipoCliente;
        contadorId++;
    }
    
    public Cliente(){
        this.tipoCliente = new ClienteSinRegistrar();
    }

    public static int getContadorId() {
        return contadorId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
    
}
