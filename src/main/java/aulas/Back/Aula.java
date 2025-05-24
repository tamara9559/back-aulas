package aulas.Back;

import aulas.Back.estado.EstadoAula;
import aulas.Back.estado.EstadoLibre;
import aulas.Back.observador.NotificadorUsuarios;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "aulas")
public class Aula implements Cloneable {
    @Setter @Getter @Id
    private String id;

    @Setter @Getter
    private String nombre;

    @Setter @Getter
    private int capacidad;

    @Setter @Getter
    private String sedeId;

    @Setter @Getter
    private String tipoId;

    private List<RecursoTIC> recursos = new ArrayList<>();

    // ✅ Estado actual del aula (patrón State)
    private EstadoAula estadoActual = new EstadoLibre(); // Por defecto libre

    public Aula() {}

    public Aula(String id, String nombre, int capacidad, String sedeId, String tipoId, List<RecursoTIC> recursos) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sedeId = sedeId;
        this.tipoId = tipoId;
        this.recursos = recursos != null ? recursos : new ArrayList<>();
        this.estadoActual = new EstadoLibre();
    }

    public Aula(String tipoId, String sedeId, int capacidad, String nombre, String id) {
        this.tipoId = tipoId;
        this.sedeId = sedeId;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.id = id;
        this.recursos = new ArrayList<>();
        this.estadoActual = new EstadoLibre();
    }

    public List<RecursoTIC> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<RecursoTIC> recursos) {
        this.recursos = recursos;
    }

    public void asignarRecursos(List<RecursoTIC> recursos) {
        this.recursos.addAll(recursos);
    }

    public void removerRecursos(List<RecursoTIC> recursos) {
        this.recursos.removeAll(recursos);
    }

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

    //  Estado actual (getter y setter)
    public EstadoAula getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoAula nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    //  Para mostrar el estado en texto al serializar (ej. en MongoDB)
    public String getEstado() {
        return estadoActual != null ? estadoActual.descripcion() : "desconocido";
    }

    public void agregarObservador(NotificadorUsuarios notificadorUsuarios) {
        // aún por implementar si vas a usar Observer real
    }

    //  Builder
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
