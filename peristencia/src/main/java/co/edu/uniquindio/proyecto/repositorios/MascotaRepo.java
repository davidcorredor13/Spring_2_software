package co.edu.uniquindio.proyecto.repositorios;


import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
public interface MascotaRepo extends JpaRepository <Mascota,Integer>{


    @Query("select m from Mascota m where m.codigo= :codigo")
    Mascota obtenerMascota(Integer codigo);

    @Query("select m from Mascota m where m.duenoMascota.codigo = :codigo")
    List<Mascota> listarMascotaUsuario(String codigo);


}
