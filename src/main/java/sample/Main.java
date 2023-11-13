package sample;

import coreKernel.*;
import inputEngine.KeyBinds;
import javafx.scene.paint.Color;
import physicEngine.Bounds;

import java.util.ArrayList;
import java.util.Random;

public class Main {

  static CoreKernel coreKernel = new CoreKernel();
  static GameObject snake = coreKernel.createGameObject(50, 50, 960, 540, Color.RED);

  static ArrayList<GameObject> snakeBody = new ArrayList<>();
  static float speed = 20f;
  static int gridSize = 20; // Size of the grid
  static int wallSize = 29; // Size of the wall
  static ArrayList<GameObject> walls = new ArrayList<>();
  static ArrayList<GameObject> apples = new ArrayList<>();
  static GameObject background;
  static int appleSize = 50;
  public static void main(String[] args) {
    snake.getGraphicObject().setTexture("sample/Snake Sprites/head right.png");
    snake.getPhysicObject().setVelocity(speed, 0);

    for (int i = 0; i < 5; i++) {
      addBodySegment();
    }
    for (int i = 0; i < 3; i++) {
      spawnApple();
    }
    spawnWalls();
    spawnBackground();

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

    // Ensure the bounds are updated based on the new position
    Bounds bounds = gameObject.getPhysicObject().getBounds();
    bounds.updateBounds(gameObject.getPhysicObject().getWidth(), gameObject.getPhysicObject().getHeight(), newX, newY);

    // Update the position based on the direction of the snake
    float velocityX = gameObject.getPhysicObject().getVelocity().getX();
    float velocityY = gameObject.getPhysicObject().getVelocity().getY();

    // Adjust the position based on the direction
    if (velocityX > 0) { // Moving right
      newX = Math.min(newX, bounds.getMiddleRightX() - gameObject.getPhysicObject().getWidth());

    } else if (velocityX < 0) { // Moving left
      newX = Math.max(newX, bounds.getMiddleLeftX());
    }

    if (velocityY > 0) { // Moving down
      newY = Math.min(newY, bounds.getMiddleDownY() - gameObject.getPhysicObject().getHeight());
    } else if (velocityY < 0) { // Moving up
      newY = Math.max(newY, bounds.getMiddleTopY());
    }
    setSnakeHeadTexture();
    setSnakeBodyTexture();
    // Update the position
    gameObject.getPhysicObject().setPosition(newX, newY);
  }

  private static void setSnakeHeadTexture() {
    float velocityX = snake.getPhysicObject().getVelocity().getX();
    float velocityY = snake.getPhysicObject().getVelocity().getY();

    if (velocityX > 0) {
      snake.getGraphicObject().updateTexture("sample/Snake Sprites/head right.png");
    } else if (velocityX < 0) {
      snake.getGraphicObject().updateTexture("sample/Snake Sprites/head left.png");
    } else if (velocityY > 0) {
      snake.getGraphicObject().updateTexture("sample/Snake Sprites/head down.png");
    } else if (velocityY < 0) {
      snake.getGraphicObject().updateTexture("sample/Snake Sprites/head up.png");
    }
  }
  private static void setSnakeBodyTexture() {
    for (int i = 0; i < snakeBody.size(); i++) {
      GameObject bodySegment = snakeBody.get(i);

      // Check the position of the current body segment relative to the next one
      float currentX = bodySegment.getPhysicObject().getPosition().getX();
      float currentY = bodySegment.getPhysicObject().getPosition().getY();

      float nextX, nextY;

      // If it's not the last body segment, get the position of the next one
      if (i < snakeBody.size() - 1) {
        GameObject nextSegment = snakeBody.get(i + 1);
        nextX = nextSegment.getPhysicObject().getPosition().getX();
        nextY = nextSegment.getPhysicObject().getPosition().getY();
      } else {
        // If it's the last body segment, assume the same position as the head
        nextX = snake.getPhysicObject().getPosition().getX();
        nextY = snake.getPhysicObject().getPosition().getY();
      }

      // Update the texture based on the relative position
      if (currentX < nextX) {
        bodySegment.getGraphicObject().updateTexture("sample/Snake Sprites/right left.png");
      } else if (currentX > nextX) {
        bodySegment.getGraphicObject().updateTexture("sample/Snake Sprites/right left.png");
      } else if (currentY < nextY) {
        bodySegment.getGraphicObject().updateTexture("sample/Snake Sprites/up down.png");
      } else if (currentY > nextY) {
        bodySegment.getGraphicObject().updateTexture("sample/Snake Sprites/up down.png");
      }
    }
  }
  static void spawnApple() {
    Random random = new Random();

    // Generate random coordinates within the game bounds
    float x = random.nextInt(1920/ gridSize) * gridSize;
    float y = random.nextInt(1080/ gridSize) * gridSize;

    // Create a new apple GameObject
    GameObject apple = coreKernel.createGameObject( appleSize, appleSize,x, y, Color.YELLOW);
    apple.getGraphicObject().setTexture("sample/Snake Sprites/apple.png"); // Set the texture for the apple

    apples.add(apple);
  }
  static void spawnBackground() {
    background = coreKernel.createGameObject(1920, 1080, 0, 0, Color.TRANSPARENT); // Adjust size as needed
    background.getGraphicObject().setTexture("sample/Environement/wp2635955.png");
    // Set the texture for the background image
  }
  static void spawnWalls() {
    // Top wall
    for (int x = 0; x < 1920; x += wallSize) {
      GameObject wall = coreKernel.createGameObject(wallSize, wallSize, x, 0, Color.GRAY);
      wall.getGraphicObject().setTexture("sample/Environement/wall.png");
      walls.add(wall);
    }

    // Bottom wall
    for (int x = 0; x < 1920; x += wallSize) {
      GameObject wall = coreKernel.createGameObject(wallSize, wallSize, x, 1080 - wallSize, Color.GRAY);
      wall.getGraphicObject().setTexture("sample/Environement/wall.png");
      walls.add(wall);
    }

    // Left wall
    for (int y = wallSize; y < 1080 - wallSize; y += wallSize) {
      GameObject wall = coreKernel.createGameObject(wallSize, wallSize, 0, y, Color.GRAY);
      wall.getGraphicObject().setTexture("sample/Environement/wall.png");
      walls.add(wall);
    }

    // Right wall
    for (int y = wallSize; y < 1080 - wallSize; y += wallSize) {
      GameObject wall = coreKernel.createGameObject(wallSize, wallSize, 1920 - wallSize, y, Color.GRAY);
      wall.getGraphicObject().setTexture("sample/Environement/wall.png");
      walls.add(wall);
    }
  }
//  public void checkCollisions{
//    for(GameObject apple : apples){
//      coreKernel.
//    }
//  }

}
