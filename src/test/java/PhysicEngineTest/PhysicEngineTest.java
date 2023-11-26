package PhysicEngineTest;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import physicEngine.PhysicEngine;
import physicEngine.PhysicObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhysicEngineTest {

    @Test
    public void testCheckCollision() {
        PhysicEngine engine = new PhysicEngine();
        PhysicObject obj1 = engine.createPhysicObject(10, 10, 0, 0);
        PhysicObject obj2 = engine.createPhysicObject(10, 10, 5, 5);
        assertTrue(PhysicEngine.checkCollision(obj1, obj2));
    }
}