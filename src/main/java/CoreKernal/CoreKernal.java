package CoreKernal;

import PhysicEngine.PhysicEngine;

public class CoreKernal {

    private  float deltaTime;
    private float lastFrametime;
    private PhysicEngine physicEngine;


    public void startEngine(){
        start();
        gameLoop();
    }
    public void start(){
        lastFrametime = System.currentTimeMillis();
    }
    public void gameLoop(){

        deltaTime =  lastFrametime - System.currentTimeMillis();
        lastFrametime = System.currentTimeMillis();
        physicEngine.UpdateEngine(deltaTime);

    }

}

