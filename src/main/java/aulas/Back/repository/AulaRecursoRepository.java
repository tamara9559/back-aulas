package aulas.Back.repository;

import aulas.Back.aula.AulaRecurso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AulaRecursoRepository extends MongoRepository<AulaRecurso, String> {
    List<AulaRecurso> findByAulaId(String aulaId);
    List<AulaRecurso> findByRecursoId(String recursoId);
    void deleteByAulaIdAndRecursoId(String aulaId, String recursoId);
    boolean existsByAulaIdAndRecursoId(String aulaId, String recursoId);
}

