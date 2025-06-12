package aulas.back.auditoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Representa un evento de auditoría registrado en el sistema para realizar seguimiento
 * de las operaciones sobre las entidades principales (por ejemplo, Aula).
 * <p>
 * Cada instancia almacena información relevante como el tipo de entidad, el identificador de la entidad,
 * el tipo de operación realizada, una descripción y la fecha del evento.
 * </p>
 *
 * Se almacena en la colección "auditorias" de MongoDB.
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     AuditoriaEvento evento = new AuditoriaEvento(
 *         "Aula", "aula123", "CAMBIO_ESTADO", "El aula cambió a estado: RESERVADA"
 *     );
 *     auditoriaRepository.save(evento);
 * </pre>
 *
 * @author Janka033
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("auditorias")
public class AuditoriaEvento {
    @Id
    private String id;
    private String tipoEntidad;
    private String entidadId;
    private String tipoOperacion;
    private String descripcion;
    private Date fecha = new Date();
    private AuditoriaEvento auditoriaEvento;
    /**
     * Constructor de negocio que inicializa un evento de auditoría con los datos más relevantes.
     * La fecha se inicializa automáticamente al momento de la creación.
     *
     * @param tipoEntidad   Tipo de la entidad afectada (por ejemplo, "Aula").
     * @param entidadId     Identificador único de la entidad.
     * @param tipoOperacion Tipo de operación realizada (por ejemplo, "CREACION", "CAMBIO_ESTADO").
     * @param descripcion   Descripción detallada del evento.
     */
    public AuditoriaEvento(String tipoEntidad, String entidadId, String tipoOperacion, String descripcion) {
        this.tipoEntidad = tipoEntidad;
        this.entidadId = entidadId;
        this.tipoOperacion = tipoOperacion;
        this.descripcion = descripcion;
        this.fecha = new Date();
    }
}