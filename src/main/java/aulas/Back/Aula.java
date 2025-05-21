package aulas.Back;

import aulas.Back.estado.EstadoAula;
import java.util.ArrayList;
import java.util.List;

public class Aula implements Cloneable {
    private String id;
    private String nombre;
    private int capacidad;
    private String sedeId;
    private String tipoId;
    private EstadoAula estadoActual;
    private List<RecursoTIC> recursos;

    public Aula(String id, String nombre, int capacidad, String sedeId, String tipoId, EstadoAula estadoActual, List<RecursoTIC> recursos) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sedeId = sedeId;
        this.tipoId = tipoId;
        this.estadoActual = estadoActual;
        this.recursos = recursos != null ? recursos : new ArrayList<>();
    }

    // Constructor básico sin estado y recursos, se puede usar factory para crear con estado y recursos por defecto
    public Aula(String id, String nombre, int capacidad, String sedeId, String tipoId) {
        this(id, nombre, capacidad, sedeId, tipoId, null, new ArrayList<>());
    }

    public void setRecursos(List<RecursoTIC> recursos) {
        this.recursos = recursos;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getSedeId() {
        return sedeId;
    }

    public void setSedeId(String sedeId) {
        this.sedeId = sedeId;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EstadoAula getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoAula estadoActual) {
        this.estadoActual = estadoActual;
    }

    public List<RecursoTIC> getRecursos() {
        return recursos;
    }

    public void asignarRecursos(List<RecursoTIC> recursos) {
        this.recursos.addAll(recursos);
    }

    public void cambiarEstado(EstadoAula nuevoEstado) {
        this.estadoActual = nuevoEstado;
        // Aquí se podría notificar observadores, si hay implementados
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

    // Builder para facilitar creación flexible
    public static class AulaBuilder {
        private String id;
        private String nombre;
        private int capacidad;
        private String sedeId;
        private String tipoId;
        private List<RecursoTIC> recursos = new ArrayList<>();
        private EstadoAula estadoActual;

        public AulaBuilder id(String id) { this.id = id; return this; }
        public AulaBuilder nombre(String nombre) { this.nombre = nombre; return this; }
        public AulaBuilder capacidad(int capacidad) { this.capacidad = capacidad; return this; }
        public AulaBuilder sedeId(String sedeId) { this.sedeId = sedeId; return this; }
        public AulaBuilder tipoId(String tipoId) { this.tipoId = tipoId; return this; }
        public AulaBuilder estadoActual(EstadoAula estadoActual) { this.estadoActual = estadoActual; return this; }
        public AulaBuilder agregarRecurso(RecursoTIC recurso) { this.recursos.add(recurso); return this; }

        public Aula build() {
            Aula aula = new Aula(id, nombre, capacidad, sedeId, tipoId, estadoActual, recursos);
            return aula;
        }
    }
}


