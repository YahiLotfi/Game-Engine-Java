package CoreKernal;

import GraphicEngine.GraphicObject;
import PhysicEngine.PhysicObject;

public class GameObject {
    private PhysicObject physicObject;
    private GraphicObject graphicObject;
    public GameObject()
    {physicObject = null;
        graphicObject = null;}

    public void updateGameObject(){
        graphicObject.updatePosition(physicObject.getPosition().getX(),physicObject.getPosition().getY());
    }
    public PhysicObject getPhysicObject() {
        return physicObject;
    }
    public void setPhysicObject(PhysicObject physicObject) {
        this.physicObject = physicObject;
    }
    public GraphicObject getGraphicObject() {
        return graphicObject;
    }
    public void setGraphicObject(GraphicObject graphicObject) {
        this.graphicObject = graphicObject;
    }
}
