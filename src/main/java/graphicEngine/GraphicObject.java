package graphicEngine;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
public class GraphicObject {
	private float width;
    private float height;
	private Rectangle rectangle;
    private Color color;
	private String texture;

	private ImageView imageView;

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

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
    }

	public void updatePosition(float x, float y) {
		this.position.set(x,y);

		this.rectangle.setLayoutX(x - this.getCenterX());
        this.rectangle.setLayoutY(y - this.getCenterY());
		if(imageView != null){
			imageView.setTranslateX(x - this.getCenterX());
			imageView.setTranslateY(y - this.getCenterY());
		}

	}

	public ImageView createImageView(){
		if(texture != null){
			imageView =  new ImageView();
			Image image = new Image(texture);
			imageView.setImage(image);
			rectangle.setFill(Color.rgb(0,0,0,0));

			return imageView;
		}
		return null;
	}
	public void updateTexture(String texture){
		imageView.setImage(new Image(texture));
	}
	public void rescaleImageView(float width , float height){
		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		imageView.setPreserveRatio(false);

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




   
}
