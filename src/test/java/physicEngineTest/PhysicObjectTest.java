package physicEngineTest;

import org.junit.jupiter.api.Test;
import physicEngine.PhysicObject;
import physicEngine.Bounds;
import physicEngine.Vector2;

import static org.junit.jupiter.api.Assertions.*;

public class PhysicObjectTest {

        @Test
        void testConstructorAndGetter() {
            PhysicObject physicObject = new PhysicObject(10.0f, 20.0f, 5.0f, 8.0f);

            assertEquals(10.0f, physicObject.getWidth(), 0.0001);
            assertEquals(20.0f, physicObject.getHeight(), 0.0001);
            assertEquals(5.0f, physicObject.getPosition().getX(), 0.0001);
            assertEquals(8.0f, physicObject.getPosition().getY(), 0.0001);
            assertEquals(0.00001f, physicObject.getVelocity().getX(), 0.0001);
            assertEquals(0.0f, physicObject.getVelocity().getY(), 0.0001);
            assertEquals(0.0f, physicObject.getAcceleration().getX(), 0.0001);
            assertEquals(0.0f, physicObject.getAcceleration().getY(), 0.0001);
        }

        @Test
        void testSetters() {
            PhysicObject physicObject = new PhysicObject(10.0f, 20.0f, 5.0f, 8.0f);

            physicObject.setWidth(15.0f);
            physicObject.setHeight(25.0f);
            physicObject.setPosition(8.0f, 12.0f);
            physicObject.setVelocity(2.0f, 3.0f);
            physicObject.setAcceleration(1.0f, 2.0f);

            assertEquals(15.0f, physicObject.getWidth(), 0.0001);
            assertEquals(25.0f, physicObject.getHeight(), 0.0001);
            assertEquals(8.0f, physicObject.getPosition().getX(), 0.0001);
            assertEquals(12.0f, physicObject.getPosition().getY(), 0.0001);
            assertEquals(2.0f, physicObject.getVelocity().getX(), 0.0001);
            assertEquals(3.0f, physicObject.getVelocity().getY(), 0.0001);
            assertEquals(1.0f, physicObject.getAcceleration().getX(), 0.0001);
            assertEquals(2.0f, physicObject.getAcceleration().getY(), 0.0001);
        }

        @Test
        void testUpdate() {
            PhysicObject physicObject = new PhysicObject(10.0f, 20.0f, 5.0f, 8.0f);

            physicObject.setVelocity(2.0f, 3.0f);
            physicObject.setAcceleration(1.0f, 2.0f);

            physicObject.update();

            assertEquals(3.0f, physicObject.getVelocity().getX(), 0.0001);
            assertEquals(5.0f, physicObject.getVelocity().getY(), 0.0001);
            assertEquals(8.0f, physicObject.getPosition().getX(), 0.0001);
            assertEquals(13.0f, physicObject.getPosition().getY(), 0.0001);
        }


    @Test
        void testGetBounds() {
            PhysicObject physicObject = new PhysicObject(10.0f, 20.0f, 5.0f, 8.0f);

            Bounds bounds = physicObject.getBounds();

            assertEquals(10.0f, bounds.getWidth(), 0.0001);
            assertEquals(20.0f, bounds.getHeight(), 0.0001);
            assertEquals(5.0f, bounds.getMiddleLeftX(), 0.0001);
            assertEquals(8.0f, bounds.getMiddleTopY(), 0.0001);
        }
    }


