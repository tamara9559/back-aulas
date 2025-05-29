package aulas.back;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal para el arranque de la aplicación Spring Boot.
 * <p>
 * Esta clase contiene el método {@code main} que inicia la aplicación y realiza la configuración automática de Spring Boot.
 * </p>
 *
 * Ejecútala para lanzar el backend del sistema de gestión de aulas.
 *
 * @author Jan
 */
@SpringBootApplication
public class BackApplication {


	private static final Logger LOGGER = LoggerFactory.getLogger(BackApplication.class);

	/**
	 * Método principal. Inicia la aplicación Spring Boot.
	 *
	 * @param args Argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			LOGGER.info("Programa detenido");
			LOGGER.info("bip bi...");
		}));

		SpringApplication.run(BackApplication.class, args);
		LOGGER.info("Programa iniciando");
		LOGGER.info("bip bip");
	}
}

