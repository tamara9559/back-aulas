package aulas.Back.validadores;


import aulas.Back.Aula;

public class ValidadorCapacidad implements ValidadorReserva {
    private ValidadorReserva siguiente;

    public ValidadorCapacidad(ValidadorReserva siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public boolean validar(Aula aula) {
        if (aula.getCapacidad() <= 0) {
            System.out.println("Capacidad no válida.");
            return false;
        }
        return siguiente == null || siguiente.validar(aula);
    }
}

