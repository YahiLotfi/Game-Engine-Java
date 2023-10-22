package CoreKernal;

import PhysicEngine.PhysicEngine;

public class CoreKernal {

    private  float deltaTime;
    private float lastFrametime;
    private PhysicEngine physicEngine;
    private boolean gameIsRunning=true;

    // la vitesse du passage du temps , il normal a 1  , quand on veut pauser le jeu on le mets a 0
    private  float timeScale=1;


    public void startEngine(){
        physicEngine = new PhysicEngine();
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
            physicEngine.UpdateEngine(deltaTime);

        }

    }
    public  void pause(){
        timeScale = 0;
    }
    public  void unPause(){
        timeScale = 1;
    }
}

