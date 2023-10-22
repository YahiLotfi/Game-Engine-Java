package GraphicEngine;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

	public class GameFrame extends Application {
		public GameFrame() {
		}

		@Override
	    public void start(Stage primaryStage) {
	        int windowWidth = 800;
	        int windowHeight = 600;

	        // Crée un groupe pour contenir le rectangle
	        Group root = new Group();

	        // Crée la scène
	        Scene scene = new Scene(root, windowWidth, windowHeight);

	        // Configure et affiche la fenêtre
	        primaryStage.setTitle("Our Game");
	        primaryStage.setScene(scene);


//			root.getChildren().add(rectangle2);

	        primaryStage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}
