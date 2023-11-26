package physicEngineTest;

import physicEngine.Bounds;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoundsTest {

    @Test
    void testGetters() {
        Bounds bounds = new Bounds(10.0f, 20.0f, 5.0f, 8.0f);

        assertEquals(10.0f, bounds.getMiddleTopX(), 0.0001);
        assertEquals(8.0f, bounds.getMiddleTopY(), 0.0001);

        assertEquals(5.0f, bounds.getMiddleLeftX(), 0.0001);
        assertEquals(18.0f, bounds.getMiddleLeftY(), 0.0001);

        assertEquals(15.0f, bounds.getMiddleRightX(), 0.0001);
        assertEquals(18.0f, bounds.getMiddleRightY(), 0.0001);

        assertEquals(10.0f, bounds.getMiddleDownX(), 0.0001);
        assertEquals(28.0f, bounds.getMiddleDownY(), 0.0001);
    }

    @Test
    void testUpdateBounds() {
        Bounds bounds = new Bounds(10.0f, 20.0f, 5.0f, 8.0f);

        bounds.updateBounds(15.0f, 25.0f, 8.0f, 12.0f);

        assertEquals(15.5f, bounds.getMiddleTopX(), 0.0001);
        assertEquals(12.0f, bounds.getMiddleTopY(), 0.0001);

        assertEquals(8.0f, bounds.getMiddleLeftX(), 0.0001);
        assertEquals(24.5f, bounds.getMiddleLeftY(), 0.0001);

        assertEquals(23.0f, bounds.getMiddleRightX(), 0.0001);
        assertEquals(24.5f, bounds.getMiddleRightY(), 0.0001);

        assertEquals(15.5f, bounds.getMiddleDownX(), 0.0001);
        assertEquals(37.0f, bounds.getMiddleDownY(), 0.0001);
    }



}
