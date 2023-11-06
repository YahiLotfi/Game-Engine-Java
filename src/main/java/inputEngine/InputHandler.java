package inputEngine;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

public class InputHandler {
    HashMap<Integer, Runnable> inputMappings = new HashMap<Integer, Runnable>();
    public EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {

            inputMappings.get(event.getCode().getCode()).run();
        }
    };
    public void addMapping(int event , Runnable action){
        inputMappings.put(event,action);
    }
}
