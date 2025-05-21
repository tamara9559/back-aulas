package aulas.Back;

import aulas.Back.estado.EstadoAula;
import aulas.Back.observador.ObservadorAula;

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

    // Lista de observadores
    private List<ObservadorAula> observadores = new ArrayList<>();

    public Aula(String id, String nombre, int capacidad, String sedeId, String tipoId, EstadoAula estadoActual, List<RecursoTIC> recursos) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sedeId = sedeId;
        this.tipoId = tipoId;
        this.estadoActual = estadoActual;
        this.recursos = recursos != null ? recursos : new ArrayList<>();
    }

    public Aula(String tipoId, String sedeId, int capacidad, String nombre, String id) {
        this.tipoId = tipoId;
        this.sedeId = sedeId;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.id = id;
        this.recursos = new ArrayList<>();
    }

    // --- Métodos para manejar observadores ---

    public void agregarObservador(ObservadorAula observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void eliminarObservador(ObservadorAula observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores() {
        for (ObservadorAula obs : observadores) {
            obs.actualizar(this);
        }
    }

    // --- Getters y setters ---

    public EstadoAula getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoAula estadoActual) {
        this.estadoActual = estadoActual;
        notificarObservadores();
    }

    public void cambiarEstado(EstadoAula nuevoEstado) {
        this.estadoActual = nuevoEstado;
        notificarObservadores();
    }

    public void asignarRecursos(List<RecursoTIC> recursos) {
        this.recursos.addAll(recursos);
    }

    public void removerRecursos(List<RecursoTIC> recursos) {
        this.recursos.removeAll(recursos);
    }

    public List<RecursoTIC> getRecursos() {
        return recursos;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getSedeId() {
        return sedeId;
    }

    public void setSedeId(String sedeId) {
        this.sedeId = sedeId;
        // Opcional: notificarObservadores();
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public void setRecursos(List<RecursoTIC> recursos) {
        this.recursos = recursos;
    }



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
            Aula aula = new Aula(id, nombre, capacidad, sedeId, tipoId, null, recursos);
            return aula;
        }
    }
}



