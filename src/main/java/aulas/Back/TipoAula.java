package aulas.Back;

import lombok.Getter;
import lombok.Setter;

/**
 * Representa un tipo de aula dentro del sistema, por ejemplo: teórica, laboratorio, salón múltiple, etc.
 * Incluye información sobre su identificador, nombre y una descripción.
 *
 * Utiliza Lombok para la generación automática de getters y setters.
 *
 * Ejemplo de uso:
 * <pre>
 *     TipoAula tipo = new TipoAula("T1", "Teórica", "Aula para clases teóricas");
 * </pre>
 *
 * @author Jan
 */
@Getter
@Setter
class TipoAula {
    /** Identificador único del tipo de aula. */
    private String id;

    /** Nombre del tipo de aula. */
    private String nombre;

    /** Descripción detallada del tipo de aula. */
    private String descripcion;

    /**
     * Crea una nueva instancia de TipoAula.
     *
     * @param id          Identificador único.
     * @param nombre      Nombre del tipo de aula.
     * @param descripcion Descripción del tipo de aula.
     */
    public TipoAula(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}