package co.edu.uniquindio.proyecto.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.apache.tomcat.jni.File;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@Component
@ViewScoped
public class InicioBean implements Serializable {


    @PostConstruct
    public void inicializar() {


    }


}
