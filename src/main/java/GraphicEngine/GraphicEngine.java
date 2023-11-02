package GraphicEngine;

import javafx.scene.paint.Color;



import java.util.ArrayList;
public class GraphicEngine {


    private ArrayList<GraphicObject> graphicObjects;

    public ArrayList<GraphicObject> getGraphicObjects() {
        return (ArrayList<GraphicObject>) graphicObjects;
    }

    public void setGraphicObjects(ArrayList<GraphicObject> graphicObjects) {
        this.graphicObjects = graphicObjects;
    }



    private GameFrame frame;

    public GraphicEngine() {
        graphicObjects = new ArrayList<>();
    }

    public GraphicObject createGraphicObject(float width , float height, float x, float y,Color color) {
        GraphicObject graphicObject = new GraphicObject(width , height, x, y ,color);
        graphicObjects.add(graphicObject);
        return graphicObject;

    }



    public void UpdateEngine(){


    }



}
