package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

/**
 * @Description clase que determina la interfaz de un paln servicio
 */
public interface PlanServicio {

    /**
     * metodo que permite registrar un plan
     */
    Plan registrarPlan(Plan p) throws  Exception;

    /**
     * metodo que permite actualizar un plan
     */
    void actualizarPlan(Plan p) throws  Exception;

    /**
     * Metodo que permite eliminar un plan
     */
    void eliminarPlan(Integer codigo) throws  Exception;

    /**
     * metodo que permite obtener un plan
     */ 
    Plan obtenerPlan(Integer codigo) throws Exception;

    /**
     * metodo que permite buscar planes por filtros
     */
    List<Plan> buscarPlan(String nombreProducto, String[] filtros);

}
