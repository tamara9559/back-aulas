package aulas.Back.controller;

import aulas.Back.Aula;
import aulas.Back.service.AulaService;
import aulas.Back.service.ReservaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService = new ReservaService();
    private final AulaService aulaService = new AulaService();

    @PostMapping("/{id}")
    public String reservarAula(@PathVariable String id) {
        Aula aula = aulaService.obtenerAula(id);
        if (aula == null) {
            return "Aula no encontrada";
        }

        boolean reservada = reservaService.reservarAula(aula);
        return reservada ? "Aula reservada correctamente" : "No se pudo reservar el aula";
    }
}

