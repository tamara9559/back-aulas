package aulas.Back.comando;

import aulas.Back.aula.Aula;

public class ComandoLiberar implements ComandAula {
    private final Aula aula;

    public ComandoLiberar(Aula aula) {
        this.aula = aula;
    }

    @Override
    public void ejecutar() {
        aula.setEstado(aulas.Back.estado.EstadoAulaEnum.LIBRE);
        aula.notificarObservadores();
    }
}

