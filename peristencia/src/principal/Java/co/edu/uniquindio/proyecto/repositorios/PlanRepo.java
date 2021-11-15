package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.ProductoValido;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/*
Se creal el repositorio */
@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer> {


    @Query("select p from Plan p where p.nombre like concat('%',:nombre,'%') ")
    List<Plan> buscarPlanPorNombre(String nombre);


     List<Plan> findAllByNombreContains(String nombre);


}
