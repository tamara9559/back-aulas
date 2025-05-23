package aulas.Back;

import aulas.Back.estado.*;
import aulas.Back.observador.NotificadorUsuarios;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private TipoAulaEnum tipo;

    @Setter @Getter
    private EstadoAulaEnum estado = EstadoAulaEnum.LIBRE;

    private List<RecursoTIC> recursos = new ArrayList<>();

    // ⛔ Ocultar este campo en la serialización
    @JsonIgnore
    private EstadoAula estadoActual = new EstadoLibre();

    public Aula() {}

    public Aula(String id, String nombre, int capacidad, String sedeId, TipoAulaEnum tipo, EstadoAulaEnum estado, List<RecursoTIC> recursos) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sedeId = sedeId;
        this.tipo = tipo;
        this.estado = estado;
        this.recursos = recursos != null ? recursos : new ArrayList<>();
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

    public EstadoAula getEstadoActual() {
        return switch (estado) {
            case LIBRE -> new EstadoLibre();
            case RESERVADA -> new EstadoReservada();
            case EN_MANTENIMIENTO -> new EstadoMantenimiento();
            case INHABILITADA -> new EstadoInhabilitada();
        };
    }

    public String getDescripcionEstado() {
        return getEstadoActual().descripcion();
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

    public void agregarObservador(NotificadorUsuarios notificadorUsuarios) {
        // implementación futura del patrón Observer
    }

    public static class AulaBuilder {
        private String id;
        private String nombre;
        private int capacidad;
        private String sedeId;
        private TipoAulaEnum tipo;
        private EstadoAulaEnum estado = EstadoAulaEnum.LIBRE;
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

        public AulaBuilder tipo(TipoAulaEnum tipo) {
            this.tipo = tipo;
            return this;
        }

        public AulaBuilder estado(EstadoAulaEnum estado) {
            this.estado = estado;
            return this;
        }

        public AulaBuilder agregarRecurso(RecursoTIC recurso) {
            this.recursos.add(recurso);
            return this;
        }

        public Aula build() {
            return new Aula(id, nombre, capacidad, sedeId, tipo, estado, recursos);
        }
    }
}
