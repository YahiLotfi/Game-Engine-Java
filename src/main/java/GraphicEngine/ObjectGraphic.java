package GraphicEngine;
import java.awt.Rectangle;

public class ObjectGraphic {

    private int x;
    private int y;
    private int width;
    private int height;
    public ObjectGraphic() {
        this.height=height;
        this.width=width;
        this.x = x;
        this.y = y;
    }

    public ObjectGraphic(int x, int y) {
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}