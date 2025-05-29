package aulas.back.estado;

/**
 * Enumeración que representa los posibles estados de un aula dentro del sistema.
 * <p>
 * Permite distinguir entre aulas disponibles, reservadas, en mantenimiento o inhabilitadas.
 * Es utilizada para gestionar la lógica de disponibilidad y uso de las aulas.
 * </p>
 *
 * <ul>
 *   <li>{@link #LIBRE} - El aula está disponible para ser utilizada o reservada.</li>
 *   <li>{@link #RESERVADA} - El aula está actualmente reservada para un evento o clase.</li>
 *   <li>{@link #EN_MANTENIMIENTO} - El aula está fuera de servicio temporalmente por tareas de mantenimiento.</li>
 *   <li>{@link #INHABILITADA} - El aula está permanentemente fuera de uso.</li>
 * </ul>
 *
 * @author Jan
 */
public enum EstadoAulaEnum {
    LIBRE,
    RESERVADA,
    EN_MANTENIMIENTO,
    INHABILITADA
}
