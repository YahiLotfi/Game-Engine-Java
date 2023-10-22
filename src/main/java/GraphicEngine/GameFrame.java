package GraphicEngine;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame {

    private SpaceGraphic spaceGraphic;

    public GameFrame() {
        spaceGraphic = new SpaceGraphic();
        add(spaceGraphic);

        // Add a KeyListener to your SpaceGraphic to handle keyboard input
        spaceGraphic.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Implement your keyTyped logic here if needed
            }

            @Override
            public void keyPressed(KeyEvent e) {
                spaceGraphic.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                spaceGraphic.keyReleased(e);
            }
        });

        spaceGraphic.setFocusable(true);
        spaceGraphic.requestFocusInWindow(); // Make sure your SpaceGraphic has focus

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Your Game Title");
        setSize(800, 600); // Set the frame size
        setLocationRelativeTo(null); // Center the frame
        setResizable(false); // You can set it to true if you want it to be resizable

        // Other initialization code here, e.g., adding game objects to spaceGraphic

        setVisible(true);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        // Start your game loop or update method to continuously call spaceGraphic.move() for animation
        // Example: while (true) { spaceGraphic.move(); }
    }
}
