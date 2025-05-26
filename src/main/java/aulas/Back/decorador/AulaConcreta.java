package aulas.Back.decorador;

import aulas.Back.recursos.RecursoTIC;
import java.util.List;

/**
 * Implementación concreta de {@link IAula} que representa un aula base.
 * <p>
 * Esta clase almacena el nombre, la capacidad y los recursos TIC asociados a un aula,
 * y puede ser extendida o decorada usando el patrón Decorador para añadir funcionalidades adicionales.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     List&lt;RecursoTIC&gt; recursos = ...;
 *     IAula aula = new AulaConcreta("Aula 101", 40, recursos);
 * </pre>
 *
 * @author Jan
 */
public class AulaConcreta implements IAula {
    /** Nombre del aula. */
    private String nombre;

    /** Capacidad máxima del aula. */
    private int capacidad;

    /** Lista de recursos TIC disponibles en el aula. */
    private List<RecursoTIC> recursos;

    /**
     * Constructor de aula concreta.
     *
     * @param nombre    Nombre del aula.
     * @param capacidad Capacidad máxima del aula.
     * @param recursos  Lista de recursos TIC disponibles.
     */
    public AulaConcreta(String nombre, int capacidad, List<RecursoTIC> recursos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.recursos = recursos;
    }

    /** {@inheritDoc} */
    @Override
    public String getNombre() {
        return nombre;
    }

    /** {@inheritDoc} */
    @Override
    public int getCapacidad() {
        return capacidad;
    }

    /** {@inheritDoc} */
    @Override
    public List<RecursoTIC> getRecursos() {
        return recursos;
    }

    /**
     * Devuelve una descripción básica del aula.
     *
     * @return Descripción del aula base.
     */
    @Override
    public String descripcion() {
        return "Aula base: " + nombre;
    }
}

