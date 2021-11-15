package co.edu.uniquindio.proyecto.bean;


import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.servicios.PlanServicio;
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

    @Getter @Setter
    @Value("#{param['busqueda']}")
    private String busquedaParam;

    @Autowired
    private PlanServicio productoServicio;

    @Getter @Setter
    private List<Plan> productos;
/*
    @PostConstruct

    public void inicializar(){
        if(busquedaParam!=null && !busquedaParam.isEmpty()){
            productos=productoServicio.buscarProducto(busquedaParam,null);

        }

    }

    public String buscar(){
        return "resultado_busqueda?faces-redirect=true&amp;busqueda="+busqueda;
    }
*/
}

