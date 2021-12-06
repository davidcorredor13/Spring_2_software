package co.edu.uniquindio.proyecto.entidades;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class PagoMensual implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaPago;



    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaLimite;



    @NotBlank
    @JoinColumn(nullable = false)
    @Column(nullable = false, length = 100)
    private String medioPago;


    @OneToOne
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Plan plan;


}
