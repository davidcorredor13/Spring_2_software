package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Beneficio;
import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.MascotaServicio;
import co.edu.uniquindio.proyecto.servicios.PlanServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class PlanBean implements Serializable {

    @Getter
    @Setter
    private Plan plan;

    @Getter
    @Setter
    private Plan planExistente;

    @Autowired
    private PlanServicio planServicio;

    @Autowired
    private MascotaServicio mascotaServicio;

    @Getter
    @Setter
    private List<Beneficio> beneficios;

    @Getter
    @Setter
    private Integer cotizacion;

    @Value("#{param['planMascota']}")
    private String planMascota;

    @Getter @Setter
    private Mascota mascota;


    @PostConstruct
    public void inicializar() {
        this.plan = new Plan();
        beneficios = planServicio.listarBeneficios();
        this.cotizacion = 0;

        if(planMascota!=null && !planMascota.isEmpty()){
            Integer codigo= Integer.parseInt(planMascota);
            try {
                this.mascota = mascotaServicio.obtenerMascota(codigo);
                this.planExistente = planServicio.obtenerPlanMascota(codigo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public void registrarPlan() {

          if(planExistente==null) {
              try {

                  plan.setMascota(mascota);
                  planServicio.registrarPlan(plan);
                  FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
                  FacesContext.getCurrentInstance().addMessage(null, mensaje);
              } catch (Exception e) {
                  FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                  FacesContext.getCurrentInstance().addMessage(null, mensaje);
              }
          }else {
              FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El plan ya existe");
              FacesContext.getCurrentInstance().addMessage(null, mensaje);
          }
    }
    public void modificarPlan() {

        if(planExistente!=null) {
            try {
                planExistente.setBeneficios(plan.getBeneficios());
                planServicio.actualizarPlan(planExistente);
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            } catch (Exception e) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El plan ya existe");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }

    public void calcularPlan(){
        cotizacion = 0;
        for (Beneficio b : plan.getBeneficios()) {
            cotizacion +=  b.getPrecio();
        }
        plan.setPrecioTotal(cotizacion);
    }

    public void calcularPlanModificado(){
        cotizacion = 0;
        for (Beneficio b : plan.getBeneficios()) {
            cotizacion +=  b.getPrecio();
        }

        planExistente.setPrecioTotal(cotizacion);
    }
    public String irAPlanMascota(String codigo){
        return "crear_plan?faces-redirect=true&amp;planMascota="+codigo;
    }

}

