package aulas.back.aula;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa la relación entre un aula y un recurso TIC, incluyendo la cantidad asignada de ese recurso.
 * <p>
 * Cada instancia de esta clase asocia un aula con un recurso específico y la cantidad de dicho recurso
 * disponible o asignada en el aula. Es útil para gestionar inventario y disponibilidad de recursos TIC
 * dentro de cada aula en el sistema.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     AulaRecurso ar = new AulaRecurso("aula1", "recurso1", 5);
 *     System.out.println(ar.getCantidad()); // Imprime 5
 * </pre>
 *
 * @author Jan
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
    /**
     * Constructor con parámetros específicos para aula, recurso y cantidad.
     *
     * @param aulaId    Identificador del aula.
     * @param recursoId Identificador del recurso TIC.
     * @param cantidad  Cantidad de ese recurso asignada al aula.
     */
    public AulaRecurso(String aulaId, String recursoId, int cantidad) {
        this.aulaId = aulaId;
        this.recursoId = recursoId;
        this.cantidad = cantidad;
    }
}

