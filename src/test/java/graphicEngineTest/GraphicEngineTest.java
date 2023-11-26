package graphicEngineTest;

import graphicEngine.GraphicEngine;
import graphicEngine.GraphicObject;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphicEngineTest {

    @Test
    void testCreateGraphicObject() {
        GraphicEngine graphicEngine = new GraphicEngine();

        GraphicObject graphicObject = graphicEngine.createGraphicObject(20.0f, 30.0f, 5.0f, 8.0f, Color.BLUE);

        assertNotNull(graphicObject);
        assertEquals(1, graphicEngine.getGraphicObjects().size());
        assertTrue(graphicEngine.getGraphicObjects().contains(graphicObject));
    }


}
