package physicEngineTest;

import static org.junit.jupiter.api.Assertions.*;
import physicEngine.Vector2;
import org.junit.jupiter.api.Test;

class Vector2Test {

    @Test
    void testConstructorAndGetters() {
        Vector2 vector = new Vector2(1.0f, 2.0f);

        assertEquals(1.0f, vector.getX(), 0.0001);
        assertEquals(2.0f, vector.getY(), 0.0001);
    }

    @Test
    void testSetters() {
        Vector2 vector = new Vector2(1.0f, 2.0f);

        vector.setX(3.0f);
        vector.setY(4.0f);

        assertEquals(3.0f, vector.getX(), 0.0001);
        assertEquals(4.0f, vector.getY(), 0.0001);
    }

    @Test
    void testSetMethod() {
        Vector2 vector = new Vector2(1.0f, 2.0f);

        vector.set(5.0f, 6.0f);

        assertEquals(5.0f, vector.getX(), 0.0001);
        assertEquals(6.0f, vector.getY(), 0.0001);
    }

}
