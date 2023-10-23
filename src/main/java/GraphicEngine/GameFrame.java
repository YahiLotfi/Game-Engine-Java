package GraphicEngine;

import CoreKernal.GameObject;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Collection;

public class GameFrame extends Application {

		int windowWidth = 800;
		int windowHeight = 600;

		private Group root ;

		private Scene scene ;

		public Group getRoot() {
			return root;
		}

		public void addObjToRoot(GraphicObject graphicObject) {
			this.root.getChildren().add( graphicObject.getRectangle());
		}

		public Scene getScene() {
			return scene;
		}

		public void setScene(Scene scene) {
			this.scene = scene;
		}



		public GameFrame() {
		}

		@Override
	    public void start(Stage primaryStage) {
			//Creating a Group object
			this.root = new Group();
			this.scene = new Scene(root, windowWidth, windowHeight);
	        primaryStage.setScene(scene);
			primaryStage.show();


	    }


	    public static void main(String[] args) {
		launch(args);
		}
	}
