package aulas.Back.repository;

import aulas.Back.AuditoriaEvento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditoriaRepository extends MongoRepository<AuditoriaEvento, String> {
}

