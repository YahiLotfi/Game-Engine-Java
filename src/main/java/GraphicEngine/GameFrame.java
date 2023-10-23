package GraphicEngine;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

			this.root = new Group();
			this.scene = new Scene(root, windowWidth, windowHeight);

		}

		@Override
	    public void start(Stage primaryStage) {


	        // Configure et affiche la fenêtre
	        primaryStage.setTitle("Our Game");
	        primaryStage.setScene(this.scene);
			primaryStage.show();

	    }


	    public static void main(String[] args) {
	        launch(args);
	    }
	}
