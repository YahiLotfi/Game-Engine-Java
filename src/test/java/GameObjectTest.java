import PhysicEngine.GameObject;
import PhysicEngine.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameObjectTest {

    @Test
    public void testUpdate() {
        System.out.println("Testing update...");

        GameObject gameObject = new GameObject(12, 7,0,0);
        System.out.println("Object created with these dimensions : " + gameObject );

        gameObject.setVelocity(2, 3);

        gameObject.setAcceleration(1, 1);
        gameObject.update();
        Vector2 velocity = gameObject.getVelocity();
        Vector2 position = gameObject.getPosition();


        assertEquals(3.0f, velocity.getX());
        assertEquals(4.0f, velocity.getY());
        assertEquals(3.0f, position.getX());
        assertEquals(4.0f, position.getY());

        System.out.println("update test complete.");
    }
}
