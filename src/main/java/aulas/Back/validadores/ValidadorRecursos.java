package aulas.Back.validadores;

import aulas.Back.Aula;
import aulas.Back.RecursoTIC;

public class ValidadorRecursos implements ValidadorReserva {
    private ValidadorReserva siguiente;

    public ValidadorRecursos(ValidadorReserva siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public boolean validar(Aula aula) {
        for (RecursoTIC recurso : aula.getRecursos()) {
            if (!recurso.isDisponible()) {
                System.out.println("Recurso no disponible: " + recurso.getNombre());
                return false;
            }
        }
        return siguiente == null || siguiente.validar(aula);
    }
}

