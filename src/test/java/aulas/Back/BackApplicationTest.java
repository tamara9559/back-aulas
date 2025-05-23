package aulas.Back;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BackApplicationTest {
    @Test
    void testMain() {
        // Solo probamos que no lance excepciones al ejecutarse
        assertDoesNotThrow(() -> BackApplication.main(new String[]{}));
    }
}
