package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Logica.observer.Observer;
import dominio.Gestor;
import dominio.Mozo;
import dominio.Sesion;
import dominio.Usuario;
import exceptions.SesionDuplicada;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServicioUsuario {

    
    ArrayList<Mozo> mozos;
    ArrayList<Gestor> gestores;
    ArrayList<Sesion> usuariosLogeados;
    
    public ServicioUsuario() {
        mozos = new ArrayList();
        gestores = new ArrayList();
        usuariosLogeados = new ArrayList();
    }
    
    public void agregarMozo(String nombreUsuario, String contrasenia, String nombreCompleto, String Telefono){
        // aca se crea los usuarios y se agrega a la lista de usuarios, no seria necesario implementar una validacion ya que no lo crea un usuario sino nosotros
    }
    
      public void agregarGestor(String nombreUsuario, String contrasenia, String nombreCompleto){
        // aca se crea los Gestores y se agrega a la lista de Gestores, no seria necesario implementar una validacion ya que no lo crea un usuario sino nosotros
    }
      
   
    // LOGICA PARA LA SESION
    public void iniciar(Sesion sesion) {
        usuariosLogeados.add(sesion);
        FachadaServicios.getInstance().notifyObservers(Observer.Eventos.SESIONES_ACTUALIZADAS);
    }
    
    public void cerrar(Sesion sesion) {
        usuariosLogeados.remove(sesion);
        FachadaServicios.getInstance().notifyObservers(Observer.Eventos.SESIONES_ACTUALIZADAS);
    }
    
     public ArrayList<Sesion> getUsuariosConectados() {
        return usuariosLogeados;
    }
    
    // LOGICA PARA EL LOGIN
    public Mozo loginMozo(String usuario, String password) throws SesionDuplicada {
        return (Mozo) loginGenerico(usuario, password, (ArrayList) mozos);
    }

    public Gestor loginGestor(String usuario, String password) throws SesionDuplicada {
        return (Gestor) loginGenerico(usuario, password, (ArrayList) gestores);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    //Falta devolver algun tipo de mensaje cuando el usuario ya aparece como logueado,//
    //y otro cuando el psw o usuario no coinciden. Ver en ejemplo agenda 4.2         //
    ///////////////////////////////////////////////////////////////////////////////////
    private Usuario loginGenerico(String usuario, String password, ArrayList<Usuario> listaUsuarios) throws SesionDuplicada {
        for (Usuario u : listaUsuarios) {
            //Confirma si nombre usuario = usuario, si password es valida y si usuario no esta en el array de usuarios logeados.
            /*if (u.getNombreUsuario().equals(usuario) && u.esPassordValida(password) && !usuariosLogeados.contains(u)){
                return u;
            }*/
            
            if (u.getNombreUsuario().equals(usuario) && u.esPassordValida(password)) {
                if(!usuariosLogeados.contains(u)){
                    return u;
                }else{
                    throw new SesionDuplicada("El usuario ya se encuentra logueado");
                }
            }
        }
        return null;
    }
        
     public void logout(Usuario usu){
//         1) El mozo indica que desea salir del sistema.
//        2) El sistema registra que el mozo salió del sistema y cierra la interfaz de usuario
        // se quita de la lista de usuarios logeados
    }
     
        public String mostrarNombreCompletoMozo (Mozo mozo){
        return mozo.getNombreCompleto();
    }

     
}
