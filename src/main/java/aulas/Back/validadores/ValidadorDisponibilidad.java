package aulas.Back.validadores;

import aulas.Back.Aula;
import aulas.Back.estado.EstadoReservada;

/**
 * Validador que comprueba si un aula está disponible para ser reservada.
 * <p>
 * Forma parte de la cadena de responsabilidad (Chain of Responsibility) de validadores de reserva.
 * Si el aula ya está en estado reservado, la validación falla.
 * En caso contrario, delega la validación al siguiente validador en la cadena, si existe.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     ValidadorReserva validador = new ValidadorDisponibilidad(null);
 *     boolean disponible = validador.validar(aula);
 * </pre>
 *
 * @author Jan
 */
public class ValidadorDisponibilidad implements ValidadorReserva {
    /** Siguiente validador en la cadena. */
    private ValidadorReserva siguiente;

    /**
     * Constructor.
     *
     * @param siguiente El siguiente validador de la cadena, o {@code null} si es el último.
     */
    public ValidadorDisponibilidad(ValidadorReserva siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Valida si el aula está disponible para reservar.
     * Si el aula está en estado reservado, retorna {@code false}.
     * Si no, delega la validación al siguiente validador en la cadena (si existe).
     *
     * @param aula Aula a validar.
     * @return {@code true} si el aula está disponible y pasa todas las validaciones; {@code false} en caso contrario.
     */
    @Override
    public boolean validar(Aula aula) {
        if (aula.getEstadoActual() instanceof EstadoReservada) {
            System.out.println("El aula ya está reservada.");
            return false;
        }
        return siguiente == null || siguiente.validar(aula);
    }
}