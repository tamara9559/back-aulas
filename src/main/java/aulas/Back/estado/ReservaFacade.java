package aulas.Back.estado;

import aulas.Back.Aula;
import aulas.Back.estado.EstadoReservada;
import aulas.Back.validadores.*;

public class ReservaFacade {

    public boolean reservarAula(Aula aula) {
        ValidadorReserva validador = new ValidadorCapacidad(
                new ValidadorRecursos(
                        new ValidadorDisponibilidad(null)
                )
        );

        if (validador.validar(aula)) {
            aula.cambiarEstado(new EstadoReservada());
            return true;
        }
        return false;
    }
}

