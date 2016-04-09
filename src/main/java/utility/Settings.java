package utility;

import javafx.scene.input.KeyCode;

import java.util.Properties;

/**
 * Created by Jim on 4/9/2016.
 *
 * @author Jim
 * @version 1.0
 * @since 4/9/2016
 */
public class Settings {

    public static final int PLAYERSPEED = 10;
    public static int HEIGHT = 800;
    public static int WIDTH = 600;

    public static String PLAYERLEGS = "sprites/Character/CharacterAnim/Poging2/Anim2.gif";
    public static String PLAYERTOP = "sprites/Character/Torsos/Sprites/Torso.png";

    private static Properties properties;

    /**
     * Initialize the properties.
     * @return true is file existed, false if not.
     */
    public static boolean initialize() {
        properties = new Properties();
        return true;
    }


    /**
     * Get a specific value.
     * @param key the key of the property.
     * @return the value of the property.
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Get a specific value.
     * @param key the key of the property.
     * @param def the default value.
     * @return the default value if the property does not exist, the property value otherwise.
     */
    public static String get(String key, String def) {
        String value = Settings.get(key);
        if (null != value) {
            return value;
        } else {
            Settings.set(key, def);
            return def;
        }
    }

    /**
     * Get a KeyCode property.
     * @param key the key of the property.
     * @param def the default value.
     * @return the default value if the property does not exist, the property value otherwise.
     */
    public static KeyCode getKeyCode(String key, KeyCode def) {
        return KeyCode.valueOf(get(key, def.toString()));
    }


    /**
     * Set a property.
     * @param key the key of the property.
     * @param value the value of the property.
     */
    public static void set(String key, String value) {
        properties.setProperty(key, value);
    }

}
