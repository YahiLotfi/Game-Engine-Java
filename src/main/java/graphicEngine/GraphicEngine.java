package graphicEngine;
import javafx.scene.paint.Color;
import java.util.ArrayList;
public class GraphicEngine {


    private ArrayList<GraphicObject> graphicObjects;
    private ArrayList<GraphicObject> objectsToRemove = new ArrayList<GraphicObject>();

    public ArrayList<GraphicObject> getObjectsToRemove() {
        return objectsToRemove;
    }

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

    public void removeGraphicObject(GraphicObject graphicObject) {
        objectsToRemove.add(graphicObject);
        graphicObjects.remove(graphicObject);
    }

    public void UpdateEngine(){


    }



}
