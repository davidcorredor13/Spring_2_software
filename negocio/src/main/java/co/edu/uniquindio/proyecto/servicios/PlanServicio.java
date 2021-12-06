package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Beneficio;
import co.edu.uniquindio.proyecto.entidades.PagoMensual;
import co.edu.uniquindio.proyecto.entidades.Plan;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;

import java.util.List;

@Repository
public interface PlanServicio {





    void registrarPlan(Plan p) throws  Exception;



    void actualizarPlan(Plan p) throws  Exception;


    void eliminarPlan(Integer codigo) throws  Exception;



    Plan obtenerPlanMascota(Integer codigo) throws Exception;

    List<Beneficio>listarBeneficios();

    Beneficio obtenerBeneficio(Integer codigo) throws Exception;

    List<Beneficio> obtenerBeneficiosPlan(Integer codigo) throws Exception;



    List<Plan> buscarPlan(String nombreProducto, String[] filtros);


    PagoMensual obtenerPagoMensual(Integer codigo) throws Exception;

    PagoMensual calcularEstadoPlan(LocalDateTime fechaActual,Integer codigo);



}
