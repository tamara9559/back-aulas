package aulas.Back;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document("auditorias")
public class AuditoriaEvento {
    @Id
    private String id;
    private String tipoEntidad;
    private String entidadId;
    private String tipoOperacion;
    private String descripcion;
    private Date fecha = new Date();

    public AuditoriaEvento(String tipoEntidad, String entidadId, String tipoOperacion, String descripcion) {
        this.tipoEntidad = tipoEntidad;
        this.entidadId = entidadId;
        this.tipoOperacion = tipoOperacion;
        this.descripcion = descripcion;
    }
}

