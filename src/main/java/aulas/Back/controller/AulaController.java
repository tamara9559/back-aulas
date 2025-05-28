package aulas.Back.controller;

import aulas.Back.aula.PrototipoAula;
import aulas.Back.aula.Aula;
import aulas.Back.recursos.RecursoTIC;
import aulas.Back.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de aulas.
 * Expone endpoints para listar, crear, obtener, eliminar y modificar aulas.
 */
@RestController
@RequestMapping("/aulas")
public class AulaController {

    private final AulaService aulaService;

    @Autowired
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping
    public List<Aula> listarAulas() {
        return aulaService.listarAulas();
    }

    @PostMapping
    public Aula crearAula(@RequestBody Aula aula) {
        return aulaService.crearAula(aula);
    }

    @GetMapping("/{id}")
    public Aula obtenerAula(@PathVariable String id) {
        return aulaService.obtenerAula(id);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarAula(@PathVariable String id) {
        return aulaService.eliminarAula(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> modificarAula(@PathVariable String id, @RequestBody Aula aula) {
        Aula modificada = aulaService.modificarAula(id, aula);
        return modificada != null ? ResponseEntity.ok(modificada) : ResponseEntity.notFound().build();
    }

    //  Asignar uno o varios recursos a un aula
    @PostMapping("/{id}/recursos")
    public ResponseEntity<String> asignarRecursos(
            @PathVariable String id,
            @RequestBody List<RecursoTIC> recursos
    ) {
        boolean resultado = aulaService.asignarRecurso(id, recursos);
        return resultado
                ? ResponseEntity.ok("Recursos asignados correctamente.")
                : ResponseEntity.badRequest().body("Error al asignar los recursos.");
    }

    //  Remover recurso de un aula
    @DeleteMapping("/{id}/recursos")
    public ResponseEntity<String> removerRecurso(
            @PathVariable String id,
            @RequestBody RecursoTIC recurso
    ) {
        boolean resultado = aulaService.removerRecurso(id, recurso);
        return resultado
                ? ResponseEntity.ok("Recurso removido correctamente.")
                : ResponseEntity.badRequest().body("Error al remover el recurso.");
    }

    @GetMapping("/{id}/estado-descripcion")
    public ResponseEntity<String> obtenerDescripcionEstado(@PathVariable String id) {
        Aula aula = aulaService.obtenerAula(id);
        return aula != null
                ? ResponseEntity.ok(aula.getEstadoActual().descripcion())
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/recursos")
    public ResponseEntity<List<RecursoTIC>> listarRecursos(@PathVariable String id) {
        List<RecursoTIC> recursos = aulaService.listarRecursos(id);
        return recursos != null
                ? ResponseEntity.ok(recursos)
                : ResponseEntity.notFound().build();
    }

    //  Crear aula clonando un prototipo
    @PostMapping("/clonar/{tipo}")
    public ResponseEntity<Aula> clonarAulaDesdePrototipo(
            @PathVariable String tipo,
            @RequestParam String nombre,
            @RequestParam String sedeId
    ) {
        Aula clon = PrototipoAula.clonar(tipo);
        if (clon == null) return ResponseEntity.notFound().build();

        clon.setNombre(nombre);
        clon.setSedeId(sedeId);

        Aula guardada = aulaService.crearAula(clon);
        return ResponseEntity.ok(guardada);
    }


}

