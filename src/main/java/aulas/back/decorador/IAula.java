package aulas.back.decorador;

import aulas.back.recursos.RecursoTIC;
import java.util.List;

/**
 * Interfaz que define los métodos esenciales para representar un aula,
 * utilizada en la implementación del patrón Decorador.
 * <p>
 * Permite extender la funcionalidad de aulas mediante decoradores sin modificar su estructura base.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     IAula aula = ...;
 *     String nombre = aula.getNombre();
 *     int capacidad = aula.getCapacidad();
 *     List&lt;RecursoTIC&gt; recursos = aula.getRecursos();
 *     String desc = aula.descripcion();
 * </pre>
 *
 * @author Jan
 */
public interface IAula {
    /**
     * Devuelve el nombre del aula.
     *
     * @return Nombre del aula.
     */
    String getNombre();

    /**
     * Devuelve la capacidad máxima del aula.
     *
     * @return Capacidad del aula.
     */
    int getCapacidad();

    /**
     * Devuelve la lista de recursos TIC disponibles en el aula.
     *
     * @return Lista de recursos TIC.
     */
    List<RecursoTIC> getRecursos();

    /**
     * Devuelve una descripción textual del aula.
     *
     * @return Descripción del aula.
     */
    String descripcion();
}

