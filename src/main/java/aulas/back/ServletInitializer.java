package aulas.back;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Inicializador de servlet para aplicaciones Spring Boot desplegadas en un contenedor servlet tradicional.
 * <p>
 * Permite configurar la aplicación cuando se despliega como un archivo WAR en servidores como Tomcat,
 * especificando la clase principal de arranque.
 * </p>
 *
 * @author Jan
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Configura la aplicación Spring Boot cuando se despliega como WAR.
	 *
	 * @param application El builder de la aplicación.
	 * @return El builder configurado con la clase principal.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BackApplication.class);
	}
}
