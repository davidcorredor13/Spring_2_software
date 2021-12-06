package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;


/**
* @description entidad que permite modelar un administrador para la aplicacion
* @author Alba Rocio Marin Duque
*/
public class Administrador implements Serializable {

    //email del adminstrador
    @Getter @Setter
    private String email,password;
}
