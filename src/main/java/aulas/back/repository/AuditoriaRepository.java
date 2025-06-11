package aulas.back.repository;

import aulas.back.AuditoriaEvento;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio de acceso a datos para eventos de auditoría.
 * <p>
 * Extiende {@link MongoRepository} para proporcionar operaciones CRUD sobre la colección
 * de auditoría en MongoDB, permitiendo registrar y consultar eventos de auditoría relacionados con las aulas.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     auditoriaRepository.save(evento);
 *     List&lt;AuditoriaEvento&gt; eventos = auditoriaRepository.findAll();
 * </pre>
 *
 * @author Jan
 */
public interface AuditoriaRepository extends MongoRepository<AuditoriaEvento, String> {
}
