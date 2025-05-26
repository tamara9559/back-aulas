package aulas.Back;
import aulas.Back.aula.Aula;
import aulas.Back.controller.AulaController;
import aulas.Back.service.AulaService;
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

@WebMvcTest(AulaController.class)
class AulaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AulaService aulaService;

    @Test
    void listarAulas() throws Exception {
        List<Aula> aulas = List.of(new Aula("1", "Aula1", 30, "SEDE1", "TIPO1", null, null));
        Mockito.when(aulaService.listarAulas()).thenReturn(aulas);

        mockMvc.perform(get("/aulas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Aula1"));
    }

    @Test
    void crearAula() throws Exception {
        Aula aula = new Aula("1", "Aula1", 30, "SEDE1", "TIPO1", null, null);
        Mockito.when(aulaService.crearAula(any(Aula.class))).thenReturn(aula);

        String aulaJson = """
        {
            "nombre": "Aula1",
            "capacidad": 30,
            "sedeId": "SEDE1",
            "tipoId": "TIPO1",
            "recursos": []
        }
        """;

        mockMvc.perform(post("/aulas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aulaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Aula1"));
    }
}