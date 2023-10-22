package PhysicEngine;

import java.util.ArrayList;
import java.util.List;

public class PhysicEngine {

    private List<PhysicObject> physicObjects;
    //Pour faire une boucle pour mise a jrs
    private boolean gameIsRunning = false;
    public PhysicEngine() {
        physicObjects = new ArrayList<>();
    }

    public void createGameObject(float width , float height, float x, float y) {
        PhysicObject physicObject = new PhysicObject(width , height, x, y );
        physicObjects.add(physicObject);
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

//while(!gameIsRunning){
// updatePosition
// CheckColision
//Handle Colision }
public void UpdateEngine(float deltaTime){
        for (PhysicObject physicObject : physicObjects) {
            // Mettez à jour la physique de chaque objet en fonction du temps écoulé (deltaTime).
            //on doit ajouter un parametre du temps à la methode update
            physicObject.update(deltaTime);

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


