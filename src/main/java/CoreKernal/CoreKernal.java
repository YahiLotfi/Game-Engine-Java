package CoreKernal;

import GraphicEngine.*;
import InputEngine.InputHandler;
import PhysicEngine.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class CoreKernal {

    private  float deltaTime;
    private float lastFrametime;
    private PhysicEngine physicEngine;
    private GraphicEngine graphicEngine;
    private InputHandler inputHandler;
    private boolean gameIsRunning=true;
    public CoreKernal() {
        physicEngine = new PhysicEngine();
        graphicEngine = new GraphicEngine();
        inputHandler = new InputHandler();
    }
    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }
    public InputHandler getInputHandler() {
        return inputHandler;
    }
    public PhysicEngine getPhysicEngine() {
        return physicEngine;
    }
    public GraphicEngine getGraphicEngine() {
        return graphicEngine;
    }
    // la vitesse du passage du temps, il normal a 1, quand on veut pauser le jeu on le mets a 0
    private  float timeScale=1;
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

     /* La fonction gameLoop() est la fonction principale d'une boucle de jeu.
    Elle est appelée à chaque frame du jeu et est responsable de mettre à jour le jeu.*/
    public void gameLoop(){
            deltaTime =  (lastFrametime - System.currentTimeMillis()) * timeScale;// Calcule le temps écoulé depuis la dernière frame.
            lastFrametime = System.currentTimeMillis();
            physicEngine.updateEngine();// appelle la méthode updateEngine() du moteur physique pour mettre à jour le mouvement des objets du jeu.
            updateGameObjects();
    }
    public GameObject createGameObject(float width , float height, float x, float y , Color color)
    {
        GameObject go = new GameObject();
        PhysicObject pe = physicEngine.createPhysicObject(width , height, x, y );
        GraphicObject ge = graphicEngine.createGraphicObject(width , height, x, y,color);
        go.setPhysicObject(pe);
        go.setGraphicObject(ge);
        gameObjects.add(go);
        return go;
    }
    public GameObject createGameObject(float width , float height, float x, float y )
    {
        GameObject go = new GameObject();
        PhysicObject pe = physicEngine.createPhysicObject(width , height, x, y );
        GraphicObject ge = graphicEngine.createGraphicObject(width , height, x, y,Color.rgb(0,0,0,0));
        go.setPhysicObject(pe);
        go.setGraphicObject(ge);
        gameObjects.add(go);
        return go;
    }
    public void updateGameObjects(){
        for (GameObject go : gameObjects) {
            go.updateGameObject();
        }
    }
    // Pause le jeu en mettant le facteur d'échelle du temps à 0.
    public  void pause(){
        timeScale = 0;
    }
    // Reprend le jeu en mettant le facteur d'échelle du temps à 1.
    public  void unPause(){
        timeScale = 1;
    }
}

