package physicEngine;

import java.util.ArrayList;

public class PhysicEngine {
    private ArrayList<PhysicObject> physicObjects;
    public PhysicEngine() {physicObjects = new ArrayList<>();}
    /* createPhysicObject crée un nouveau PhysicObject avec les dimensions spécifiées (largeur et hauteur) et
    la position (x et y) dans le monde du jeu. */

    public PhysicObject createPhysicObject(float width , float height, float x, float y) {
        PhysicObject physicObject = new PhysicObject(width , height, x, y );
        System.out.println("here");
        physicObjects.add(physicObject);
        System.out.println(physicObjects.size());
        return physicObject;
    }

    public static boolean intersectSerpent(float x1, float  x2, float y1, float   y2){
        return (y1<x1 && x1<y2)||(y1<x2 && x2<y2 );}

    public static boolean checkCollisionSerpent(PhysicObject object1, PhysicObject object2) {
      return (intersectSerpent(object1.getPosition().getX(), object1.getRight(), object2.getPosition().getX(), object2.getRight())&&
                intersectSerpent(object1.getPosition().getY(), object1.getBottom(), object2.getPosition().getY(), object2.getBottom())
        );



    }
    public static boolean intersects(float x1, float  x2, float y1, float   y2){

        return (y1<=x1 && x1<=y2)||(y1<=x2 && x2<=y2 );
    }
    public static boolean checkCollision(PhysicObject object1, PhysicObject object2) {
        return (intersects(object1.getPosition().getX(), object1.getRight(), object2.getPosition().getX(), object2.getRight())&&
                intersects(object1.getPosition().getY(), object1.getBottom(), object2.getPosition().getY(), object2.getBottom())
                );

    }
    public static boolean _checkCollision(PhysicObject object1, PhysicObject object2) {
        Bounds BoundsObject1 = object1.getBounds();
        Bounds BoundsObject2 = object2.getBounds();



        /*verifier tous les cas déclanchant une collision entre deux objet*/
        /*retourner true si un de ces cas se produit, false sinon*/
        return (
                /*Ce cas vérifie si le côté droit de BoundsObject1 est à droite du côté gauche de BoundsObject2
                 et si le point médian en haut de BoundsObject1 est en dessus du point médian en bas de
                 BoundsObject2. Cela peut se produire si l'Object1 entre en collision avec
               le côté droit et la partie inférieure de l'Object2. */
                (BoundsObject1.getMiddleRightX() > BoundsObject2.getMiddleLeftX() &&
                        BoundsObject1.getMiddleTopY() < BoundsObject2.getMiddleDownY()) ||
             /*cas ou  l'Object1 entre en collision avec le côté gauche et la
             partie inférieure de l'Object2. */
                      (BoundsObject1.getMiddleLeftX()<BoundsObject2.getMiddleRightX() &&
                                BoundsObject1.getMiddleTopY() < BoundsObject2.getMiddleDownY()) ||
            /*cas ou  l'Object1 entre en collision avec le côté droit et la
             partie supérieur de l'Object2. */
                        (BoundsObject1.getMiddleRightX() > BoundsObject2.getMiddleLeftX()&&
                                BoundsObject1.getMiddleDownY() > BoundsObject2.getMiddleTopY())  ||
            /*cas ou  l'Object1 entre en collision avec le côté gauche et la
             partie supérieur de l'Object2. */
                        (BoundsObject1.getMiddleLeftX()<BoundsObject2.getMiddleRightX() &&
                                BoundsObject1.getMiddleDownY() > BoundsObject2.getMiddleTopY()  )
        );
    }
    public void updateEngine(){
        for (PhysicObject physicObject : physicObjects) {
            physicObject.update( );
        }

    }

}


