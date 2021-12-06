package co.edu.uniquindio.proyecto.bean;


import co.edu.uniquindio.proyecto.entidades.Mascota;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.servicios.MascotaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class MascotaBean implements Serializable {

    @Autowired
    private MascotaServicio mascotaServicio;

    @Getter @Setter
    private List<Mascota> mascotas;

    @Getter @Setter
    private Mascota mascota;


    @Value("#{param['usuarioMascotas']}")
    private String usuarioMascotas;

    @PostConstruct
    public void inicializar() {
        if(usuarioMascotas!=null && !usuarioMascotas.isEmpty()){
            try {
                this.mascotas = mascotaServicio.listarMascotasUsuario(usuarioMascotas);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String irAListaMascotaUsuario(String codigo){
        return "mascotas?faces-redirect=true&amp;usuarioMascotas="+codigo;
    }

}
