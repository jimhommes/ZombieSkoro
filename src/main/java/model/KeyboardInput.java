package model;

import controller.MainController;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utility.Settings;

import java.awt.*;
import java.util.BitSet;

/**
 * Created by Jim on 4/9/2016.
 *
 * @author Jim
 * @version 1.0
 * @since 4/9/2016
 */
public class KeyboardInput {

    // -------------------------------------------------
    // default key codes
    // will vary when you let the user customize the key codes
    // or when you add support for a 2nd player
    // -------------------------------------------------
    private BitSet keyboardBitSet = new BitSet();

    public static final KeyCode PRIMARY_WEAPON_KEY = Settings
            .getKeyCode("PRIMARY_WEAPON_KEY", KeyCode.SPACE);
    public static final KeyCode SECONDARY_WEAPON_KEY = Settings
            .getKeyCode("SECONDARY_WEAPON_KEY", KeyCode.CONTROL);
    public static final KeyCode W_KEY = Settings.getKeyCode("W_KEY", KeyCode.W);
    public static final KeyCode A_KEY = Settings.getKeyCode("A_KEY", KeyCode.A);
    public static final KeyCode S_KEY = Settings.getKeyCode("S_KEY", KeyCode.S);
    public static final KeyCode D_KEY = Settings.getKeyCode("D_KEY", KeyCode.D);
    public static final KeyCode SHIFT_KEY = Settings.getKeyCode("SHIFT_KEY", KeyCode.SHIFT);

    /**
     * "Key Pressed" handler for all keyboardInput events: register pressed key in the bitset.
     */
    private EventHandler<KeyEvent> keyPressedEventHandler = event -> {

        // register key down
        keyboardBitSet.set(event.getCode().ordinal(), true);


    };
    /**
     * "Key Released" handler for all keyboardInput events: unregister released key in the bitset.
     */
    private EventHandler<KeyEvent> keyReleasedEventHandler = event -> {

        // register key up
        keyboardBitSet.set(event.getCode().ordinal(), false);

    };

    private MainController mainController;

    /**
     * The constructor. This only appoints the scene the player moves in.
     *
     * @param mainController The MainController the player moves in.
     */
    public KeyboardInput(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * This function adds the listeners for the keys.
     */
    public void addListeners() {

        mainController.addKeyListeners(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        mainController.addKeyListeners(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);

    }

    // -------------------------------------------------
    // Evaluate bitset of pressed keys and return the player keyboardInput.
    // If direction and its opposite direction are pressed simultaneously,
    // then the direction isn't handled.
    // -------------------------------------------------

    /**
     * This is the boolean to check if the player moves up or not.
     *
     * @return True if the up key is pressed.
     */
    public boolean isMoveUp() {
        return keyboardBitSet.get(W_KEY.ordinal()) && !keyboardBitSet.get(S_KEY.ordinal());
    }

    /**
     * This is the boolean to check if the player moves down or not.
     *
     * @return True if the down key is pressed.
     */
    public boolean isMoveDown() {
        return keyboardBitSet.get(S_KEY.ordinal()) && !keyboardBitSet.get(W_KEY.ordinal());
    }

    /**
     * This is the boolean to check if the player moves left or not.
     *
     * @return True if the left key is pressed.
     */
    public boolean isMoveLeft() {
        return keyboardBitSet.get(A_KEY.ordinal())
                && !keyboardBitSet.get(D_KEY.ordinal());
    }


    /**
     * This is the boolean to check if the player moves right or not.
     *
     * @return True if the right key is pressed.
     */
    public boolean isMoveRight() {
        return keyboardBitSet.get(D_KEY.ordinal())
                && !keyboardBitSet.get(A_KEY.ordinal());
    }

    /**
     * This is the boolean to check if the player fires or not.
     *
     * @return True if the space key is pressed.
     */
    public boolean isFirePrimaryWeapon() {
        return keyboardBitSet.get(PRIMARY_WEAPON_KEY.ordinal());
    }


    /**
     * This is the boolean to check if the player fires his secondary or not.
     *
     * @return True if the control key is pressed.
     */
    public boolean isFireSecondaryWeapon() {
        return keyboardBitSet.get(SECONDARY_WEAPON_KEY.ordinal());
    }

    /**
     * This method sets the keyboardbitset.
     *
     * @param keyboardBitSet the BitSet that is being set.
     */
    public void setKeyboardBitSet(BitSet keyboardBitSet) {
        this.keyboardBitSet = keyboardBitSet;
    }

    /**
     * This returns the keyPressedEventHandler.
     *
     * @return The KeyPressedEventHandler.
     */
    public EventHandler<KeyEvent> getKeyPressedEventHandler() {
        return keyPressedEventHandler;
    }

    /**
     * This returns the keyReleasedEventHandler.
     *
     * @return The KeyReleasedEventHandler.
     */
    public EventHandler<KeyEvent> getKeyReleasedEventHandler() {
        return keyReleasedEventHandler;
    }

    public int getMouseLocation(int x, int y) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        return 0;
    }
}