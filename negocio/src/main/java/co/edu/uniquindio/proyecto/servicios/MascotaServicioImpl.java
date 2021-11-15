package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.MascotaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description clase que determina la implementacion de los servicios de mascota
 */
@Service
public class MascotaServicioImpl implements MascotaServicio{

    /**
     * Atributo que determina el repo de mascota
     */
    @Autowired
    private  MascotaRepo mascotaRepo;

    /**
     * @Description Metodo que permite obtener una mascota por su id
     */
    @Override
    public Mascota obtenerMascota(Integer codigo) throws Exception {
        Optional<Mascota> buscado = mascotaRepo.findById(codigo);
        if(buscado.isEmpty()){
            throw new Exception("El codigo de la mascota  No existe");
        }
        return buscado.get();
    }
    
   /* @Override
    public Mascota obtenerMascota(Integer codigo) throws Exception {
        return mascotaRepo.findById(codigo).orElseThrow(()-> new Exception("El codio del producto no es valido"));
    }*/
}
