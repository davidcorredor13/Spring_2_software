package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

/**
* @description entidad que permite colocar los beneficios de las mascotas 
* @author Alba Rocio Marin Duque
*/
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Beneficio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombre;

    @Positive
    @Column(nullable = false)
    private Integer precio;

    @ManyToMany (mappedBy = "beneficios",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Plan> planesBeneficio;




}
