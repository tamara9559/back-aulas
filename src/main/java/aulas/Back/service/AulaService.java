package aulas.Back.service;

import aulas.Back.Aula;
import aulas.Back.RecursoTIC;
import aulas.Back.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de aulas.
 * Proporciona métodos para listar, crear, obtener, eliminar y modificar aulas.
 *
 * @author Jan
 */
@Service
public class AulaService {

    private final AulaRepository aulaRepository;

    /**
     * Constructor para AulaService.
     * @param aulaRepository Repositorio de aulas.
     */
    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    /**
     * Lista todas las aulas disponibles en la base de datos.
     * @return Lista de aulas.
     */
    public List<Aula> listarAulas() {
        return aulaRepository.findAll();
    }

    /**
     * Crea una nueva aula y la guarda en la base de datos.
     * @param aula Aula a crear.
     * @return Aula creada.
     */
    public Aula crearAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    /**
     * Obtiene una aula por su identificador.
     * @param id Identificador del aula.
     * @return Aula encontrada o null si no existe.
     */
    public Aula obtenerAula(String id) {
        Optional<Aula> aula = aulaRepository.findById(id);
        return aula.orElse(null);
    }

    /**
     * Elimina una aula por su identificador.
     * @param id Identificador del aula.
     * @return true si se eliminó correctamente, false si no existe.
     */
    public boolean eliminarAula(String id) {
        if (aulaRepository.existsById(id)) {
            aulaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Modifica una aula existente.
     * @param id Identificador del aula a modificar.
     * @param aulaDatos Datos actualizados del aula.
     * @return Aula modificada o null si no existe.
     */
    public Aula modificarAula(String id, Aula aulaDatos) {
        Optional<Aula> aulaExistente = aulaRepository.findById(id);
        if (aulaExistente.isPresent()) {
            Aula aula = aulaExistente.get();
            aula.setNombre(aulaDatos.getNombre());
            aula.setCapacidad(aulaDatos.getCapacidad());
            aula.setSedeId(aulaDatos.getSedeId());
            aula.setTipo(aulaDatos.getTipo());
            return aulaRepository.save(aula);
        } else {
            return null;
        }
    }
    public Aula asignarRecursos(String id, List<RecursoTIC> recursos) {
        Optional<Aula> optAula = aulaRepository.findById(id);
        if (optAula.isPresent()) {
            Aula aula = optAula.get();
            aula.asignarRecursos(recursos);
            return aulaRepository.save(aula);
        }
        return null;
    }

}
