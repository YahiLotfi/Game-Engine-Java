package GraphicEngine;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

	public class GraphicEngine extends Application {

	    @Override
	    public void start(Stage primaryStage) {
	        int windowWidth = 800;
	        int windowHeight = 600;
	        

	        // Crée un objet ObjectGraphic avec une largeur, une hauteur, des couleurs et une largeur de bordure
	        GraphicObject object = new GraphicObject(100, 50, Color.RED, 1 , 2);

	        // Crée un rectangle pour représenter l'objet
	        Rectangle rectangle = new Rectangle(object.getWidth(), object.getHeight());
	        rectangle.setFill(object.getColor());


	        // Place l'objet aux coordonnées spécifiées (x, y)
	        rectangle.setLayoutX(objectX - object.getCenterX());
	        rectangle.setLayoutY(objectY - object.getCenterY());

	        // Crée un groupe pour contenir le rectangle
	        Group root = new Group(rectangle);

	        // Crée la scène
	        Scene scene = new Scene(root, windowWidth, windowHeight);

	        // Configure et affiche la fenêtre
	        primaryStage.setTitle("ObjectGraphic Display");
	        primaryStage.setScene(scene);


			// Coordonnées de position pour l'objet
			int objectX2 = 100;
			int objectY2 = 50;


			// Crée un objet ObjectGraphic avec une largeur, une hauteur, des couleurs et une largeur de bordure
			GraphicObject object2 = new GraphicObject(100, 50, Color.RED, 1 , 2);

			// Crée un rectangle pour représenter l'objet
			Rectangle rectangle2 = new Rectangle(object.getWidth(), object.getHeight());
			rectangle.setFill(object.getColor());


			// Place l'objet aux coordonnées spécifiées (x, y)
			rectangle.setLayoutX(objectX - object.getCenterX());
			rectangle.setLayoutY(objectY - object.getCenterY());

			// Crée un groupe pour contenir le rectangle
			root.getChildren().add(rectangle2);




	        primaryStage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}
