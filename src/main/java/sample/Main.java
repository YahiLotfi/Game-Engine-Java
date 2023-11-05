package sample;

import CoreKernal.*;
import CoreKernal.GameFrame;
import InputEngine.KeyBinds;
import javafx.scene.paint.Color;

public class Main {

  public static void main(String[] args) {
    CoreKernal coreKernal = new CoreKernal();
    GameObject snake = coreKernal.createGameObject(50,50,100,0, Color.RED);
    snake.getGraphicObject().setTexture("sample/Snake Sprites/head right.png");
    float speed  = 20f;
    coreKernal.getInputHandler().addMapping(KeyBinds.VK_S , () -> snake.getPhysicObject().setVelocity(0 , speed));
    coreKernal.getInputHandler().addMapping(KeyBinds.VK_W , () -> snake.getPhysicObject().setVelocity(0 , -speed));
    coreKernal.getInputHandler().addMapping(KeyBinds.VK_D , () -> snake.getPhysicObject().setVelocity(speed , 0));
    coreKernal.getInputHandler().addMapping(KeyBinds.VK_A , () -> snake.getPhysicObject().setVelocity(-speed , 0));
    GameFrame.main(args , coreKernal );

  }
}
