package co.edu.uniquindio.proyecto.repositorios;


import co.edu.uniquindio.proyecto.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
se crea el repositorio */

@Repository
// Clase para la interfaz de la mascota
public interface MascotaRepo extends JpaRepository <Mascota,Integer>{


}
