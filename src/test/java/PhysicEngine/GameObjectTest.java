package PhysicEngine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameObjectTest {

    @Test
    public void testUpdate() {
        GameObject gameObject = new GameObject(0, 0);
        gameObject.setVelocity(2, 3);
        gameObject.setAcceleration(1, 1);
        gameObject.update();
        Vector2 velocity = gameObject.getVelocity();
        Vector2 position = gameObject.getPosition();
        assertEquals(3.0f, velocity.getX());
        assertEquals(4.0f, velocity.getY());
        assertEquals(3.0f, position.getX());
        assertEquals(4.0f, position.getY());
    }
}

