package aulas.Back.service;

import aulas.Back.Aula;
import aulas.Back.ReservaFacade;

public class ReservaService {

    private final ReservaFacade reservaFacade = new ReservaFacade();

    public boolean reservarAula(Aula aula) {
        return reservaFacade.reservarAula(aula);
    }
}

