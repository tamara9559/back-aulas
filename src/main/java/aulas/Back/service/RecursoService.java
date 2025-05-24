package aulas.Back.service;

import aulas.Back.RecursoTIC;
import aulas.Back.repository.RecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de recursos TIC.
 * Proporciona métodos para listar, crear, obtener, eliminar y modificar recursos TIC.
 *
 * @author Jan
 */
@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    /**
     * Constructor para RecursoService.
     * @param recursoRepository Repositorio de recursos TIC.
     */
    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    /**
     * Lista todos los recursos TIC disponibles en la base de datos.
     * @return Lista de recursos TIC.
     */
    public List<RecursoTIC> listarRecursos() {
        return recursoRepository.findAll();
    }

    /**
     * Crea un nuevo recurso TIC y lo guarda en la base de datos.
     * @param recurso Recurso TIC a crear.
     * @return Recurso TIC creado.
     */
    public RecursoTIC crearRecurso(RecursoTIC recurso) {
        return recursoRepository.save(recurso);
    }

    /**
     * Obtiene un recurso TIC por su identificador.
     * @param id Identificador del recurso TIC.
     * @return Recurso TIC encontrado o null si no existe.
     */
    public RecursoTIC obtenerRecurso(String id) {
        return recursoRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un recurso TIC por su identificador.
     * @param id Identificador del recurso TIC.
     * @return true si se eliminó correctamente, false si no existe.
     */
    public boolean eliminarRecurso(String id) {
        if (recursoRepository.existsById(id)) {
            recursoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Modifica un recurso TIC existente.
     * @param id Identificador del recurso a modificar.
     * @param datos Datos actualizados del recurso TIC.
     * @return Recurso TIC modificado o null si no existe.
     */
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

