package aulas.back.controller;

import aulas.back.recursos.RecursoTIC;
import aulas.back.service.RecursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de recursos TIC.
 * <p>
 * Proporciona endpoints para listar, crear, obtener, modificar y eliminar recursos TIC del sistema.
 * Utiliza {@link RecursoService} para la lógica de negocio relacionada con los recursos.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     GET    /recursos         // Lista todos los recursos TIC
 *     POST   /recursos         // Crea un nuevo recurso TIC
 *     GET    /recursos/{id}    // Obtiene un recurso TIC por su ID
 *     PUT    /recursos/{id}    // Modifica un recurso TIC por su ID
 *     DELETE /recursos/{id}    // Elimina un recurso TIC por su ID
 * </pre>
 *
 * @author Jan
 */
@CrossOrigin(origins = "http://localhost:3001")
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