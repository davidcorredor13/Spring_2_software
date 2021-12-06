package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Beneficio;
import co.edu.uniquindio.proyecto.entidades.PagoMensual;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.dom4j.util.UserDataElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer> {


    @Query("select p from Plan p where p.nombre like concat('%',:nombre,'%') ")
    List<Plan> buscarPlanPorNombre(String nombre);


    List<Plan> findAllByNombreContains(String nombre);

    @Query("select p from Plan p where p.mascota.codigo = :codigo")
    Plan obtenerPlanMascota(Integer codigo);

    @Query("select b from Plan p, IN (p.beneficios) b where p.codigo = :codigo")
    List<Beneficio> obtenerBeneficiosplan(Integer codigo);

    @Query("select pm from PagoMensual pm where pm.plan.codigo = :codigo")
    PagoMensual obtenerPagoMensual(Integer codigo);

    @Query( "select m from  PagoMensual m where (m.fechaLimite > :fechaActual) and (m.codigo = :codigo) " )
    PagoMensual calcularEstadoPlan(LocalDateTime fechaActual,Integer codigo);



}
