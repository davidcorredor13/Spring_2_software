package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;


import java.util.List;

public interface PlanServicio {



    Plan registrarPlan(Plan p) throws  Exception;

    void actualizarPlan(Plan p) throws  Exception;

    void eliminarPlan(Integer codigo) throws  Exception;

    Plan obtenerPlan(Integer codigo) throws Exception;
;

    List<Plan> buscarPlan(String nombreProducto, String[] filtros);


}
