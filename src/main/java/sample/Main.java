package sample;

import coreKernel.*;
import inputEngine.KeyBinds;

import javafx.scene.paint.Color;

public class Main {

  public static void main(String[] args) {
    CoreKernel coreKernel = new CoreKernel();
    GameObject snake = coreKernel.createGameObject(50,50,100,0, Color.RED);
    snake.getGraphicObject().setTexture("sample/Snake Sprites/head right.png");
    float speed  = 5f;
    snake.getPhysicObject().setVelocity(speed , 0);
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_DOWN , () -> snake.getPhysicObject().setVelocity(0 , speed));
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_UP, () -> snake.getPhysicObject().setVelocity(0 , -speed));
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_RIGHT , () -> snake.getPhysicObject().setVelocity(speed , 0));
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_LEFT , () -> snake.getPhysicObject().setVelocity(-speed , 0));
    //GameFrame.main(args , coreKernal );
    coreKernel.startGame(args);

  }
}
