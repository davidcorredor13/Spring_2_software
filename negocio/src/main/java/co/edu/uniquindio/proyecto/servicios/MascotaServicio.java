package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.Usuario;

/**
 * @Description calse que determina la interfaz mascota servicio
 */
public interface MascotaServicio {

    Mascota obtenerMascota(Integer codigo) throws Exception;
}
