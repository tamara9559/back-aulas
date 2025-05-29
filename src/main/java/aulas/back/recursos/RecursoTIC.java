package aulas.back.recursos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa un recurso TIC (Tecnologías de la Información y la Comunicación)
 * que puede estar asociado a un aula, como proyectores, pizarras electrónicas, etc.
 * Incluye información sobre su estado y descripción.
 *
 * @author Jan
 */
@Getter
@Setter
@AllArgsConstructor
public class RecursoTIC {
    /** Identificador único del recurso TIC. */
    private String id;

    /** Nombre del recurso TIC. */
    private String nombre;

    /** Descripción detallada del recurso TIC. */
    private String descripcion;

    private EstadoRecurso estado = EstadoRecurso.DISPONIBLE;

    private int cantidad;
}