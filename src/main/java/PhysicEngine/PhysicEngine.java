package PhysicEngine;

import java.util.ArrayList;
import java.util.List;

public class PhysicEngine {

    private ArrayList<PhysicObject> physicObjects;
    //Pour faire une boucle pour mise a jrs
    public PhysicEngine() {
        physicObjects = new ArrayList<>();
    }

    public PhysicObject createPhysicObject(float width , float height, float x, float y) {
        PhysicObject physicObject = new PhysicObject(width , height, x, y );
        System.out.println("here");
        physicObjects.add(physicObject);
        System.out.println(physicObjects.size());
        return physicObject;
    }
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

public void updateEngine(){
        for (PhysicObject physicObject : physicObjects) {
            // Mettez à jour la physique de chaque objet en fonction du temps écoulé ( ).
            //on doit ajouter un parametre du temps à la methode update
            physicObject.update( );
            System.out.println(physicObject.getPosition().getX());

            // Vérifiez les collisions avec d'autres objets
//            for (GameObject otherObject : gameObjects) {
//                if (gameObject != otherObject && gameObject.detectCollision(otherObject)) {
//                    //call method to handle the colision
//                    gameObject.detectCollision(otherObject);
//                }
//            }
        }

    }
        // 2nd method to verify colision btw objects
        public void checkcolision () {
        for (int i = 0; i < physicObjects.size(); i++) {
            PhysicObject currentObject = physicObjects.get(i);
            for (int j = i + 1; j < physicObjects.size(); j++) {
                PhysicObject otherObject = physicObjects.get(j);
                if (currentObject.detectCollision(otherObject)) {
                    // Handle collision between currentObject and otherObject
                    currentObject.detectCollision(otherObject);
                }
            }
        }
    }
    }


