package aulas.back.repository;

import aulas.back.aula.AulaRecurso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repositorio para la gestión de la relación entre aulas y recursos TIC en la base de datos MongoDB.
 * <p>
 * Proporciona métodos para consultar, eliminar y verificar la existencia de asociaciones entre aulas y recursos,
 * extendiendo las operaciones CRUD estándar de {@link MongoRepository}.
 * </p>
 *
 * <b>Métodos personalizados:</b>
 * <ul>
 *   <li>{@link #findByAulaId(String)}: Obtiene todos los recursos asociados a un aula específica.</li>
 *   <li>{@link #findByRecursoId(String)}: Obtiene todas las aulas asociadas a un recurso específico.</li>
 *   <li>{@link #deleteByAulaIdAndRecursoId(String, String)}: Elimina la asociación entre un aula y un recurso.</li>
 *   <li>{@link #existsByAulaIdAndRecursoId(String, String)}: Verifica si existe la asociación entre un aula y un recurso.</li>
 * </ul>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     List&lt;AulaRecurso&gt; recursosAula = aulaRecursoRepository.findByAulaId("aula123");
 *     boolean existe = aulaRecursoRepository.existsByAulaIdAndRecursoId("aula123", "recurso456");
 * </pre>
 *
 * @author Jan
 */
public interface AulaRecursoRepository extends MongoRepository<AulaRecurso, String> {
    /**
     * Busca todos los recursos asociados a un aula específica.
     * @param aulaId ID del aula.
     * @return Lista de asociaciones {@link AulaRecurso}.
     */
    List<AulaRecurso> findByAulaId(String aulaId);

    /**
     * Busca todas las aulas asociadas a un recurso específico.
     * @param recursoId ID del recurso TIC.
     * @return Lista de asociaciones {@link AulaRecurso}.
     */
    List<AulaRecurso> findByRecursoId(String recursoId);

    /**
     * Elimina la asociación entre un aula y un recurso específico.
     * @param aulaId ID del aula.
     * @param recursoId ID del recurso TIC.
     */
    void deleteByAulaIdAndRecursoId(String aulaId, String recursoId);

    /**
     * Verifica si existe una asociación entre un aula y un recurso específico.
     * @param aulaId ID del aula.
     * @param recursoId ID del recurso TIC.
     * @return true si existe la asociación, false en caso contrario.
     */
    boolean existsByAulaIdAndRecursoId(String aulaId, String recursoId);
}
