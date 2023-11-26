package physicEngineTest;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import physicEngine.PhysicEngine;
import physicEngine.PhysicObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhysicEngineTest {

    @Test
    void testCreatePhysicObject() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicObject physicObject = physicEngine.createPhysicObject(10.0f, 20.0f, 5.0f, 8.0f);

        assertEquals(1, physicEngine.getPhysicObjects().size());
        assertTrue(physicEngine.getPhysicObjects().contains(physicObject));
    }

    @Test
    void testCheckCollision() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicObject object1 = physicEngine.createPhysicObject(10.0f, 20.0f, 5.0f, 8.0f);
        PhysicObject object2 = physicEngine.createPhysicObject(15.0f, 25.0f, 8.0f, 12.0f);

        assertTrue(PhysicEngine.checkCollision(object1, object2));
    }

    @Test
    public void testCheckCollision2() {
        PhysicEngine engine = new PhysicEngine();
        PhysicObject obj1 = engine.createPhysicObject(10, 10, 0, 0);
        PhysicObject obj2 = engine.createPhysicObject(10, 10, 5, 5);
        assertTrue(PhysicEngine.checkCollision(obj1, obj2));
    }
    @Test
    void testCheckCollisionSerpent() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicObject object1 = physicEngine.createPhysicObject(10.0f, 20.0f, 5.0f, 8.0f);
        PhysicObject object2 = physicEngine.createPhysicObject(15.0f, 25.0f, 8.0f, 12.0f);

        assertTrue(PhysicEngine.checkCollisionSelf(object1, object2));
    }

    @Test
    void testIntersects() {
        assertTrue(PhysicEngine.intersects(5.0f, 10.0f, 8.0f, 12.0f));
        assertFalse(PhysicEngine.intersects(5.0f, 10.0f, 15.0f, 20.0f));
    }

    @Test
    void testIntersectSerpent() {
        assertTrue(PhysicEngine.intersectSelf(5.0f, 10.0f, 8.0f, 12.0f));
        assertFalse(PhysicEngine.intersectSelf(5.0f, 10.0f, 15.0f, 20.0f));
    }

    @Test
    void test_UpdateEngine() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicObject object1 = physicEngine.createPhysicObject(10.0f, 20.0f, 5.0f, 8.0f);
        PhysicObject object2 = physicEngine.createPhysicObject(15.0f, 25.0f, 8.0f, 12.0f);


        assertEquals(0.0f, object1.getVelocity().getX(), 0.0001);
        assertEquals(0.0f, object1.getVelocity().getY(), 0.0001);
        assertEquals(5.0f, object1.getPosition().getX(), 0.0001);
        assertEquals(8.0f, object1.getPosition().getY(), 0.0001);

        assertEquals(8.0f, object2.getPosition().getX(), 0.0001);
        assertEquals(12.0f, object2.getPosition().getY(), 0.0001);
        assertEquals(0.0f, object2.getVelocity().getX(), 0.0001);
        assertEquals(0.0f, object2.getVelocity().getY(), 0.0001);
    }
}


/*

 */
