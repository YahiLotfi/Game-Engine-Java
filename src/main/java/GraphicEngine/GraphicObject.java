package GraphicEngine;

import PhysicEngine.Vector2;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class GraphicObject {
	private float width;
    private float height;
	private Rectangle rectangle;
    Color color;
//    Color borderColor;
//    double borderWidth;

	private Vector2 position;

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public GraphicObject(float width, float height, float x, float y, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
		this.position =  new Vector2(x,y);
		this.rectangle = new Rectangle(this.width, this.height);
		rectangle.setFill(this.color);

		// Place l'objet aux coordonnées spécifiées (x, y)
		rectangle.setLayoutX(this.position.getX() - this.getCenterX());
		rectangle.setLayoutY(this.position.getY() - this.getCenterY());
    }

	public void updatePosition(float x, float y) {
		this.position.set(x,y);

		this.rectangle.setLayoutX(x - this.getCenterX());
        this.rectangle.setLayoutY(y - this.getCenterY());
	}

    public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
	public float getCenterX() {
        // Calcul du centre en x (abscisse)
        return width / 2;
    }

    public float getCenterY() {
        // Calcul du centre en y (ordonnée)
        return height / 2;
    }
    
    public Rectangle getBounds(float x, float y) {
		float topLeftX = x - getCenterX();
		float topLeftY = y - getCenterY();
        return new Rectangle(topLeftX, topLeftY, width, height);
    }



   
}
