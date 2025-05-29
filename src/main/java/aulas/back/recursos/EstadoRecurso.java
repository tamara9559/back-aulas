package aulas.back.recursos;

/**
 * Enumeración que representa los posibles estados de un recurso TIC dentro de un aula.
 * <p>
 * Permite distinguir si un recurso está disponible, no disponible o en mantenimiento.
 * Es utilizada para gestionar la lógica de disponibilidad y uso de los recursos TIC en las aulas.
 * </p>
 * <ul>
 *   <li>{@link #DISPONIBLE} - El recurso está disponible para ser utilizado.</li>
 *   <li>{@link #NO_DISPONIBLE} - El recurso no está disponible temporalmente.</li>
 *   <li>{@link #EN_MANTENIMIENTO} - El recurso está fuera de servicio por mantenimiento.</li>
 * </ul>
 *
 * @author Jan
 */
public enum EstadoRecurso {
    DISPONIBLE,
    NO_DISPONIBLE,
    EN_MANTENIMIENTO
}