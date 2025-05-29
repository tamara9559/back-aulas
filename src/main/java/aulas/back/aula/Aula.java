package aulas.back.aula;

import aulas.back.estado.*;
import aulas.back.flyweight.ConfiguracionAula;
import aulas.back.observador.ObservadorAula;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un aula dentro del sistema de gestión de aulas.
 * <p>
 * Esta clase almacena información relevante de un aula, como su identificador, nombre, capacidad,
 * sede, tipo, estado actual y configuración. Además, implementa el patrón Observer para notificar
 * a los observadores sobre cambios de estado, y utiliza el patrón State para manejar los diferentes
 * estados posibles del aula.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     Aula aula = new Aula("1", "Aula 101", 40, "SEDE1", TipoAulaEnum.TEORICA, EstadoAulaEnum.LIBRE);
 *     aula.agregarObservador(new AuditorEventos());
 *     aula.notificarObservadores();
 * </pre>
 *
 * @author Jan
 */
@Document(collection = "aulas")
public class Aula {

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

    /**
     * Constructor vacío para frameworks y serialización.
     */
    public Aula() {}

    /**
     * Constructor completo de Aula. También actúa como constructor de copia.
     *
     * @param id       Identificador único del aula.
     * @param nombre   Nombre del aula.
     * @param capacidad Capacidad máxima del aula.
     * @param sedeId   Identificador de la sede a la que pertenece el aula.
     * @param tipo     Tipo de aula (teórica, laboratorio, híbrida, etc.).
     * @param estado   Estado inicial del aula.
     */
    public Aula(String id, String nombre, int capacidad, String sedeId, TipoAulaEnum tipo, EstadoAulaEnum estado) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sedeId = sedeId;
        this.tipo = tipo;
        this.estado = estado;
    }

    /**
     * Constructor de copia para la clase Aula.
     *
     * @param original Aula desde la cual se copiarán los valores.
     */
    public Aula(Aula original) {
        this.id = original.id;
        this.nombre = original.nombre;
        this.capacidad = original.capacidad;
        this.sedeId = original.sedeId;
        this.tipo = original.tipo;
        this.estado = original.estado;
    }

    /**
     * Obtiene la instancia de estado correspondiente al estado actual.
     *
     * @return Instancia de {@link EstadoAula} que representa el estado actual.
     */
    public EstadoAula getEstadoActual() {
        return switch (estado) {
            case LIBRE -> new EstadoLibre();
            case RESERVADA -> new EstadoReservada();
            case EN_MANTENIMIENTO -> new EstadoMantenimiento();
            case INHABILITADA -> new EstadoInhabilitada();
        };
    }
    /**
     * Obtiene la descripción textual del estado actual del aula.
     *
     * @return Descripción del estado.
     */
    public String getDescripcionEstado() {
        return getEstadoActual().descripcion();
    }

    /**
     * Agrega un observador al aula.
     *
     * @param observador Observador que será notificado de los cambios de estado.
     */
    public void agregarObservador(ObservadorAula observador) {
        this.observadores.add(observador);
    }

    /**
     * Notifica a todos los observadores registrados sobre un cambio de estado.
     */
    public void notificarObservadores() {
        for (ObservadorAula observador : observadores) {
            observador.actualizar(this);
        }
    }

    /**
     * Crea una copia del aula utilizando un constructor de copia.
     *
     * @return Nueva instancia de {@code Aula} con los mismos valores.
     */
    public Aula copia() {
        return new Aula(this);
    }
}

