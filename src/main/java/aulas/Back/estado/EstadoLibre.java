package aulas.Back.estado;

/**
 * Estado concreto que representa un aula libre y disponible para su uso.
 * <p>
 * Implementa la interfaz {@link EstadoAula} dentro del patrón State,
 * permitiendo identificar que el aula está actualmente disponible para reservas o actividades.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     EstadoAula estado = new EstadoLibre();
 *     System.out.println(estado.descripcion()); // Imprime: "Libre"
 * </pre>
 *
 * @author Jan
 */
public class EstadoLibre implements EstadoAula {
    /**
     * Devuelve la descripción textual de este estado.
     *
     * @return Cadena que indica que el aula está libre.
     */
    public String descripcion() {
        return "Libre";
    }
}
