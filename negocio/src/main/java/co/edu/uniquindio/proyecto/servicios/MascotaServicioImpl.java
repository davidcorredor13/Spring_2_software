package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.MascotaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MascotaServicioImpl implements MascotaServicio{


    @Autowired
    private  MascotaRepo mascotaRepo;


    @Override
    public Mascota obtenerMascota(Integer codigo) throws Exception {
        return  mascotaRepo.obtenerMascota(codigo);

    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepo.findAll();
    }

    @Override
    public List<Mascota> listarMascotasUsuario(String codigo) throws Exception{
        return mascotaRepo.listarMascotaUsuario(codigo);
    }
    

}
