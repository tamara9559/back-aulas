package aulas.Back;

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

	/**
	 * Método principal. Inicia la aplicación Spring Boot.
	 *
	 * @param args Argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
		System.out.println("hola");
	}
}
