package aulas.Back.decorador;

import aulas.Back.RecursoTIC;
import java.util.List;

/**
 * Clase abstracta base para los decoradores de {@link IAula}.
 * <p>
 * Implementa la interfaz {@link IAula} y delega las llamadas a una instancia
 * interna, permitiendo que las subclases extiendan o modifiquen el comportamiento
 * de las aulas de forma flexible y dinámica usando el patrón Decorador.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     IAula aulaBase = ...;
 *     IAula aulaDecorada = new AulaConProyector(aulaBase);
 * </pre>
 *
 * @author Jan
 */
public abstract class AulaDecorator implements IAula {
    /** Instancia interna de IAula a la que se delegan las llamadas. */
    protected IAula aula;

    /**
     * Constructor del decorador de aula.
     *
     * @param aula Instancia de IAula a decorar.
     */
    public AulaDecorator(IAula aula) {
        this.aula = aula;
    }

    /** {@inheritDoc} */
    @Override
    public String getNombre() {
        return aula.getNombre();
    }

    /** {@inheritDoc} */
    @Override
    public int getCapacidad() {
        return aula.getCapacidad();
    }

    /** {@inheritDoc} */
    @Override
    public List<RecursoTIC> getRecursos() {
        return aula.getRecursos();
    }

    /**
     * Devuelve una descripción extendida del aula decorada.
     *
     * @return Descripción del aula con los decoradores aplicados.
     */
    @Override
    public abstract String descripcion();
}


