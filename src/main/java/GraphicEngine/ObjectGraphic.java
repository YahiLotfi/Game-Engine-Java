package GraphicEngine;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class ObjectGraphic {
	private int width;
    private int height;
    Color color;
    Color borderColor;
    double borderWidth;
   
    
    public ObjectGraphic(int width, int height, Color color, Color borderColor, double borderWidth) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
    }

    public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public double getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(double borderWidth) {
		this.borderWidth = borderWidth;
	}
	
	public int getCenterX() {
        // Calcul du centre en x (abscisse)
        return width / 2;
    }

    public int getCenterY() {
        // Calcul du centre en y (ordonnée)
        return height / 2;
    }
    
    public Rectangle getBounds(int x, int y) {
        int topLeftX = x - getCenterX();
        int topLeftY = y - getCenterY();
        return new Rectangle(topLeftX, topLeftY, width, height);
    }



   
}
