package aulas.Back.flyweight;

import aulas.Back.RecursoTIC;
import java.util.List;

/**
 * Clase que representa la configuración compartida (flyweight) de un aula,
 * incluyendo su capacidad y los recursos TIC asociados.
 * <p>
 * Esta clase forma parte de la implementación del patrón Flyweight, facilitando
 * el uso eficiente de memoria al compartir configuraciones comunes entre múltiples aulas.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     List&lt;RecursoTIC&gt; recursos = ...;
 *     ConfiguracionAula config = new ConfiguracionAula(40, recursos);
 * </pre>
 *
 * @author Jan
 */
public class ConfiguracionAula {
    /** Capacidad máxima del aula. */
    public int capacidad;

    /** Lista de recursos TIC asociados al aula. */
    public List<RecursoTIC> recursos;

    /**
     * Constructor para crear una configuración de aula.
     *
     * @param capacidad Capacidad máxima de alumnos que admite el aula.
     * @param recursos  Lista de recursos TIC disponibles en el aula.
     */
    public ConfiguracionAula(int capacidad, List<RecursoTIC> recursos) {
        this.capacidad = capacidad;
        this.recursos = recursos;
    }
}

