package CoreKernal;

import GraphicEngine.*;
import PhysicEngine.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class CoreKernal {

    private  float deltaTime;
    private float lastFrametime;
    private PhysicEngine physicEngine;
    private GraphicEngine graphicEngine;
    private boolean gameIsRunning=true;

    // la vitesse du passage du temps , il normal a 1  , quand on veut pauser le jeu on le mets a 0
    private  float timeScale=1;

    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();


    public void startEngine(String[] args){
        physicEngine = new PhysicEngine();
        graphicEngine = new GraphicEngine(args);
        start();
        gameLoop();
    }
    public void start(){
        lastFrametime = System.currentTimeMillis();


    }
    public void gameLoop(){
        while (gameIsRunning){
            deltaTime =  (lastFrametime - System.currentTimeMillis()) * timeScale;
            lastFrametime = System.currentTimeMillis();
            physicEngine.updateEngine(deltaTime);
            updateGameObjects();

        }

    }
    public GameObject createGameObject(float width , float height, float x, float y , Color color)
    {
        GameObject go = new GameObject();
        PhysicObject pe = physicEngine.createPhysicObject(width , height, x, y );
        GraphicObject ge = graphicEngine.createGraphicObject(width , height, x, y,color);
        go.setPhysicObject(pe);
        go.setGraphicObject(ge);
        return go;
    }
    public void updateGameObjects(){
        for (GameObject go : gameObjects) {
            go.updateGameObject();
        }
    }

    public  void pause(){
        timeScale = 0;
    }
    public  void unPause(){
        timeScale = 1;
    }
}

