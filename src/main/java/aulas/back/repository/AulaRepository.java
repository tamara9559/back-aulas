package aulas.back.repository;

import aulas.back.aula.Aula;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de entidades {@link Aula} en la base de datos MongoDB.
 * <p>
 * Extiende {@link MongoRepository} para proporcionar operaciones CRUD sobre la colección de aulas,
 * permitiendo registrar, consultar, actualizar y eliminar aulas.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     aulaRepository.save(aula);
 *     List&lt;Aula&gt; aulas = aulaRepository.findAll();
 * </pre>
 *
 * @author Jan
 */
@Repository
public interface AulaRepository extends MongoRepository<Aula, String> {
}
