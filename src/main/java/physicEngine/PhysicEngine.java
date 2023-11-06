package physicEngine;

import java.util.ArrayList;

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
    /*
    public void removeGameObject1(float width, float height, float x, float y)
    {
        // Iterate through the list of game objects
        for (PhysicObject physicObject : physicObjects) {
            if (physicObject.getWidth() == width &&
                    physicObject.getHeight() == height &&
                    physicObject.getPosition().getX() == x &&
                    physicObject.getPosition().getY() == y) {// vierfier les paraemtres des objets à supprimer
                physicObjects.remove(physicObject);// how to delete the object completely !!!! can we use destroy !!!
                break;
            }
        }
    }

     */
    /* updateEngine mettre à jour la physique de tous les objets du
    jeu stockés dans la liste physicObjects*/
    public void updateEngine(){
        for (PhysicObject physicObject : physicObjects) {
            physicObject.update( );
            System.out.println(physicObject.getPosition().getX());

        }

    }

}


