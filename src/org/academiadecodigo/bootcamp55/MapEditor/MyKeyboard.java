package org.academiadecodigo.bootcamp55.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private int[] keys;
    private MapEditor mapEditor;

    public MyKeyboard(MapEditor mapEditor){
        keyboard = new Keyboard(this);
        this.mapEditor = mapEditor;
        init();
    }

    public void init() {
        keys = new int[] {
                KeyboardEvent.KEY_UP,
                KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_LEFT,
                KeyboardEvent.KEY_RIGHT,
                KeyboardEvent.KEY_SPACE,
                KeyboardEvent.KEY_C,
                KeyboardEvent.KEY_S,
                KeyboardEvent.KEY_L,
        };

        for(int i=0; i<keys.length; i++) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKey(keys[i]);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }

        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event);
    }

    @Override
    public void keyPressed(KeyboardEvent event) {
        switch(event.getKey()){
            case KeyboardEvent.KEY_RIGHT:
                mapEditor.movePlayer(Player.Direction.RIGHT);
               break;
            case KeyboardEvent.KEY_LEFT:
                mapEditor.movePlayer(Player.Direction.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                mapEditor.movePlayer(Player.Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                mapEditor.movePlayer(Player.Direction.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                mapEditor.setPainting(true);
                mapEditor.paintCell();
                break;
            case KeyboardEvent.KEY_C:
                mapEditor.clear();
                break;
            case KeyboardEvent.KEY_S:
                mapEditor.save();
                break;
            case KeyboardEvent.KEY_L:
                mapEditor.load();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        if(e.getKey() == KeyboardEvent.KEY_SPACE){
            mapEditor.setPainting(false);
        }
    }
}
