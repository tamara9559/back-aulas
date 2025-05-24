package aulas.Back.controller;

import aulas.Back.RecursoTIC;
import aulas.Back.service.RecursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de recursos TIC.
 * Expone endpoints para listar, crear, obtener, eliminar y modificar recursos TIC.
 *
 * @author Jan
 */
@RestController
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    /**
     * Constructor para RecursoController.
     * @param recursoService Servicio de gestión de recursos TIC.
     */
    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    /**
     * Lista todos los recursos TIC disponibles.
     * @return Lista de recursos TIC.
     */
    @GetMapping
    public List<RecursoTIC> listarRecursos() {
        return recursoService.listarRecursos();
    }

    /**
     * Crea un nuevo recurso TIC.
     * @param recurso Recurso TIC a crear.
     * @return Recurso TIC creado.
     */
    @PostMapping
    public RecursoTIC crearRecurso(@RequestBody RecursoTIC recurso) {
        return recursoService.crearRecurso(recurso);
    }

    /**
     * Obtiene un recurso TIC por su identificador.
     * @param id Identificador del recurso TIC.
     * @return ResponseEntity con el recurso TIC encontrado o 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecursoTIC> obtenerRecurso(@PathVariable String id) {
        RecursoTIC recurso = recursoService.obtenerRecurso(id);
        if (recurso != null) {
            return ResponseEntity.ok(recurso);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Elimina un recurso TIC por su identificador.
     * @param id Identificador del recurso TIC.
     * @return ResponseEntity con estado 204 si se eliminó, 404 si no existe.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecurso(@PathVariable String id) {
        boolean eliminado = recursoService.eliminarRecurso(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Modifica un recurso TIC existente.
     * @param id Identificador del recurso TIC a modificar.
     * @param recurso Datos actualizados del recurso TIC.
     * @return ResponseEntity con el recurso TIC modificado o 404 si no existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<RecursoTIC> modificarRecurso(@PathVariable String id, @RequestBody RecursoTIC recurso) {
        RecursoTIC actualizado = recursoService.modificarRecurso(id, recurso);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }
}