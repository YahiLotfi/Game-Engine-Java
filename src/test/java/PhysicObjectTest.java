import PhysicEngine.PhysicObject;
import PhysicEngine.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhysicObjectTest {

    @Test
    public void testUpdate() {
        System.out.println("Testing update...");

        PhysicObject physicObject = new PhysicObject(12, 7,0,0);
        System.out.println("Object created with these dimensions : " + physicObject);

        physicObject.setVelocity(2, 3);

        physicObject.setAcceleration(1, 1);
        physicObject.update();
        Vector2 velocity = physicObject.getVelocity();
        Vector2 position = physicObject.getPosition();


        assertEquals(3.0f, velocity.getX());
        assertEquals(4.0f, velocity.getY());
        assertEquals(3.0f, position.getX());
        assertEquals(4.0f, position.getY());

        System.out.println("update test complete.");
    }
}
