package sample;

import CoreKernal.*;
import GraphicEngine.GameFrame;
import javafx.scene.paint.Color;

public class Main {

  public static void main(String[] args) {
    CoreKernal coreKernal = new CoreKernal();
    GameObject obj = coreKernal.createGameObject(50,50,100,0, Color.RED);
    GameFrame.main(args , coreKernal );

  }
}
