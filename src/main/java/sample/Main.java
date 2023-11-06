package sample;

import CoreKernal.*;
import InputEngine.KeyBinds;
import javafx.scene.paint.Color;

public class Main {

  public static void main(String[] args) {
    CoreKernal coreKernal = new CoreKernal();
    GameObject snake = coreKernal.createGameObject(50,50,100,0, Color.RED);
    snake.getGraphicObject().setTexture("sample/Snake Sprites/head right.png");
    float speed  = 20f;
    snake.getPhysicObject().setVelocity(speed , 0);
    coreKernal.getInputHandler().addMapping(KeyBinds.VK_DOWN , () -> snake.getPhysicObject().setVelocity(0 , speed));
    coreKernal.getInputHandler().addMapping(KeyBinds.VK_UP, () -> snake.getPhysicObject().setVelocity(0 , -speed));
    coreKernal.getInputHandler().addMapping(KeyBinds.VK_RIGHT , () -> snake.getPhysicObject().setVelocity(speed , 0));
    coreKernal.getInputHandler().addMapping(KeyBinds.VK_LEFT , () -> snake.getPhysicObject().setVelocity(-speed , 0));
    //GameFrame.main(args , coreKernal );
    coreKernal.startGame(args);

  }
}
