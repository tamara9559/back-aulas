package aulas.back.service;

import aulas.back.aula.Aula;
import aulas.back.aula.AulaRecurso;
import aulas.back.decorador.AulaConcreta;
import aulas.back.decorador.IAula;
import aulas.back.factory.AulaFactory;
import aulas.back.recursos.RecursoTIC;
import aulas.back.repository.AulaRepository;
import aulas.back.repository.AulaRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;
    private final AulaRecursoRepository aulaRecursoRepository;
    private final RecursoService recursoService;

    public AulaService(AulaRepository aulaRepository,
                       AulaRecursoRepository aulaRecursoRepository,
                       RecursoService recursoService) {
        this.aulaRepository = aulaRepository;
        this.aulaRecursoRepository = aulaRecursoRepository;
        this.recursoService = recursoService;
    }

    public List<Aula> listarAulas() {
        List<Aula> aulas = aulaRepository.findAll();

        for (Aula aula : aulas) {
            List<AulaRecurso> relaciones = aulaRecursoRepository.findByAulaId(aula.getId());

            List<RecursoTIC> recursos = relaciones.stream()
                    .map(rel -> {
                        RecursoTIC recurso = recursoService.obtenerRecurso(rel.getRecursoId());
                        if (recurso != null) {
                            recurso.setCantidad(rel.getCantidad()); // ⬅ cantidad asignada al aula
                        }
                        return recurso;
                    })
                    .filter(r -> r != null)
                    .toList();

            aula.setRecursos(recursos);
        }

        return aulas;
    }


    public Aula crearAula(Aula aula) {
        boolean existe = aulaRepository.findAll().stream()
                .anyMatch(existing -> existing.getNombre().equalsIgnoreCase(aula.getNombre()));

        if (existe) {
            throw new IllegalArgumentException("Ya existe un aula con ese nombre.");
        }

        return aulaRepository.save(aula);
    }

    public Aula obtenerAula(String id) {
        return aulaRepository.findById(id).orElse(null);
    }

    public boolean eliminarAula(String id) {
        if (aulaRepository.existsById(id)) {
            aulaRepository.deleteById(id);
            aulaRecursoRepository.deleteAll(aulaRecursoRepository.findByAulaId(id));
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
            aula.setTipo(aulaDatos.getTipo());
            aula.setEstado(aulaDatos.getEstado());

            aula.notificarObservadores();

            return aulaRepository.save(aula);
        } else {
            return null;
        }
    }


    public boolean asignarRecurso(String aulaId, List<RecursoTIC> recursos) {
        for (RecursoTIC recurso : recursos) {
            RecursoTIC existente = recursoService.obtenerRecurso(recurso.getId());
            if (existente == null) {
                throw new IllegalArgumentException("Recurso no encontrado: " + recurso.getId());
            }

            if (existente.getCantidad() < recurso.getCantidad()) {
                throw new IllegalArgumentException("Cantidad insuficiente del recurso: " + existente.getNombre());
            }

            if (aulaRecursoRepository.existsByAulaIdAndRecursoId(aulaId, recurso.getId())) {
                throw new IllegalArgumentException("Recurso ya asignado: " + existente.getNombre());
            }

            // Descontar stock y guardar relación
            existente.setCantidad(existente.getCantidad() - recurso.getCantidad());
            recursoService.modificarRecurso(existente.getId(), existente);

            AulaRecurso ar = new AulaRecurso(aulaId, recurso.getId(), recurso.getCantidad());
            aulaRecursoRepository.save(ar);
        }
        return true;
    }

    public boolean removerRecurso(String aulaId, RecursoTIC recurso) {
        if (aulaRecursoRepository.existsByAulaIdAndRecursoId(aulaId, recurso.getId())) {
            aulaRecursoRepository.deleteByAulaIdAndRecursoId(aulaId, recurso.getId());
            return true;
        }
        return false;
    }

    public List<RecursoTIC> listarRecursos(String aulaId) {
        List<AulaRecurso> relaciones = aulaRecursoRepository.findByAulaId(aulaId);
        return relaciones.stream()
                .map(rel -> recursoService.obtenerRecurso(rel.getRecursoId()))
                .filter(r -> r != null)
                .toList();
    }

    public void crearAulaDesdeDecorador(IAula decorada) {
        Aula aula = ((AulaConcreta) decorada).getAula();
        aulaRepository.save(aula);

        List<RecursoTIC> recursos = decorada.getRecursos();
        for (RecursoTIC recurso : recursos) {
            AulaRecurso ar = new AulaRecurso(aula.getId(), recurso.getId(), recurso.getCantidad());
            aulaRecursoRepository.save(ar);
        }
    }

    public Aula crearAulaDesdeFactory(AulaFactory factory) {
        Aula aula = factory.crearAula();
        return aulaRepository.save(aula);
    }


}


