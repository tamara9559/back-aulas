package aulas.Back.validadores;

import aulas.Back.Aula;
import aulas.Back.estado.EstadoReservada;

public class ValidadorDisponibilidad implements ValidadorReserva {
    private ValidadorReserva siguiente;

    public ValidadorDisponibilidad(ValidadorReserva siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public boolean validar(Aula aula) {
        if (aula.getEstadoActual() instanceof EstadoReservada) {
            System.out.println("El aula ya está reservada.");
            return false;
        }
        return siguiente == null || siguiente.validar(aula);
    }
}

