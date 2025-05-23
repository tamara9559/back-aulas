package aulas.Back.estado;

/**
 * Estado concreto que representa un aula inhabilitada (no habilitada) para su uso.
 * <p>
 * Implementa la interfaz {@link EstadoAula} dentro del patrón State,
 * permitiendo identificar que el aula no está disponible para reservas o actividades.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     EstadoAula estado = new EstadoInhabilitada();
 *     System.out.println(estado.descripcion()); // Imprime: "no habilitada"
 * </pre>
 *
 * @author Jan
 */
public class EstadoInhabilitada implements EstadoAula {
    /**
     * Devuelve la descripción textual de este estado.
     *
     * @return Cadena que indica que el aula no está habilitada.
     */
    public String descripcion() {
        return "no habilitada";
    }
}
