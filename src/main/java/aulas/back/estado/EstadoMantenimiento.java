package aulas.back.estado;

/**
 * Estado concreto que representa un aula en mantenimiento.
 * <p>
 * Implementa la interfaz {@link EstadoAula} dentro del patrón State,
 * permitiendo identificar que el aula no está disponible porque se encuentra en mantenimiento.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     EstadoAula estado = new EstadoMantenimiento();
 *     System.out.println(estado.descripcion()); // Imprime: "En mantenimiento"
 * </pre>
 *
 * @author Jan
 */
public class EstadoMantenimiento implements EstadoAula {
    /**
     * Devuelve la descripción textual de este estado.
     *
     * @return Cadena que indica que el aula está en mantenimiento.
     */
    public String descripcion() {
        return "En mantenimiento";
    }
}
