package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.MascotaServicio;
import co.edu.uniquindio.proyecto.servicios.PlanServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class PlanBean implements Serializable {

    @Getter @Setter
    private Plan plan;

    @Autowired
    private PlanServicio planServicio;

    @Autowired
    private MascotaServicio mascotaServicio;

    @PostConstruct
    public void inicializar(){
        this.plan = new Plan();
    }

    public void registrarPlan(){
        try {
            Mascota mascota = mascotaServicio.obtenerMascota(1);
            plan.setMascota(mascota);
            planServicio.registrarPlan(plan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

