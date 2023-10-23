package GraphicEngine;

import javafx.scene.paint.Color;

import PhysicEngine.PhysicObject;


import java.util.ArrayList;
public class GraphicEngine {


    private ArrayList<GraphicObject> graphicObjects;

    public ArrayList<GraphicObject> getGraphicObjects() {
        return (ArrayList<GraphicObject>) graphicObjects;
    }

    public void setGraphicObjects(ArrayList<GraphicObject> graphicObjects) {
        this.graphicObjects = graphicObjects;
    }

    public GameFrame getFrame() {
        return frame;
    }

    public void setFrame(GameFrame frame) {
        this.frame = frame;
    }

    private GameFrame frame;

    public GraphicEngine() {
        graphicObjects = new ArrayList<>();
        frame = new GameFrame();
    }

    public GraphicObject createGraphicObject(float width , float height, float x, float y,Color color) {
        GraphicObject graphicObject = new GraphicObject(width , height, x, y ,color);
        graphicObjects.add(graphicObject);
        frame.addObjToRoot(graphicObject);

        return graphicObject;

    }



    public void UpdateEngine(){


    }



}
