package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @JoinColumn(nullable = false)
    @Column(nullable = false, length = 100)
    private String tipoMascota;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Usuario duenoMascota;

    @OneToOne(mappedBy = "mascota")
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Plan planMascota;



}
