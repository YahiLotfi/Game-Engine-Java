package GraphicEngine;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

	public class GameFrame  extends Application {

	    @Override
	    public void start(Stage primaryStage) {
	        int windowWidth = 800;
	        int windowHeight = 600;

	        // Coordonnées de position pour l'objet
	        int objectX = 200;
	        int objectY = 150;
	        

	        // Crée un objet ObjectGraphic avec une largeur, une hauteur, des couleurs et une largeur de bordure
	        ObjectGraphic object = new ObjectGraphic(100, 50, Color.RED, Color.BLUE, 2.0);

	        // Crée un rectangle pour représenter l'objet
	        Rectangle rectangle = new Rectangle(object.getWidth(), object.getHeight());
	        rectangle.setFill(object.getColor());
	        rectangle.setStroke(object.getBorderColor());
	        rectangle.setStrokeWidth(object.getBorderWidth());

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
	        primaryStage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}
