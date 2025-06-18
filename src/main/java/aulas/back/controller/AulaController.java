package aulas.back.controller;

import aulas.back.aula.PrototipoAula;
import aulas.back.aula.Aula;
import aulas.back.factory.AulaFactory;
import aulas.back.factory.AulaHibridaFactory;
import aulas.back.factory.AulaLaboratorioFactory;
import aulas.back.factory.AulaTeoricaFactory;
import aulas.back.recursos.RecursoTIC;
import aulas.back.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de aulas.
 * <p>
 * Expone endpoints para listar, crear, obtener, eliminar, modificar y gestionar recursos asociados a aulas.
 * Permite también consultar la descripción textual del estado y los recursos asignados a un aula.
 * Utiliza {@link AulaService} para la lógica de negocio.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     GET    /aulas                // Lista todas las aulas
 *     POST   /aulas                // Crea una nueva aula
 *     GET    /aulas/{id}           // Obtiene información de un aula por ID
 *     DELETE /aulas/{id}           // Elimina un aula por ID
 *     PUT    /aulas/{id}           // Modifica datos de un aula por ID
 *     POST   /aulas/{id}/recursos  // Asigna recursos TIC a un aula
 *     DELETE /aulas/{id}/recursos  // Remueve un recurso TIC de un aula
 *     GET    /aulas/{id}/estado-descripcion // Obtiene la descripción textual del estado de un aula
 *     GET    /aulas/{id}/recursos  // Lista los recursos TIC asociados a un aula
 * </pre>
 *
 * @author Jan
 */
@CrossOrigin(origins = "http://localhost:3001")
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

    @PostMapping("/factory/teorica")
    public ResponseEntity<Aula> crearAulaTeorica() {
        AulaFactory factory = new AulaTeoricaFactory();
        Aula aula = aulaService.crearAulaDesdeFactory(factory);
        return ResponseEntity.ok(aula);
    }

    @PostMapping("/factory/hibrida")
    public ResponseEntity<Aula> crearAulaHibrida() {
        AulaFactory factory = new AulaHibridaFactory();
        Aula aula = aulaService.crearAulaDesdeFactory(factory);
        return ResponseEntity.ok(aula);
    }

    @PostMapping("/factory/laboratorio")
    public ResponseEntity<Aula> crearAulaLaboratorio() {
        AulaFactory factory = new AulaLaboratorioFactory();
        Aula aula = aulaService.crearAulaDesdeFactory(factory);
        return ResponseEntity.ok(aula);
    }



}

