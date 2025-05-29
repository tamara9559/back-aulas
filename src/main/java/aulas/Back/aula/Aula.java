package aulas.Back.aula;

import aulas.Back.estado.*;
import aulas.Back.flyweight.ConfiguracionAula;
import aulas.Back.observador.AuditorEventos;
import aulas.Back.observador.ObservadorAula;
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

    @JsonIgnore
    private EstadoAula estadoActual = new EstadoLibre();

    @JsonIgnore
    private final List<ObservadorAula> observadores = new ArrayList<>();

    @Setter @Getter
    private ConfiguracionAula configuracion;


    public Aula() {}

    public Aula(String id, String nombre, int capacidad, String sedeId, TipoAulaEnum tipo, EstadoAulaEnum estado) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sedeId = sedeId;
        this.tipo = tipo;
        this.estado = estado;
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

    public void agregarObservador(ObservadorAula observador) {
        this.observadores.add(observador);
    }

    public void notificarObservadores() {
        for (ObservadorAula observador : observadores) {
            observador.actualizar(this);
        }
    }

    @Override
    public Aula clone() {
        try {
            return (Aula) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

