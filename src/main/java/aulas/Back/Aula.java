package aulas.Back;

import java.util.*;


public class Aula implements Cloneable {
    private String id;
    private String nombre;
    private int capacidad;
    private String sedeId;
    private String tipoId;
    private List<RecursoTIC> recursos;

    public Aula(String id, String nombre, int capacidad, String sedeId, String tipoId) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sedeId = sedeId;
        this.tipoId = tipoId;
        this.recursos = new ArrayList<>();
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
            Aula aula = new Aula(id, nombre, capacidad, sedeId, tipoId);
            aula.asignarRecursos(recursos);
            return aula;
        }
    }
}

