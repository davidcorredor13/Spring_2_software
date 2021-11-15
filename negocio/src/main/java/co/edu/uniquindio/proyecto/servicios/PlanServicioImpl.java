package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.PlanRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
*aqui estan los metodos del crud para hacer todo el ingreso  del usuario
*/



@Service
public class PlanServicioImpl implements PlanServicio {

    private final PlanRepo planRepo;

    public PlanServicioImpl(PlanRepo planRepo) {
        this.planRepo = planRepo;
    }

    @Override
    public Plan registrarPlan(Plan p) throws Exception {

        try {
            return planRepo.save(p);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void actualizarPlan(Plan p) throws Exception {

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
    public List<Plan> buscarPlan(String nombrePlan, String[] filtros) {
        return planRepo.buscarPlanPorNombre(nombrePlan);
    }




}
