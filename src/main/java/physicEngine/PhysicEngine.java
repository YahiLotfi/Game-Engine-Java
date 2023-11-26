package physicEngine;

import java.util.ArrayList;
import java.util.Collection;

public class PhysicEngine {


    private ArrayList<PhysicObject> physicObjects;
    public PhysicEngine() {physicObjects = new ArrayList<>();}
    /* createPhysicObject crée un nouveau PhysicObject avec les dimensions spécifiées (largeur et hauteur) et
    la position (x et y) dans le monde du jeu. */

    public PhysicObject createPhysicObject(float width , float height, float x, float y) {
        PhysicObject physicObject = new PhysicObject(width , height, x, y );
        System.out.println("here");
        physicObjects.add(physicObject);
        System.out.println(physicObjects.size());
        return physicObject;
    }

    public static boolean intersectSelf(float x1, float  x2, float y1, float   y2){
        return (y1<x1 && x1<y2)||(y1<x2 && x2<y2 );}

    public static boolean checkCollisionSelf(PhysicObject object1, PhysicObject object2) {
      return (intersectSelf(object1.getPosition().getX(), object1.getRight(), object2.getPosition().getX(), object2.getRight())&&
                intersectSelf(object1.getPosition().getY(), object1.getBottom(), object2.getPosition().getY(), object2.getBottom())
        );



    }
    public static boolean intersects(float x1, float  x2, float y1, float   y2){

        return (y1<=x1 && x1<=y2)||(y1<=x2 && x2<=y2 );
    }
    public static boolean checkCollision(PhysicObject object1, PhysicObject object2) {
        return (intersects(object1.getPosition().getX(), object1.getRight(), object2.getPosition().getX(), object2.getRight())&&
                intersects(object1.getPosition().getY(), object1.getBottom(), object2.getPosition().getY(), object2.getBottom())
                );

    }

    public void removePhysicObject(PhysicObject physicObject) {
        physicObjects.remove(physicObject);
    }

    public void updateEngine(){
        for (PhysicObject physicObject : physicObjects) {
            physicObject.update( );
        }

    }

    public ArrayList<PhysicObject> getPhysicObjects() {
        return physicObjects;
    }

}


