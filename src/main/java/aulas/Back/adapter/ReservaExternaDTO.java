package aulas.Back.adapter;

/**
 * DTO (Data Transfer Object) para representar una reserva proveniente de un sistema externo.
 * <p>
 * Utilizado en el patrón Adapter para facilitar la conversión entre formatos externos y el modelo interno del sistema.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     ReservaExternaDTO dto = new ReservaExternaDTO();
 *     dto.aulaCodigo = "A101";
 *     dto.fechaString = "2025-05-22";
 * </pre>
 *
 * @author Jan
 */
public class ReservaExternaDTO {
    /** Código identificador del aula en el sistema externo. */
    public String aulaCodigo;

    /** Fecha de la reserva en formato String. */
    public String fechaString;
}