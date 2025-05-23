package aulas.Back.service;

import aulas.Back.Aula;
import aulas.Back.repository.AulaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;

    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public List<Aula> listarAulas() {
        return aulaRepository.findAll();
    }

    public Aula crearAula(Aula aula) {
        return aulaRepository.save(aula); // Mongo generará el ID si es null
    }

    public Aula obtenerAula(String id) {
        Optional<Aula> aula = aulaRepository.findById(id);
        return aula.orElse(null);
    }

    public boolean eliminarAula(String id) {
        if (aulaRepository.existsById(id)) {
            aulaRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Aula modificarAula(String id, Aula aulaDatos) {
        Optional<Aula> aulaExistente = aulaRepository.findById(id);
        if (aulaExistente.isPresent()) {
            Aula aula = aulaExistente.get();
            aula.setNombre(aulaDatos.getNombre());
            aula.setCapacidad(aulaDatos.getCapacidad());
            aula.setSedeId(aulaDatos.getSedeId());
            aula.setTipoId(aulaDatos.getTipoId());
            return aulaRepository.save(aula);
        } else {
            return null;
        }
    }


}

