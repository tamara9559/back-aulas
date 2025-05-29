package aulas.Back.builder;

import aulas.Back.aula.Aula;
import aulas.Back.aula.TipoAulaEnum;
import aulas.Back.estado.EstadoAulaEnum;
import aulas.Back.flyweight.ConfiguracionAula;
import aulas.Back.observador.AuditorEventos;

public class AulaBuilder {
    private String id;
    private String nombre;
    private int capacidad;
    private String sedeId;
    private TipoAulaEnum tipo;
    private EstadoAulaEnum estado = EstadoAulaEnum.LIBRE;
    private ConfiguracionAula configuracion;

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

    public AulaBuilder configuracion(ConfiguracionAula config) {
        this.configuracion = config;
        return this;
    }

    public Aula build() {
        Aula aula = new Aula(id, nombre, capacidad, sedeId, tipo, estado);
        aula.setConfiguracion(configuracion);
        aula.agregarObservador(new AuditorEventos());
        return aula;
    }
}

