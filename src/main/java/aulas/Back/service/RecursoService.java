package aulas.Back.service;

import aulas.Back.RecursoTIC;
import aulas.Back.repository.RecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public List<RecursoTIC> listarRecursos() {
        return recursoRepository.findAll();
    }

    public RecursoTIC crearRecurso(RecursoTIC recurso) {
        return recursoRepository.save(recurso);
    }

    public RecursoTIC obtenerRecurso(String id) {
        return recursoRepository.findById(id).orElse(null);
    }

    public boolean eliminarRecurso(String id) {
        if (recursoRepository.existsById(id)) {
            recursoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public RecursoTIC modificarRecurso(String id, RecursoTIC datos) {
        Optional<RecursoTIC> recursoExistente = recursoRepository.findById(id);
        if (recursoExistente.isPresent()) {
            RecursoTIC recurso = recursoExistente.get();
            recurso.setNombre(datos.getNombre());
            recurso.setDescripcion(datos.getDescripcion());
            recurso.setDisponible(datos.isDisponible());
            recurso.setCantidad(datos.getCantidad());
            return recursoRepository.save(recurso);
        }
        return null;
    }
}

