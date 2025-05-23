package aulas.Back.repository;

import aulas.Back.Aula;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends MongoRepository<Aula, String> {
}

