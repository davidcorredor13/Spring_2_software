package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.PagoMensual;
import co.edu.uniquindio.proyecto.repositorios.PagoMensualRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoMensualServicioImpl implements PagoMensualServicio{

    @Autowired
    private PagoMensualRepo pagoMensualRepo;

    @Override
    public void guardarPago(PagoMensual pagoMensual) throws Exception {
        pagoMensualRepo.save(pagoMensual);
    }
}
