package aulas.Back;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un aula dentro del sistema.
 * Permite gestionar recursos TIC y estado del aula.
 *
 * @author Jan
 */
@Document(collection = "aulas")
public class Aula implements Cloneable {
    /** Identificador único del aula. */
    @Setter @Getter @Id
    private String id;

    /** Nombre descriptivo del aula. */
    @Setter @Getter
    private String nombre;

    /** Capacidad máxima de personas para el aula. */
    @Setter @Getter
    private int capacidad;

    /** Identificador de la sede a la que pertenece el aula. */
    @Setter @Getter
    private String sedeId;

    /** Identificador del tipo de aula. */
    @Setter @Getter
    private String tipoId;

    /** Lista de recursos TIC asociados al aula. */
    private List<RecursoTIC> recursos = new ArrayList<>();

    public Aula(String id, String nombre, int capacidad, String sedeId, String tipoId, List<RecursoTIC> recursos) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sedeId = sedeId;
        this.tipoId = tipoId;
        this.recursos = recursos != null ? recursos : new ArrayList<>();
    }

    public Aula() {}

    public Aula(String tipoId, String sedeId, int capacidad, String nombre, String id) {
        this.tipoId = tipoId;
        this.sedeId = sedeId;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.id = id;
        this.recursos = new ArrayList<>();
    }

    public List<RecursoTIC> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<RecursoTIC> recursos) {
        this.recursos = recursos;
    }

    /**
     * Agrega una lista de recursos TIC al aula.
     * @param recursos Lista de recursos a agregar.
     */
    public void asignarRecursos(List<RecursoTIC> recursos) {
        this.recursos.addAll(recursos);
    }

    /**
     * Remueve una lista de recursos TIC del aula.
     * @param recursos Lista de recursos a remover.
     */
    public void removerRecursos(List<RecursoTIC> recursos) {
        this.recursos.removeAll(recursos);
    }

    /**
     * Crea una copia del aula (sin recursos compartidos).
     * @return Copia del aula.
     */
    @Override
    public Aula clone() {
        try {
            Aula copia = (Aula) super.clone();
            copia.recursos = new ArrayList<>(this.recursos);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * Builder para crear instancias de {@link Aula} de forma flexible.
     */
    public static class AulaBuilder {
        private String id;
        private String nombre;
        private int capacidad;
        private String sedeId;
        private String tipoId;
        private List<RecursoTIC> recursos = new ArrayList<>();

        public AulaBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AulaBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public AulaBuilder capacidad(int capacidad) {
            this.capacidad = capacidad;
            return this;
        }

        public AulaBuilder sedeId(String sedeId) {
            this.sedeId = sedeId;
            return this;
        }

        public AulaBuilder tipoId(String tipoId) {
            this.tipoId = tipoId;
            return this;
        }

        public AulaBuilder agregarRecurso(RecursoTIC recurso) {
            this.recursos.add(recurso);
            return this;
        }

        public Aula build() {
            return new Aula(id, nombre, capacidad, sedeId, tipoId, recursos);
        }
    }
}