package aulas.Back.estado;

/**
 * Estado concreto que representa un aula reservada.
 * <p>
 * Implementa la interfaz {@link EstadoAula} dentro del patrón State,
 * permitiendo identificar que el aula está reservada y no disponible en ese momento.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     EstadoAula estado = new EstadoReservada();
 *     System.out.println(estado.descripcion()); // Imprime: "Reservada"
 * </pre>
 *
 * @author Jan
 */
public class EstadoReservada implements EstadoAula {
    /**
     * Devuelve la descripción textual de este estado.
     *
     * @return Cadena que indica que el aula está reservada.
     */
    public String descripcion() {
        return "Reservada";
    }
}
