package GraphicEngine;

import CoreKernal.GameObject;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Collection;

public class GameFrame extends Application {

		int windowWidth = 800;
		int windowHeight = 600;
		Rectangle rec = new Rectangle(200,200,Color.RED);
		private Group root = new Group(rec) ;

		private Scene scene ;

		public Group getRoot() {
			return root;
		}

		public void addObjToRoot(GraphicObject graphicObject) {
			System.out.println("Ghiles mouloudia");
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
			System.out.println("Hii");
			this.scene = new Scene(root, windowWidth, windowHeight);
	        primaryStage.setScene(scene);
			scene.setFill(Color.BLACK);
			primaryStage.show();
	    }


	    public static void main(String[] args) {
		launch(args);
		}
	}
