package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

/**
 * @Description clase que determina la interfaz usuario servicio
 */
public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;

    Usuario actualizarUsuario(Usuario u) throws Exception;

    void eliminarUsuario(String codigo) throws Exception;

    List<Usuario> listarUsuarios();

    Usuario obtenerUsuario(String codigo) throws Exception;


}
