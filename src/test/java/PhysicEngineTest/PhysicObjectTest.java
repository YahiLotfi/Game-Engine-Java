package PhysicEngineTest;

import org.junit.jupiter.api.Test;
import physicEngine.PhysicObject;
import physicEngine.Vector2;

import static org.junit.jupiter.api.Assertions.*;

public class PhysicObjectTest {

    @Test
    public void testUpdate() {
        PhysicObject obj = new PhysicObject(10, 10, 0, 0);
        obj.setAcceleration(2, 3);
        obj.setVelocity(1, 1);
        obj.update();
        assertEquals(new Vector2(3, 4), obj.getVelocity());
        assertEquals(new Vector2(3, 4), obj.getPosition());
    }


}