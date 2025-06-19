package aulas.back.controller;

import aulas.back.auditoria.AuditoriaEvento;
import aulas.back.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para consultar el historial de eventos de auditoría.
 */
@RestController
@RequestMapping("/auditoria")
public class AuditoriaController {

    private final AuditoriaRepository auditoriaRepository;

    @Autowired
    public AuditoriaController(AuditoriaRepository auditoriaRepository) {
        this.auditoriaRepository = auditoriaRepository;
    }

    /**
     * Obtiene todos los eventos de auditoría asociados a una entidad específica.
     *
     * @param entidadId ID del aula o entidad auditada.
     * @return Lista de eventos de auditoría correspondientes.
     */
    @GetMapping("/aula/{entidadId}")
    public List<AuditoriaEvento> obtenerHistorialPorAula(@PathVariable String entidadId) {
        return auditoriaRepository.findByEntidadId(entidadId);
    }
}

