package GraphicEngine;

import javafx.scene.paint.Color;

import PhysicEngine.PhysicObject;

import java.util.ArrayList;
import java.util.List;
public class GraphicEngine {


    private List<GraphicObject> graphicObjects;

    public GraphicEngine() {
        graphicObjects = new ArrayList<>();
    }

    public void createGraphicObject(float width , float height, float x, float y,Color color) {
        GraphicObject graphicObject = new GraphicObject(width , height, x, y ,color);
        graphicObjects.add(graphicObject);

    }



    public void UpdateGraphicEngine(){


    }



}
