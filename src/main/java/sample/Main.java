package sample;

import CoreKernal.*;
import javafx.scene.paint.Color;

public class Main {

  public static void main(String[] args) {
    CoreKernal coreKernal = new CoreKernal();
    coreKernal.startEngine(args);
    GameObject obj = coreKernal.createGameObject(1000,1000,2,2, Color.RED);
    coreKernal.startGame();

    System.out.println(coreKernal.getGameObjects().size());

  }
}
