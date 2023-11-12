package sample;

import coreKernel.*;
import inputEngine.KeyBinds;
import javafx.scene.paint.Color;
import physicEngine.Bounds;

import java.util.ArrayList;

public class Main {

  static CoreKernel coreKernel = new CoreKernel();
  static GameObject snake = coreKernel.createGameObject(50, 50, 100, 0, Color.RED);

  static ArrayList<GameObject> snakeBody = new ArrayList<>();
  static float speed = 10f;
  static int gridSize = 20; // Size of the grid

  public static void main(String[] args) {
    snake.getGraphicObject().setTexture("sample/Snake Sprites/head right.png");
    snake.getPhysicObject().setVelocity(speed, 0);

    for (int i = 0; i < 5; i++) {
      addBodySegment();
    }

    coreKernel.getInputHandler().addMapping(KeyBinds.VK_DOWN, () -> snake.getPhysicObject().setVelocity(0, speed));
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_UP, () -> snake.getPhysicObject().setVelocity(0, -speed));
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_RIGHT, () -> snake.getPhysicObject().setVelocity(speed, 0));
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_LEFT, () -> snake.getPhysicObject().setVelocity(-speed, 0));

    update();
    coreKernel.startGame(args);
  }

  static void update() {
    coreKernel.update = new Runnable() {
      @Override
      public void run() {
        // Update the position of the first segment to follow the head
        if (snakeBody.size() > 0) {
          GameObject firstSegment = snakeBody.get(0);
          moveToGridPosition(firstSegment, snake.getPhysicObject().getPosition().getX(), snake.getPhysicObject().getPosition().getY());
        }

        // Update the position of each body segment based on the position of the previous segment
        for (int i = snakeBody.size() - 1; i > 0; i--) {
          GameObject currentSegment = snakeBody.get(i);
          GameObject previousSegment = snakeBody.get(i - 1);
          moveToGridPosition(currentSegment, previousSegment.getPhysicObject().getPosition().getX(), previousSegment.getPhysicObject().getPosition().getY());
        }

        // Update the position of the head based on its velocity
        snake.getPhysicObject().update();
      }
    };
  }

  private static void addBodySegment() {
    GameObject newSegment = coreKernel.createGameObject(50, 50, 0, 0, Color.GREEN);
    newSegment.getGraphicObject().setTexture("sample/Snake Sprites/right left.png");
    snakeBody.add(newSegment);
  }

  // Move the game object to the nearest grid position
  private static void moveToGridPosition(GameObject gameObject, float x, float y) {
    float newX = Math.round(x / gridSize) * gridSize;
    float newY = Math.round(y / gridSize) * gridSize;
    gameObject.getPhysicObject().setPosition(newX, newY);
  }
}
