package aulas.Back;

import aulas.Back.estado.EstadoAula;
import aulas.Back.observador.ObservadorAula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un aula dentro del sistema.
 * Permite gestionar recursos TIC, observadores de cambios de estado y el propio estado del aula.
 * <p>
 * Implementa los patrones de diseño Observer (para notificar cambios en el estado del aula a los observadores)
 * y Builder (para construir objetos Aula de forma flexible).
 * </p>
 *
 * @author Jan
 */
@Document(collection = "aulas")
public class Aula implements Cloneable {
    /** Identificador único del aula. */
    @Setter
    @Getter
    @Id
    private String id;

    /** Nombre descriptivo del aula. */
    @Setter
    @Getter
    private String nombre;

    /** Capacidad máxima de personas para el aula. */
    @Setter
    @Getter
    private int capacidad;

    /** Identificador de la sede a la que pertenece el aula. */
    @Setter
    @Getter
    private String sedeId;

    /** Identificador del tipo de aula. */
    @Setter
    @Getter
    private String tipoId;

    /** Estado actual del aula (ej. disponible, reservada, etc). */
    private EstadoAula estadoActual;

    /** Lista de recursos TIC asociados al aula. */
    private List<RecursoTIC> recursos;

    /** Lista de observadores que serán notificados ante cambios de estado. */
    private List<ObservadorAula> observadores = new ArrayList<>();

    /**
     * Constructor principal.
     *
     * @param id           Identificador del aula.
     * @param nombre       Nombre del aula.
     * @param capacidad    Capacidad máxima.
     * @param sedeId       Identificador de la sede.
     * @param tipoId       Identificador del tipo de aula.
     * @param estadoActual Estado actual del aula.
     * @param recursos     Lista de recursos TIC asociados.
     */
    public Aula(String id, String nombre, int capacidad, String sedeId, String tipoId, EstadoAula estadoActual, List<RecursoTIC> recursos) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sedeId = sedeId;
        this.tipoId = tipoId;
        this.estadoActual = estadoActual;
        this.recursos = recursos != null ? recursos : new ArrayList<>();
    }


    public Aula() {
    }

    /**
     * Constructor alternativo.
     *
     * @param tipoId    Tipo de aula.
     * @param sedeId    Sede del aula.
     * @param capacidad Capacidad máxima.
     * @param nombre    Nombre del aula.
     * @param id        Identificador del aula.
     */
    public Aula(String tipoId, String sedeId, int capacidad, String nombre, String id) {
        this.tipoId = tipoId;
        this.sedeId = sedeId;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.id = id;
        this.recursos = new ArrayList<>();
    }

    // --- Métodos para manejar observadores ---

    /**
     * Añade un observador para este aula.
     *
     * @param observador El observador a agregar.
     */
    public void agregarObservador(ObservadorAula observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    /**
     * Elimina un observador del aula.
     *
     * @param observador Observador a eliminar.
     */
    public void eliminarObservador(ObservadorAula observador) {
        observadores.remove(observador);
    }

    /**
     * Notifica a todos los observadores registrados sobre un cambio en el aula.
     */
    private void notificarObservadores() {
        for (ObservadorAula obs : observadores) {
            obs.actualizar(this);
        }
    }

    // --- Getters y setters personalizados ---

    /**
     * Obtiene el estado actual del aula.
     *
     * @return Estado actual.
     */
    public EstadoAula getEstadoActual() {
        return estadoActual;
    }

    /**
     * Establece el estado actual del aula y notifica a los observadores.
     *
     * @param estadoActual Nuevo estado del aula.
     */
    public void setEstadoActual(EstadoAula estadoActual) {
        this.estadoActual = estadoActual;
        notificarObservadores();
    }

    /**
     * Cambia el estado del aula por uno nuevo y notifica a los observadores.
     *
     * @param nuevoEstado Nuevo estado del aula.
     */
    public void cambiarEstado(EstadoAula nuevoEstado) {
        this.estadoActual = nuevoEstado;
        notificarObservadores();
    }

    /**
     * Agrega una lista de recursos TIC al aula.
     *
     * @param recursos Lista de recursos a agregar.
     */
    public void asignarRecursos(List<RecursoTIC> recursos) {
        this.recursos.addAll(recursos);
    }

    /**
     * Remueve una lista de recursos TIC del aula.
     *
     * @param recursos Lista de recursos a remover.
     */
    public void removerRecursos(List<RecursoTIC> recursos) {
        this.recursos.removeAll(recursos);
    }

    /**
     * Obtiene la lista de recursos TIC del aula.
     *
     * @return Lista de recursos TIC.
     */
    public List<RecursoTIC> getRecursos() {
        return recursos;
    }

    /**
     * Crea una copia del aula (sin observadores).
     *
     * @return Copia del aula.
     */
    @Override
    public Aula clone() {
        try {
            Aula copia = (Aula) super.clone();
            copia.recursos = new ArrayList<>(this.recursos);
            copia.observadores = new ArrayList<>();
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * Establece la lista de recursos TIC del aula.
     *
     * @param recursos Lista de recursos TIC.
     */
    public void setRecursos(List<RecursoTIC> recursos) {
        this.recursos = recursos;
    }

    /**
     * Builder para crear instancias de {@link Aula} de forma flexible y legible.
     */
    public static class AulaBuilder {
        private String id;
        private String nombre;
        private int capacidad;
        private String sedeId;
        private String tipoId;
        private List<RecursoTIC> recursos = new ArrayList<>();

        /**
         * Establece el identificador del aula.
         * @param id Identificador.
         * @return El builder actual.
         */
        public AulaBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Establece el nombre del aula.
         * @param nombre Nombre.
         * @return El builder actual.
         */
        public AulaBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        /**
         * Establece la capacidad del aula.
         * @param capacidad Capacidad máxima.
         * @return El builder actual.
         */
        public AulaBuilder capacidad(int capacidad) {
            this.capacidad = capacidad;
            return this;
        }

        /**
         * Establece el identificador de la sede.
         * @param sedeId Identificador de la sede.
         * @return El builder actual.
         */
        public AulaBuilder sedeId(String sedeId) {
            this.sedeId = sedeId;
            return this;
        }

        /**
         * Establece el tipo de aula.
         * @param tipoId Identificador del tipo.
         * @return El builder actual.
         */
        public AulaBuilder tipoId(String tipoId) {
            this.tipoId = tipoId;
            return this;
        }

        /**
         * Agrega un recurso TIC al aula.
         * @param recurso Recurso TIC a agregar.
         * @return El builder actual.
         */
        public AulaBuilder agregarRecurso(RecursoTIC recurso) {
            this.recursos.add(recurso);
            return this;
        }

        /**
         * Construye una instancia de {@link Aula} con los parámetros proporcionados.
         * @return Nueva instancia de Aula.
         */
        public Aula build() {
            return new Aula(id, nombre, capacidad, sedeId, tipoId, null, recursos);
        }
    }
}



