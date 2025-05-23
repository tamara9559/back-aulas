package aulas.Back;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa un recurso TIC (Tecnologías de la Información y la Comunicación)
 * que puede estar asociado a un aula, como proyectores, pizarras electrónicas, etc.
 * Incluye información sobre su disponibilidad y descripción.
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

    /** Indica si el recurso TIC está disponible. */
    private boolean disponible;

    private int cantidad;
}