package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.faces.view.facelets.FaceletContext;
import java.io.Serializable;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    @Getter @Setter
    private Usuario usuario;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void inicializar(){
        usuario = new Usuario();
    }

    public void registrarUsuario(){
        try {
            usuarioServicio.registrarUsuario(usuario);
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null,mensaje);
        } catch (Exception e) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,mensaje);
        }
    }


    public void eliminarUsuario(){

        try {
            usuarioServicio.eliminarUsuario(usuario.getCodigo());
            System.out.println(usuario.getCodigo());
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","eliminacion exitosa");
            FacesContext.getCurrentInstance().addMessage(null,mensaje);
        } catch (Exception e) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,mensaje);
        }
    }



    public void ActualizaarUsuario(){
        try {
            usuarioServicio.actualizarUsuario(usuario);
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","actulizacion exitosa");
            FacesContext.getCurrentInstance().addMessage(null,mensaje);
        } catch (Exception e) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,mensaje);
        }
    }
}
