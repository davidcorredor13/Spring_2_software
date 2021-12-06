package co.edu.uniquindio.proyecto.bean;


import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.PlanServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
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
public class BusquedaBean implements Serializable {

    @Getter @Setter
    private String busqueda;


    @Value("#{param['codigoUsuario']}")
    private String codigoUsuario;




    @Autowired
    private PlanServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private List<Plan> productos;

    @Getter @Setter
    private Usuario usuario;

    @PostConstruct

    public void inicializar(){
        if(codigoUsuario!=null && !codigoUsuario.isEmpty()){
            try {
                usuario = usuarioServicio.obtenerUsuario(codigoUsuario);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String buscar(){
        return "resultado_busqueda?faces-redirect=true&amp;codigoUsuario="+busqueda;
    }

    public String irAListaMascotaUsuario(String codigo){
        return "mascotas?faces-redirect=true&amp;usuarioMascotas="+codigo;
    }

}

