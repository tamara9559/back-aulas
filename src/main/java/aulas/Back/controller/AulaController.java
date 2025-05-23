package aulas.Back.controller;

import aulas.Back.Aula;
import aulas.Back.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        if (modificada != null) {
            return ResponseEntity.ok(modificada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


