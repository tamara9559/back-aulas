package aulas.Back.observador;

import aulas.Back.AuditoriaEvento;
import aulas.Back.aula.Aula;
import aulas.Back.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Observador que registra eventos de auditoría cuando el estado de un aula cambia.
 */
@Component
public class AuditorEventos implements ObservadorAula {

    private static AuditoriaRepository auditoriaRepository;

    public AuditorEventos() {
    }

    @Autowired
    public AuditorEventos(AuditoriaRepository repo) {
        AuditorEventos.auditoriaRepository = repo;
    }

    @Override
    public void actualizar(Aula aula) {
        AuditoriaEvento evento = new AuditoriaEvento(
                "Aula", aula.getId(), "CAMBIO_ESTADO", "El aula cambió a estado: " + aula.getEstado()
        );
        auditoriaRepository.save(evento);
    }
}

