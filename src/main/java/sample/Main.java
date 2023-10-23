package sample;

import CoreKernal.*;
import javafx.scene.paint.Color;

public class Main {

  public static void main(String[] args) {
    CoreKernal coreKernal = new CoreKernal();
    System.out.println("hello1");
    coreKernal.startEngine(args);
    System.out.println("hello2");

    GameObject obj = coreKernal.createGameObject(1000,1000,2,2, Color.RED);
    System.out.println("hello3");

    coreKernal.startGame();
    System.out.println("hello4");


    System.out.println(coreKernal.getGameObjects().size());

  }
}
