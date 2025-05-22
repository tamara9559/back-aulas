package aulas.Back.estado;

/**
 * Estado concreto que representa un aula ocupada.
 * <p>
 * Implementa la interfaz {@link EstadoAula} dentro del patrón State,
 * permitiendo identificar que el aula está actualmente en uso y no disponible para nuevas reservas.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     EstadoAula estado = new EstadoOcupada();
 *     System.out.println(estado.descripcion()); // Imprime: "Ocupada"
 * </pre>
 *
 * @author Jan
 */
public class EstadoOcupada implements EstadoAula {
    /**
     * Devuelve la descripción textual de este estado.
     *
     * @return Cadena que indica que el aula está ocupada.
     */
    public String descripcion() {
        return "Ocupada";
    }
}
