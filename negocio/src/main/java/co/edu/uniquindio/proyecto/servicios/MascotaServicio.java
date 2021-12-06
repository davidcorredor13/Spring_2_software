package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

public interface MascotaServicio {

    Mascota obtenerMascota(Integer codigo) throws Exception;


    List<Mascota> listarMascotas();

    List<Mascota> listarMascotasUsuario(String codigo) throws Exception;
}
