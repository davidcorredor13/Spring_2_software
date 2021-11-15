package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.Usuario;

public interface MascotaServicio {

    Mascota obtenerMascota(Integer codigo) throws Exception;
}
