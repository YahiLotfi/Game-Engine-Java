package sample;

import coreKernel.*;
import inputEngine.KeyBinds;

import javafx.scene.paint.Color;
import physicEngine.Bounds;

import java.util.ArrayList;

public class Main {

  static CoreKernel coreKernel = new CoreKernel();
  static GameObject snake = coreKernel.createGameObject(50,50,100,0, Color.RED);

  static ArrayList<GameObject> snakeBody = new ArrayList<GameObject>();
  static float speed  = 10f;
  public static void main(String[] args) {

    snake.getGraphicObject().setTexture("sample/Snake Sprites/head right.png");
    snake.getPhysicObject().setVelocity(speed , 0);
    for (int i = 0; i < 5; i++) {
      addBodySegment();
    }
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_DOWN , () -> snake.getPhysicObject().setVelocity(0 , speed));
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_UP, () -> snake.getPhysicObject().setVelocity(0 , -speed));
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_RIGHT , () -> snake.getPhysicObject().setVelocity(speed , 0));
    coreKernel.getInputHandler().addMapping(KeyBinds.VK_LEFT , () -> snake.getPhysicObject().setVelocity(-speed , 0));

    update();
    coreKernel.startGame(args);

  }
  static void update(){
      coreKernel.update = new Runnable() {
        @Override
        public void run() {
          // Update the position of the first segment to follow the head
          if (snakeBody.size() > 0) {
            GameObject firstSegment = snakeBody.get(0);
            firstSegment.getPhysicObject().setPosition(snake.getPhysicObject().getPosition().getX(), snake.getPhysicObject().getPosition().getY());
          }
          // Update the position of each body segment based on the bounds of the segment before it
          for (int i = snakeBody.size() - 1; i > 0; i--) {
            GameObject currentSegment = snakeBody.get(i);
            GameObject previousSegment = snakeBody.get(i - 1);

            // Get the bounds of the current and previous segments
            Bounds currentBounds = currentSegment.getPhysicObject().getBounds();
            Bounds previousBounds = previousSegment.getPhysicObject().getBounds();

            // Calculate the new position of the current segment based on the bounds of the previous segment
            float newX = 0, newY = 0;

            if (currentSegment.getPhysicObject().getVelocity().getX() > 0) { // Moving right
              newX = previousBounds.getMiddleRightX() - currentBounds.getMiddleLeftX() + previousSegment.getPhysicObject().getPosition().getX();
              newY = previousBounds.getMiddleRightY() - currentBounds.getMiddleLeftY() + previousSegment.getPhysicObject().getPosition().getY();
            } else if (currentSegment.getPhysicObject().getVelocity().getX() < 0) { // Moving left
              newX = previousBounds.getMiddleLeftX() - currentBounds.getMiddleRightX() + previousSegment.getPhysicObject().getPosition().getX();
              newY = previousBounds.getMiddleLeftY() - currentBounds.getMiddleRightY() + previousSegment.getPhysicObject().getPosition().getY();
            } else if (currentSegment.getPhysicObject().getVelocity().getY() > 0) { // Moving down
              newX = previousBounds.getMiddleDownX() - currentBounds.getMiddleTopX() + previousSegment.getPhysicObject().getPosition().getX();
              newY = previousBounds.getMiddleDownY() - currentBounds.getMiddleTopY() + previousSegment.getPhysicObject().getPosition().getY();
            } else if (currentSegment.getPhysicObject().getVelocity().getY() < 0) { // Moving up
              newX = previousBounds.getMiddleTopX() - currentBounds.getMiddleDownX() + previousSegment.getPhysicObject().getPosition().getX();
              newY = previousBounds.getMiddleTopY() - currentBounds.getMiddleDownY() + previousSegment.getPhysicObject().getPosition().getY();
            }

            // Update the position of the current segment
            currentSegment.getPhysicObject().setPosition(newX, newY);
            try {
              Thread.sleep(10);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }



          // Update the position of the head based on its velocity
          snake.getPhysicObject().update();
        }
      };
    }
  private static void addBodySegment() {
    GameObject newSegment = coreKernel.createGameObject(50, 50, 0, 0, Color.GREEN);
    // Set the texture or appearance of the body segment
    newSegment.getGraphicObject().setTexture("sample/Snake Sprites/right left.png");
    // Add the new segment to the snake's body
    snakeBody.add(newSegment);
  }

}
