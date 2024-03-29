package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Logica.observer.Observer;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.Mesa;
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
        usuariosLogeados = new ArrayList<Sesion>();
    }

    public void agregarMozo(Mozo mozo) {
        mozos.add(mozo);
    }

    public void agregarGestor(Gestor gestor) {
        gestores.add(gestor);
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

    public ArrayList<Mozo> getMozosConectados(Mozo mozo) {
        ArrayList<Mozo> mozosConectados = new ArrayList<Mozo>();
        for (Sesion s : usuariosLogeados) {
            Usuario u = s.getUsuario();
            if (u instanceof Mozo) {
                Mozo mozoI = (Mozo) u;
                if (!mozoI.equals(mozo)) {
                    if (mozoI.cantMesas() < 5 && mozoI.getTransferenciaRecepcion() == null) {
                        mozosConectados.add(mozoI);
                    }
                }
            }
        }
        return mozosConectados;
    }

    public Mozo loginMozo(String usuario, String password) throws SesionDuplicada {
        return (Mozo) loginGenerico(usuario, password, (ArrayList) mozos);
    }

    public Gestor loginGestor(String usuario, String password) throws SesionDuplicada {
        return (Gestor) loginGenerico(usuario, password, (ArrayList) gestores);
    }

    private Usuario loginGenerico(String usuario, String password, ArrayList<Usuario> listaUsuarios) throws SesionDuplicada {
        String uUpperCase = usuario.toUpperCase();
        for (Usuario u : listaUsuarios) {
            if (u.getNombreUsuario().equals(uUpperCase) && u.esPassordValida(password)) {
                if (!validarSesionDuplicada(u)) {
                    return u;
                } else {
                    throw new SesionDuplicada("Ud. ya está logueado");
                }
            }
        }
        return null;
    }

    private boolean validarSesionDuplicada(Usuario u) {
        boolean logeado = false;
        int aux = 0;
        while (aux < usuariosLogeados.size() && !logeado) {
            Usuario usuLogeado = usuariosLogeados.get(aux).getUsuario();
            if (usuLogeado.equals(u)) {
                logeado = true;
            }
            aux++;
        }
        return logeado;
    }

    public boolean tieneMesasAbiertas(Mozo mozo) {
        return mozo.tengoMesasAbiertas();
    }

    public Mozo buscarMozoAsociado(ItemServicio isBuscado) {
        boolean encontre = false;
        int aux = 0;
        Mozo mozo = null;
        while (!encontre && aux < mozos.size()) {
            for (Mesa mesa : mozos.get(aux).getMesas()) {
                if (mesa.getServicio() != null) {
                    for (ItemServicio is : mesa.getServicio().getItems()) {
                        if (is == isBuscado) {
                            encontre = true;
                            mozo = mozos.get(aux);
                        }
                    }
                }
            }
            aux++;
        }
        return mozo;
    }

    boolean tienePedidosPendientes(Gestor gestor) {
        return gestor.tengoPedidosPendientes();
    }
}
