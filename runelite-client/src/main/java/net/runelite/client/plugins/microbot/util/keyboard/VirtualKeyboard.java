package net.runelite.client.plugins.microbot.util.keyboard;

import net.runelite.client.plugins.microbot.Microbot;
import net.runelite.client.plugins.microbot.util.Global;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.CHAR_UNDEFINED;
import static net.runelite.client.plugins.microbot.util.math.Random.random;

public class VirtualKeyboard {

    public static Canvas getCanvas() {
        return Microbot.getClient().getCanvas();
    }

    public static void typeString(final String word) {
       /* if (!getCanvas().hasFocus())
            getCanvas().requestFocus();*/

        for (int i = 0; i < word.length(); i++) {
            final int randomizer = random(20, 200);

            KeyEvent keyEvent = new KeyEvent(getCanvas(), KeyEvent.KEY_TYPED, System.currentTimeMillis() + randomizer, 0, KeyEvent.VK_UNDEFINED, word.charAt(i));

            Microbot.getEventHandler().dispatchUnblockedEvent(keyEvent);
            Global.sleep(100, 200);
        }

    }


    public static void keyPress(final char key) {
      /*  if (!getCanvas().hasFocus())
            getCanvas().requestFocus();*/

        final int randomizer = random(20, 200);

        KeyEvent keyEvent = new KeyEvent(getCanvas(), KeyEvent.KEY_TYPED, System.currentTimeMillis() + randomizer, 0, KeyEvent.VK_UNDEFINED, key);

        Microbot.getEventHandler().dispatchUnblockedEvent(keyEvent);
    }

    public static void holdShift() {
       /* if (!getCanvas().hasFocus())
            getCanvas().requestFocus();*/

        final int randomizer = random(20, 200);

        KeyEvent keyEvent = new KeyEvent(getCanvas(), KeyEvent.KEY_PRESSED, System.currentTimeMillis() + randomizer, 0, KeyEvent.VK_SHIFT, CHAR_UNDEFINED);

        Microbot.getEventHandler().dispatchUnblockedEvent(keyEvent);
    }

    public static void releaseShift() {
        /*if (!getCanvas().hasFocus())
            getCanvas().requestFocus();
*/
        final int randomizer = random(20, 200);

        KeyEvent keyEvent = new KeyEvent(getCanvas(), KeyEvent.KEY_RELEASED, System.currentTimeMillis() + randomizer, 0, KeyEvent.VK_SHIFT);

        Microbot.getEventHandler().dispatchUnblockedEvent(keyEvent);
    }

    public static void keyHold(int key) {
        /*if (!getCanvas().hasFocus())
            getCanvas().requestFocus();*/

        KeyEvent keyEvent = new KeyEvent(getCanvas(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, key);

        Microbot.getEventHandler().dispatchUnblockedEvent(keyEvent);
    }

    public static void keyRelease(int key) {
       /* if (!getCanvas().hasFocus())
            getCanvas().requestFocus();*/

        KeyEvent keyEvent = new KeyEvent(getCanvas(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, key);

        Microbot.getEventHandler().dispatchUnblockedEvent(keyEvent);
    }

    public static void keyPress(int key) {
       /* if (!getCanvas().hasFocus())
            getCanvas().requestFocus();*/

        keyHold(key);
        keyRelease(key);
    }

    public static void enter() {
        /*if (!getCanvas().hasFocus())
            getCanvas().requestFocus();*/

        keyHold(KeyEvent.VK_ENTER);
        keyRelease(KeyEvent.VK_ENTER);
    }

    private static final Map<Integer, Boolean> pressedKeys = new HashMap<>();

    static {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(event -> {
            synchronized (VirtualKeyboard.class) {
                if (event.getID() == KeyEvent.KEY_PRESSED) pressedKeys.put(event.getKeyCode(), true);
                else if (event.getID() == KeyEvent.KEY_RELEASED) pressedKeys.put(event.getKeyCode(), false);
                return false;
            }
        });
    }

    public static boolean isKeyPressed(int keyCode) { // Any key code from the KeyEvent class
        return pressedKeys.getOrDefault(keyCode, false);
    }
}
