package PhysicEngine;

import java.util.List;
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
    private float mass;


    public GameObject(float width , float height,
                      float x, float y) {
        this.width = width;
        this.height = height;
        this.position =  new Vector2(x,y);
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
    public Vector2 getAcceleration() {  return acceleration;}

    public void setAcceleration(float x, float y) {this.acceleration = new Vector2(x,y);
    }



    public float getWidth() { return width; }

    public void setWidth(float width) {this.width = width;}

    public float getHeight() { return height; }

    public void setHeight(float height) {
        this.height = height;
    }



    public void update() {
        // il faut ajouter le temps de mise jrs genre quand il doit faire le mise à jrs
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

/*créer une methode pour déterminer if currect object is in collision with other objects
by detecting bounding boxes of two objects
 */
        public boolean detectCollision(GameObject otherobject) {
            //compare parameters of this object with other objects
            float left1 = position.getX();
            float right1 = position.getX() + width;
            float top1 = position.getY();
            float bottom1 = position.getY() + height;

            float left2 = otherobject.position.getX();
            float right2 = otherobject.position.getX() + otherobject.width;
            float top2 = otherobject.position.getY();
            float bottom2 = otherobject.position.getY() + otherobject.height;

            return (right1 >= left2 && left1 <= right2 && bottom1 >= top2 && top1 <= bottom2);
        }
   //To handle with the problem of colision of two object we stop both of them
   // So we set their velocity equal to zero
   public void handleCollision(GameObject currentObject, GameObject otherObject) {
       if (currentObject.detectCollision(otherObject)) {
           // Stop both objects
           currentObject.setVelocity(0, 0);
           otherObject.setVelocity(0, 0);
       }
   }
    /* calculer les nouvelles vitesses et les nouvelles position des objets*/








    //Im still working on this
/*Bouncing or deflecting objects away from each other in Java involves updating the velocities
of the colliding objects to simulate a realistic bounce.*/

    public void handleColisionBound(GameObject currentObject, GameObject otherObject){

        if (currentObject.detectCollision(otherObject)) {
        // Calculate the new velocities for the objects to simulate a bounce
        double tempDx = currentObject.velocity.getX();
        double tempDy = otherObject.velocity.getY();

    }
        }


    public static Vector2 calculateCollisionNormal(GameObject object1, GameObject object2) {
        // Calculate and return the collision normal (unit vector pointing from object1 to object2)
        float dx = object2.velocity.getX() - object1.velocity.getX();
        float dy = object2.velocity.getY() - object1.velocity.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return new Vector2(dx / distance, dy / distance);
    }







}
