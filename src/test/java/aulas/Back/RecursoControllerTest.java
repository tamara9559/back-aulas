package aulas.Back;
import aulas.Back.controller.RecursoController;
import aulas.Back.service.RecursoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecursoController.class)
class RecursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecursoService recursoService;

    @Test
    void listarRecursos() throws Exception {
        List<RecursoTIC> recursos = List.of(new RecursoTIC("1", "Proyector", "HD", true, 5));
        Mockito.when(recursoService.listarRecursos()).thenReturn(recursos);

        mockMvc.perform(get("/recursos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Proyector"));
    }

    @Test
    void crearRecurso() throws Exception {
        RecursoTIC recurso = new RecursoTIC("1", "Proyector", "HD", true, 5);
        Mockito.when(recursoService.crearRecurso(any(RecursoTIC.class))).thenReturn(recurso);

        String recursoJson = """
        {
            "nombre": "Proyector",
            "descripcion": "HD",
            "disponible": true,
            "cantidad": 5
        }
        """;

        mockMvc.perform(post("/recursos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(recursoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Proyector"));
    }
}
