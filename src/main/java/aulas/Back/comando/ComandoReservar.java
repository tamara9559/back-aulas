package aulas.Back.comando;

import aulas.Back.aula.Aula;

public class ComandoReservar implements ComandAula {
    private final Aula aula;

    public ComandoReservar(Aula aula) {
        this.aula = aula;
    }

    @Override
    public void ejecutar() {
        aula.setEstado(aulas.Back.estado.EstadoAulaEnum.RESERVADA);
        aula.notificarObservadores();
    }
}

