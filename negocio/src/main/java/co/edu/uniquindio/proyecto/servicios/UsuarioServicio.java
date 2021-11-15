package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

/**
 * @Description clase que determina la interfaz usuario servicio
 */
public interface UsuarioServicio {

    /**
     * metodo encargado de registrar un usuario
     */
    Usuario registrarUsuario(Usuario u) throws Exception;

    /**
     * metodo encargado de actualizar un usuario
     */
    Usuario actualizarUsuario(Usuario u) throws Exception;

    /**
     * metodo encargado de eliminar un usuario
     */
    void eliminarUsuario(String codigo) throws Exception;

    /**
     * metodo encargado de listar los usuario
     */
    List<Usuario> listarUsuarios();

    /**
     * metodo encargado de obtener el usuario
     */
    Usuario obtenerUsuario(String codigo) throws Exception;
}
