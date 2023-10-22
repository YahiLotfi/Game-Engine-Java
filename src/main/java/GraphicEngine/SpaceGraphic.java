package GraphicEngine;

import PhysicEngine.GameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class SpaceGraphic extends JPanel {
    private int mouvementHorz;
    private int mouvementVert;
    private List<GameObject> gameObjects;

    public SpaceGraphic() {
        super();
        gameObjects = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw game objects here using the Graphics object 'g'
        for (GameObject obj : gameObjects) {
            // You can draw your game objects based on their properties like position, width, height, etc.
            g.fillRect((int) obj.getPosition().getX(), (int) obj.getPosition().getY(), (int) obj.getWidth(), (int) obj.getHeight());
        }
    }

    public void move() {
        // Update the positions of game objects based on their velocities here
        for (GameObject obj : gameObjects) {
            obj.update();
        }
        repaint(); // Request a repaint to update the view
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            // Code to handle the space key press
        }

        if (key == KeyEvent.VK_LEFT) {
            mouvementHorz = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            mouvementHorz = 1;
        }

        if (key == KeyEvent.VK_UP) {
            mouvementVert = 1;
        }

        if (key == KeyEvent.VK_DOWN) {
            mouvementVert = -1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            mouvementHorz = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            mouvementVert = 0;
        }
    }
}
