package aulas.back.adapter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Cliente HTTP para interactuar con el módulo externo de sedes.
 * <p>
 * Esta clase permite consultar la existencia de una sede mediante su identificador
 * consumiendo un servicio REST externo. El endpoint base puede ser ajustado según el entorno.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     SedeApiClient sedeApiClient = new SedeApiClient();
 *     boolean existe = sedeApiClient.existeSedePorId("SEDE123");
 * </pre>
 *
 * @author Jan
 */
@Service
public class SedeApiClient {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8081/sedes"; // Ajusta la URL cuando se defina
    /**
     * Constructor por defecto. Inicializa el RestTemplate.
     */

    public SedeApiClient() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Consulta el módulo de sedes y devuelve true si la sede existe.
     * <p>
     * Realiza una petición GET al endpoint correspondiente utilizando el identificador de la sede.
     * Si la sede no existe o hay algún error de red, retorna false.
     * </p>
     * También puedes adaptar este método para retornar un objeto SedeDTO en lugar de solo true/false.
     *
     * @param sedeId Identificador único de la sede a consultar.
     * @return true si la sede existe, false en caso contrario.
     */

    public boolean existeSedePorId(String sedeId) {
        try {
            String url = UriComponentsBuilder
                    .newInstance() // Instancia de UriComponentsBuilder
                    .uri(URI.create(baseUrl)) // Convierte el String en un URI
                    .pathSegment(sedeId)
                    .toUriString();

            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

