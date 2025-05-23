package aulas.Back.validadores;

import aulas.Back.Aula;

/**
 * Validador que verifica si el aula tiene la capacidad suficiente para una reserva.
 * Implementa el patrón Chain of Responsibility permitiendo encadenar otros validadores.
 *
 * @author Jan
 */
public class ValidadorCapacidad implements ValidadorReserva {

    private final ValidadorReserva siguiente;

    /**
     * Constructor.
     *
     * @param siguiente Siguiente validador en la cadena, o {@code null} si es el último.
     */
    public ValidadorCapacidad(ValidadorReserva siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public boolean validar(Aula aula) {
        // Ejemplo: validar que la capacidad sea mayor a 0
        if (aula.getCapacidad() <= 0) return false;
        return siguiente == null || siguiente.validar(aula);
    }
}

