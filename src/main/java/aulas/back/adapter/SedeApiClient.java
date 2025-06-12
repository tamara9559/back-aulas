package aulas.back.adapter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SedeApiClient {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8081/sedes"; // Ajusta la URL cuando se defina

    public SedeApiClient() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Consulta el módulo de sedes y devuelve true si la sede existe.
     * También puedes adaptarlo para retornar un objeto SedeDTO.
     */
    public boolean existeSedePorId(String sedeId) {
        try {
            String url = UriComponentsBuilder
                    .fromHttpUrl(baseUrl)
                    .pathSegment(sedeId)
                    .toUriString();

            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
