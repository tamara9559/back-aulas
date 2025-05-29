package aulas.back.repository;

import aulas.back.recursos.RecursoTIC;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de entidades {@link RecursoTIC} en la base de datos MongoDB.
 * <p>
 * Extiende {@link MongoRepository} para proporcionar operaciones CRUD sobre la colección de recursos TIC,
 * permitiendo registrar, consultar, actualizar y eliminar recursos tecnológicos de las aulas.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     recursoRepository.save(recurso);
 *     List&lt;RecursoTIC&gt; recursos = recursoRepository.findAll();
 * </pre>
 *
 * @author Jan
 */
@Repository
public interface RecursoRepository extends MongoRepository<RecursoTIC, String> {
}
