package aulas.Back.comando;

import aulas.Back.Aula;
import aulas.Back.estado.EstadoReservada;

public class ComandReservar implements ComandAula {
    private Aula aula;

    public ComandReservar(Aula aula) {
        this.aula = aula;
    }

    public void ejecutar() {
        aula.cambiarEstado(new EstadoReservada());
    }
}

