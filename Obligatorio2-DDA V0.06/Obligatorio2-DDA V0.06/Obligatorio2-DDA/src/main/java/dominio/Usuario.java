/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author yamil
 */
public class Usuario {
    
    private String nombreUsuario;
    private String contrasenia;
    private String nombreCompleto;

    public Usuario(String nombreUsuario, String contrasenia, String nombreCompleto) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public boolean esPassordValida(String password) {
        String pswUpperCase= password.toUpperCase();
        return this.contrasenia.equals(pswUpperCase);
    }

    
}
