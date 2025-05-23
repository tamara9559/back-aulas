package aulas.Back.repository;

import aulas.Back.RecursoTIC;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends MongoRepository<RecursoTIC, String> {
}
