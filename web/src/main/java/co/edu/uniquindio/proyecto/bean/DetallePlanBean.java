package co.edu.uniquindio.proyecto.bean;


import co.edu.uniquindio.proyecto.entidades.Beneficio;
import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.PagoMensual;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.servicios.MascotaServicio;
import co.edu.uniquindio.proyecto.servicios.PagoMensualServicio;
import co.edu.uniquindio.proyecto.servicios.PlanServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Component
@ViewScoped
public class DetallePlanBean implements Serializable {




    @Autowired
    private PlanServicio planServicio;

    @Autowired
    private PagoMensualServicio pagoMensualServicio;

    @Getter @Setter
    private Plan plan;

    @Getter @Setter
    private PagoMensual pagoMensual;

    @Getter @Setter
    private PagoMensual estadoPago;
    @Getter @Setter
    private String medioPago;

    @Getter @Setter
    private List<Beneficio> beneficios;


    @Value("#{param['detalleP']}")
    private String detalleP;

    @Getter @Setter
    private boolean estado;

    @Getter @Setter
    private LocalDateTime fechaActual;

    @Getter @Setter
    private LocalDateTime fechaLimite;

    @PostConstruct
    public void inicializar() {
        this.medioPago = new String();
        this.pagoMensual = new PagoMensual();
        this.estado = false;
        this.fechaActual=LocalDateTime.now();
        if(detalleP!=null && !detalleP.isEmpty()){
            Integer codigo= Integer.parseInt(detalleP);
            try {
                this.plan = planServicio.obtenerPlanMascota(codigo);
                this.beneficios = planServicio.obtenerBeneficiosPlan(plan.getCodigo());
                this.pagoMensual = planServicio.obtenerPagoMensual(plan.getCodigo());
                this.estadoPago = planServicio.calcularEstadoPlan(fechaActual,pagoMensual.getCodigo());
                if(estadoPago!=null){
                    estado = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void pagarPlan(){
          if(plan!=null) {

              try {
                  pagoMensual.setMedioPago(medioPago);
                  pagoMensual.setFechaPago(LocalDateTime.now().plusMinutes(1));
                  pagoMensual.setFechaLimite(LocalDateTime.now().plusMonths(1));
                  pagoMensual.setPlan(plan);
                  pagoMensualServicio.guardarPago(pagoMensual);
              } catch (Exception e) {
                  e.printStackTrace();
              }

          }
    }

    public String irADetallePlan(String codigo){
        return "detalle_plan?faces-redirect=true&amp;detalleP="+codigo;
    }



}
