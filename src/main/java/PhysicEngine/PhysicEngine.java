package PhysicEngine;

import java.util.ArrayList;
import java.util.List;

public class PhysicEngine {

    private List<GameObject> gameObjects;
    //Pour faire une boucle pour mise a jrs
    private boolean gameIsRunning = false;
    public PhysicEngine() {
        gameObjects = new ArrayList<>();
    }

    public void createGameObject(float width , float height, float x, float y) {
        GameObject gameObject = new GameObject(width , height, x, y );
        gameObjects.add(gameObject);
    }
    public void removeGameObject1(float width, float height, float x, float y)
    {
        // Iterate through the list of game objects
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getWidth() == width &&
                    gameObject.getHeight() == height &&
                    gameObject.getPosition().getX() == x &&
                    gameObject.getPosition().getY() == y) {// vierfier les paraemtres des objets à supprimer
                gameObjects.remove(gameObject);// how to delete the object completely !!!! can we use destroy !!!
                break;
            }
        }
    }

//while(!gameIsRunning){
// updatePosition
// CheckColision
//Handle Colision }
public void UpdateEngine(float deltaTime){
        for (GameObject gameObject : gameObjects) {
            // Mettez à jour la physique de chaque objet en fonction du temps écoulé (deltaTime).
            //on doit ajouter un parametre du temps à la methode update
            gameObject.update(deltaTime);

            // Vérifiez les collisions avec d'autres objets
            for (GameObject otherObject : gameObjects) {
                if (gameObject != otherObject && gameObject.detectCollision(otherObject)) {
                    //call method to handle the colision
                    gameObject.detectCollision(otherObject);
                }
            }
        }

    }
        // 2nd method to verify colision btw objects
        public void checkcolision () {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject currentObject = gameObjects.get(i);
            for (int j = i + 1; j < gameObjects.size(); j++) {
                GameObject otherObject = gameObjects.get(j);
                if (currentObject.detectCollision(otherObject)) {
                    // Handle collision between currentObject and otherObject
                    currentObject.detectCollision(otherObject);
                }
            }
        }
    }
    }


