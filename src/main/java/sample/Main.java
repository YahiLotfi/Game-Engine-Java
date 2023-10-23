package sample;

import CoreKernal.*;
import javafx.scene.paint.Color;

public class Main {

  public static void main(String[] args) {
    CoreKernal coreKernal = new CoreKernal();
    coreKernal.startEngine();

    GameObject obj = coreKernal.createGameObject(100,100,100,100, Color.RED);

  }
}
