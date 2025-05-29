package aulas.back.estado;

/**
 * Interfaz para representar el estado actual de un aula.
 * <p>
 * Permite implementar distintos estados bajo el patrón State,
 * facilitando la gestión dinámica del comportamiento de un aula según su estado.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     public class EstadoDisponible implements EstadoAula {
 *         public String descripcion() { return "Disponible"; }
 *     }
 * </pre>
 *
 * @author Jan
 */
public interface EstadoAula {
    /**
     * Devuelve una descripción textual del estado del aula.
     *
     * @return Descripción del estado.
     */
    String descripcion();
}

