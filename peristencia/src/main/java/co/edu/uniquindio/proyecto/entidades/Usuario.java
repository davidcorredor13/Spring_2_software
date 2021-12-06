package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.io.Serializable;
import java.util.List;



@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString

public class Usuario  implements Serializable {



    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false, length = 100)
    @Length(max = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 120)
    @Length(max = 120)
    @Email
    private String email;

    @Column(nullable = false)
    private  String Telefonos;

    @OneToMany(mappedBy = "duenoMascota",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Mascota> mascota;




}
