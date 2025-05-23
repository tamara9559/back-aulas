package aulas.Back.controller;

import aulas.Back.RecursoTIC;
import aulas.Back.service.RecursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    public List<RecursoTIC> listarRecursos() {
        return recursoService.listarRecursos();
    }

    @PostMapping
    public RecursoTIC crearRecurso(@RequestBody RecursoTIC recurso) {
        return recursoService.crearRecurso(recurso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoTIC> obtenerRecurso(@PathVariable String id) {
        RecursoTIC recurso = recursoService.obtenerRecurso(id);
        if (recurso != null) {
            return ResponseEntity.ok(recurso);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecurso(@PathVariable String id) {
        boolean eliminado = recursoService.eliminarRecurso(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoTIC> modificarRecurso(@PathVariable String id, @RequestBody RecursoTIC recurso) {
        RecursoTIC actualizado = recursoService.modificarRecurso(id, recurso);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
