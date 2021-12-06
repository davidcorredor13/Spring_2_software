package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Beneficio;
import co.edu.uniquindio.proyecto.entidades.PagoMensual;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.BeneficioRepo;
import co.edu.uniquindio.proyecto.repositorios.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PlanServicioImpl implements PlanServicio {


    @Autowired
    private  PlanRepo planRepo;

    @Autowired
    private BeneficioRepo beneficioRepo;

    public PlanServicioImpl(PlanRepo planRepo) {
        this.planRepo = planRepo;
    }

    @Override
    public  void registrarPlan(Plan p) throws Exception {

        try {
             planRepo.save(p);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public void  actualizarPlan(Plan p) throws Exception {
        Optional<Plan> buscado = planRepo.findById(p.getCodigo());
        if(buscado.isEmpty()){
            throw new Exception("El  usuario No existe");
        }
         planRepo.save(p);

    }
    @Override
    public void eliminarPlan(Integer codigo) throws Exception {
        Optional<Plan> producto = planRepo.findById(codigo);

        if(producto.isEmpty()){
            throw new Exception("el producto que desea eliminar no existe");
        }
        planRepo.deleteById(codigo);
    }

    @Override
    public Plan obtenerPlan(Integer codigo) throws Exception {
        return planRepo.findById(codigo).orElseThrow(()-> new Exception("El codio del producto no es valido"));
    }

    @Override
    public Plan obtenerPlanMascota(Integer codigo) throws Exception {
        return planRepo.obtenerPlanMascota(codigo);
    }

    @Override
    public List<Beneficio> listarBeneficios() {
        return  beneficioRepo.findAll();
    }

    @Override
    public Beneficio obtenerBeneficio(Integer codigo) throws Exception {
        return beneficioRepo.findById(codigo).orElseThrow(()-> new Exception("El codigo del beneficio no es valido"));
    }

    @Override
    public List<Beneficio> obtenerBeneficiosPlan(Integer codigo) throws Exception {
        return planRepo.obtenerBeneficiosplan(codigo);
    }


    @Override
    public List<Plan> buscarPlan(String nombrePlan, String[] filtros) {
        return planRepo.buscarPlanPorNombre(nombrePlan);
    }

    @Override
    public PagoMensual obtenerPagoMensual(Integer codigo) throws Exception {
        return planRepo.obtenerPagoMensual(codigo);
    }

    @Override
    public PagoMensual calcularEstadoPlan(LocalDateTime fechaActual, Integer codigo) {
        return planRepo.calcularEstadoPlan(fechaActual,codigo);
    }


}
