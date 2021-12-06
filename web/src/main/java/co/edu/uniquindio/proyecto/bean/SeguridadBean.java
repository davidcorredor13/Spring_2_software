package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.logging.Logger;


@Scope("session")
@Component
public class SeguridadBean {
    Logger logger = Logger.getLogger(SeguridadBean.class.getName());

    @Getter
    @Setter
    private boolean autenticado;



    @Getter @Setter
    Administrador usuarioSesion;




    @Getter @Setter
    private String email,password;



    @PostConstruct
    public void inicializar(){


    }


    public String iniciarSesion(){
        if(!email.isEmpty() && !password.isEmpty()){
            try {
                //usuarioSesion.setEmail("fabian@gmail.com");
               // usuarioSesion.setPassword("123");
                autenticado=true;
                return "/index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean",fm);
            }
        }
        return null;
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }













}
