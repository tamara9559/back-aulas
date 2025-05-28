package aulas.Back.aula;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa la relación entre un aula y un recurso TIC, incluyendo la cantidad asignada.
 */
@Document(collection = "aula_recursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AulaRecurso {
    @Id
    private String id;
    private String aulaId;
    private String recursoId;
    private int cantidad;

    public AulaRecurso(String aulaId, String id, int cantidad) {
    }
}

