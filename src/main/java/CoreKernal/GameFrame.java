package CoreKernal;

import GraphicEngine.GraphicObject;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameFrame extends Application {

		public static GameFrame instance;

		private static final double TARGET_FRAME_TIME = 1000.0 / 60.0; // Target frame time for 60 FPS
		private long lastFrameTime = System.nanoTime();
		private  static CoreKernal coreKernal;
		private Group root = new Group() ;

		private Scene scene ;

		public Group getRoot() {
			return root;
		}

		public void addObjToRoot(GraphicObject graphicObject) {
			this.root.getChildren().add( graphicObject.getRectangle());
			if(graphicObject.getTexture() != null)
			{
				this.root.getChildren().add( graphicObject.createImageView());
			}
		}

		public Scene getScene() {
			return scene;
		}

		public void setScene(Scene scene) {
			this.scene = scene;
		}


		public GameFrame() {
			System.out.println("GameFrame afficher");
		}

	@Override
	public void start(Stage primaryStage) {
		instance = this;
		addObjectsToRoot(coreKernal.getGraphicEngine().getGraphicObjects());
		// Get the primary screen
		Screen screen = Screen.getPrimary();

		// Get the visual bounds of the screen
		javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();

		// Create your JavaFX content here

		// Set the stage's dimensions to match the screen's dimensions
		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		primaryStage.setTitle("Constant Frame Rate Game");
		scene = new Scene(root);

		scene.setOnKeyPressed(coreKernal.getInputHandler().eventHandler);

		primaryStage.setScene(scene);
		primaryStage.show();

		// Set up the AnimationTimer for the game loop
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				double deltaTime = (now - lastFrameTime) / 1_000_000.0; // Convert to milliseconds

				if (deltaTime >= TARGET_FRAME_TIME) {
					coreKernal.gameLoop();

					lastFrameTime = now;

					// Calculate time to sleep to achieve a constant frame rate
					double sleepTime = TARGET_FRAME_TIME - deltaTime;
					if (sleepTime > 0) {
						try {
							Thread.sleep((long) sleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
	}
	void addObjectsToRoot(ArrayList<GraphicObject> objects){
		for (GraphicObject obj : objects
			 ) {
			addObjToRoot(obj);
		}

	}


	    public static void main(String[] args , CoreKernal coreKernal)
		{
			GameFrame.coreKernal = coreKernal;
			launch(args);
		}
	}
