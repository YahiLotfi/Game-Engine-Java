package PhysicEngine;

import java.util.Vector;

public class GameObject{

    private Vector2 position;

    @Override
    public String toString() {
        return "GameObject{" +
                "position=" + position +
                ", velocity=" + velocity +
                ", acceleration=" + acceleration +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    private Vector2 velocity;
    private Vector2 acceleration;



    private float width;
    private float height;


    public GameObject(float width , float height) {
        this.width = width;
        this.height = height;
        this.position =  new Vector2(0,0);
        this.velocity = new Vector2(0,0);
        this.acceleration = new Vector2(0,0);
    }
    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x , float y)
    {
        this.position = new Vector2(x,y);
    }
    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(float x , float y) {
        this.velocity = new Vector2(x,y);
    }
    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float x, float y) {
        this.acceleration = new Vector2(x,y);
    }



    public float getWidth() { return width; }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() { return height; }

    public void setHeight(float height) {
        this.height = height;
    }



    public void update() {
        // Mettez à jour la vitesse en fonction de l'accélération
            changeVelocity(acceleration);
        // Mettez à jour la position en fonction de la vitesse
            moveObject(velocity);
    }
    private  void moveObject(Vector2 velocity){
        position.setX(position.getX()+velocity.getX());
        position.setY(position.getY()+velocity.getY());
    }
    private void changeVelocity(Vector2 acceleration){
        velocity.setX(velocity.getX()+ acceleration.getX());
        velocity.setY(velocity.getY()+ acceleration.getY());
    }

}
