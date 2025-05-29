package aulas.back.observador;

import aulas.back.AuditoriaEvento;
import aulas.back.aula.Aula;
import aulas.back.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Observador que registra eventos de auditoría cuando el estado de un aula cambia.
 * <p>
 * Implementa el patrón Observer reaccionando a cambios de estado en {@link Aula} y
 * registrando dichos cambios en el repositorio de auditoría.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     // Suponiendo que una instancia de Aula cambia de estado...
 *     aula.setEstado(EstadoAulaEnum.RESERVADA);
 *     // El observador AuditorEventos registra un evento de auditoría automáticamente.
 * </pre>
 *
 * @author Jan
 */
@Component
public class AuditorEventos implements ObservadorAula {

    private final AuditoriaRepository auditoriaRepository;

    /**
     * Constructor principal con inyección de dependencias.
     *
     * @param repo Repositorio de auditoría a utilizar para guardar eventos.
     */
    @Autowired
    public AuditorEventos(AuditoriaRepository repo) {
        this.auditoriaRepository = repo;
    }

    /**
     * Método invocado cuando el aula cambia de estado. Registra el evento en la auditoría.
     *
     * @param aula Aula cuyo estado ha cambiado.
     */
    @Override
    public void actualizar(Aula aula) {
        AuditoriaEvento evento = new AuditoriaEvento(
                "Aula", aula.getId(), "CAMBIO_ESTADO", "El aula cambió a estado: " + aula.getEstado()
        );
        auditoriaRepository.save(evento);
    }
}