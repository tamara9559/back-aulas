package aulas.Back;

import lombok.Getter;
import lombok.Setter;

/**
 * Representa una sede institucional, que puede contener varias aulas y recursos asociados.
 * Incluye información sobre el identificador de la sede, su nombre y ubicación física.
 *
 * Proporciona métodos para obtener y modificar sus atributos, así como para calcular la distancia
 * entre dos sedes (simulado en este caso).
 *
 * @author Jan
 */
@Getter
@Setter
class Sede {
    /** Identificador único de la sede. */
    private String id;

    /** Nombre descriptivo de la sede. */
    private String nombre;

    /** Ubicación física o dirección de la sede. */
    private String ubicacion;

    /**
     * Crea una nueva instancia de Sede con los datos especificados.
     *
     * @param id        Identificador único de la sede.
     * @param nombre    Nombre descriptivo de la sede.
     * @param ubicacion Ubicación física o dirección de la sede.
     */
    public Sede(String id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    /**
     * Calcula la distancia entre esta sede y otra sede.
     * <p>
     * Actualmente, esta implementación es una simulación y siempre retorna 0.0.
     * En una futura versión, se podría calcular la distancia real usando las ubicaciones.
     * </p>
     *
     * @param otra Otra sede con la que calcular la distancia.
     * @return Distancia calculada (simulada: siempre 0.0).
     */
    public float calcularDistancia(Sede otra) {
        return 0.0f; // simulación
    }
}