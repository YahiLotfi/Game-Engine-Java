package inputEngineTest;

import inputEngine.InputHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    @Test
    void testAddMappingAndHandleEvent() {
        InputHandler inputHandler = new InputHandler();

        // Action for testing
        boolean[] actionExecuted = { false };

        // Add mapping for the 'A' key (KeyCode.A code is 65)
        inputHandler.addMapping(65, () -> actionExecuted[0] = true);

        // Create a KeyEvent for the 'A' key press
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "A", "A", KeyCode.A, false, false, false, false);

        // Handle the event
        inputHandler.eventHandler.handle(keyEvent);

        // Verify that the action was executed
        assertTrue(actionExecuted[0]);
    }

    @Test
    void testAddMappingAndHandleEvent_NotMapped() {
        InputHandler inputHandler = new InputHandler();

        // Action for testing
        boolean[] actionExecuted = { false };

        // Add mapping for the 'B' key (KeyCode.B code is 66)
        inputHandler.addMapping(66, () -> actionExecuted[0] = true);

        // Create a KeyEvent for the 'B' key press
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "B", "B", KeyCode.B, false, false, false, false);

        // Handle the event
        inputHandler.eventHandler.handle(keyEvent);

        // Verify that the action was executed
        assertTrue(actionExecuted[0]);
    }


    @Test
    void testAddMapping_DuplicateKey() {
        InputHandler inputHandler = new InputHandler();

        // Actions for testing
        boolean[] action1Executed = { false };
        boolean[] action2Executed = { false };

        // Add mappings for the 'A' key (KeyCode.A code is 65)
        inputHandler.addMapping(65, () -> action1Executed[0] = true);

        // Add a duplicate mapping for the 'A' key
        inputHandler.addMapping(65, () -> action2Executed[0] = true);

        // Create a KeyEvent for the 'A' key press
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "A", "A", KeyCode.A, false, false, false, false);

        // Handle the event
        inputHandler.eventHandler.handle(keyEvent);

        // Verify that only the second action was executed
        assertFalse(action1Executed[0]);
        assertTrue(action2Executed[0]);
    }
}
