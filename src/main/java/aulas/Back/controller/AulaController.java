package aulas.Back.controller;

import aulas.Back.Aula;
import aulas.Back.RecursoTIC;
import aulas.Back.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de aulas.
 * Expone endpoints para listar, crear, obtener, eliminar y modificar aulas.
 *
 * @author Jan
 */
@RestController
@RequestMapping("/aulas")
public class AulaController {

    private final AulaService aulaService;

    /**
     * Constructor para AulaController.
     * @param aulaService Servicio de gestión de aulas.
     */
    @Autowired
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    /**
     * Lista todas las aulas disponibles.
     * @return Lista de aulas.
     */
    @GetMapping
    public List<Aula> listarAulas() {
        return aulaService.listarAulas();
    }

    /**
     * Crea una nueva aula.
     * @param aula Aula a crear.
     * @return Aula creada.
     */
    @PostMapping
    public Aula crearAula(@RequestBody Aula aula) {
        return aulaService.crearAula(aula);
    }

    /**
     * Obtiene una aula por su identificador.
     * @param id Identificador del aula.
     * @return Aula encontrada o null si no existe.
     */
    @GetMapping("/{id}")
    public Aula obtenerAula(@PathVariable String id) {
        return aulaService.obtenerAula(id);
    }

    /**
     * Elimina una aula por su identificador.
     * @param id Identificador del aula.
     * @return true si se eliminó correctamente, false si no existe.
     */
    @DeleteMapping("/{id}")
    public boolean eliminarAula(@PathVariable String id) {
        return aulaService.eliminarAula(id);
    }

    /**
     * Modifica una aula existente.
     * @param id Identificador del aula a modificar.
     * @param aula Datos actualizados del aula.
     * @return ResponseEntity con el aula modificada o 404 si no existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Aula> modificarAula(@PathVariable String id, @RequestBody Aula aula) {
        Aula modificada = aulaService.modificarAula(id, aula);
        if (modificada != null) {
            return ResponseEntity.ok(modificada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/recursos")
    public ResponseEntity<Aula> asignarRecursos(
            @PathVariable String id,
            @RequestBody List<RecursoTIC> recursos
    ) {
        Aula aula = aulaService.asignarRecursos(id, recursos);
        return aula != null ? ResponseEntity.ok(aula) : ResponseEntity.notFound().build();
    }

}