package physicEngine;
public class PhysicObject {
    //Déclaration des variables
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private float width;
    private float height;
    private float mass;

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

    //Déclara les getters et setters des variables
    public Vector2 getPosition() {
        return position;
    }

    public PhysicObject(float width, float height, float x, float y) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0.00001f, 0);
        this.acceleration = new Vector2(0, 0);
    }

    public void setPosition(float x, float y) {
        this.position = new Vector2(x, y);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(float x, float y) {
        this.velocity = new Vector2(x, y);
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float x, float y) {
        this.acceleration = new Vector2(x, y);
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

    /*La fonction update() et pour
    Mettre à jour la vitesse de l'objet en fonction de son accélération.
    Elle met à jour la position de l'objet en fonction de sa vitesse.*/
    public void update() {
        changeVelocity(acceleration);
        moveObject(velocity);
    }

    /*La fonction moveObject() prend un vecteur de vitesse
    en entrée et met à jour la position de l'objet*/
    private void moveObject(Vector2 velocity) {
        position.setX(position.getX() + velocity.getX());
        position.setY(position.getY() + velocity.getY());
    }

    /*La fonction changeVelocity() prend un vecteur d'accélération
    en entrée et met à jour la vitesse de l'objet.*/
    private void changeVelocity(Vector2 acceleration) {
        velocity.setX(velocity.getX() + acceleration.getX());
        velocity.setY(velocity.getY() + acceleration.getY());
    }

}