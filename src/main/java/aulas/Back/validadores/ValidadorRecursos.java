package aulas.Back.validadores;

import aulas.Back.Aula;

/**
 * Validador que comprueba si el aula dispone de los recursos TIC necesarios para la reserva.
 * Forma parte de una cadena de validadores bajo el patrón Chain of Responsibility.
 *
 * @author Jan
 */
public class ValidadorRecursos implements ValidadorReserva {

    private final ValidadorReserva siguiente;

    /**
     * Constructor.
     *
     * @param siguiente Siguiente validador en la cadena, o {@code null} si es el último.
     */
    public ValidadorRecursos(ValidadorReserva siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public boolean validar(Aula aula) {
        // Ejemplo: validar que el aula tenga al menos un recurso TIC
        if (aula.getRecursos() == null || aula.getRecursos().isEmpty()) return false;
        return siguiente == null || siguiente.validar(aula);
    }
}