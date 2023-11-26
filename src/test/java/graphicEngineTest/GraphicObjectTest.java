package graphicEngineTest;

import graphicEngine.GraphicObject;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraphicObjectTest {

    @Test
    void testGraphicObjectCreation() {
        GraphicObject graphicObject = new GraphicObject(20.0f, 30.0f, 5.0f, 8.0f, Color.BLUE);

        assertEquals(20.0f, graphicObject.getWidth());
        assertEquals(30.0f, graphicObject.getHeight());
        assertEquals(5.0f, graphicObject.getPosition().getX());
        assertEquals(8.0f, graphicObject.getPosition().getY());
        assertEquals(Color.BLUE, graphicObject.getColor());
        assertNotNull(graphicObject.getRectangle());

        assertNull(graphicObject.getTexture());
        assertNull(graphicObject.getImageView());
    }

    @Test
    void testGraphicObjectUpdatePosition() {
        GraphicObject graphicObject = new GraphicObject(20.0f, 30.0f, 5.0f, 8.0f, Color.BLUE);

        graphicObject.updatePosition(10.0f, 15.0f);

        assertEquals(10.0f, graphicObject.getPosition().getX());
        assertEquals(15.0f, graphicObject.getPosition().getY());

        assertEquals(10.0f - graphicObject.getCenterX(), graphicObject.getRectangle().getLayoutX());
        assertEquals(15.0f - graphicObject.getCenterY(), graphicObject.getRectangle().getLayoutY());
    }

    /*
    @Test
    void testGraphicObjectCreateImageView() {
        GraphicObject graphicObject = new GraphicObject(20.0f, 30.0f, 5.0f, 8.0f, Color.BLUE);
        graphicObject.setTexture("/src/main/resources/sample/Snake Sprites/right left.png");

        ImageView imageView = graphicObject.createImageView();

        assertNotNull(imageView);
        assertEquals("/src/main/resources/sample/Snake Sprites/right left.png", graphicObject.getTexture());
        assertNull(graphicObject.getRectangle().getFill()); // Color should be null if using a texture
    }

    @Test
    void testGraphicObjectUpdateTexture() {
        GraphicObject graphicObject = new GraphicObject(20.0f, 30.0f, 5.0f, 8.0f, Color.BLUE);
        graphicObject.setTexture("src/main/resources/sample/image.png");

        graphicObject.updateTexture("src/main/resources/sample/Snake Sprites/right left.png");

        assertEquals("src/main/resources/sample/Snake Sprites/right left.png", graphicObject.getTexture());
    }

    @Test
    void testGraphicObjectRescaleImageView() {
        GraphicObject graphicObject = new GraphicObject(20.0f, 30.0f, 5.0f, 8.0f, Color.BLUE);
        graphicObject.setTexture("src/main/resources/sample/Snake Sprites/right left.png");
        graphicObject.createImageView();

        graphicObject.rescaleImageView(50.0f, 60.0f);

        assertEquals(50.0f, graphicObject.getImageView().getFitWidth());
        assertEquals(60.0f, graphicObject.getImageView().getFitHeight());
        assertFalse(graphicObject.getImageView().isPreserveRatio());
    }

     */
}
