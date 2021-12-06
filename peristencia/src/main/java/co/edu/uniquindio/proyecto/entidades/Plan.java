package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Plan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombre;

    @Positive
    @Column(nullable = false)
    private  Integer precioTotal;

    @ManyToMany
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private List<Beneficio> beneficios;

    @OneToOne
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Mascota mascota;

    @OneToOne(mappedBy = "plan",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private PagoMensual pagoMensual;







}
