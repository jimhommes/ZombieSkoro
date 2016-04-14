package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.KeyboardInput;
import model.MouseInput;
import model.Player;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Jim on 4/9/2016.
 *
 * @author Jim
 * @version 1.0
 * @since 4/9/2016
 */
public class MainController implements Initializable {

    public AnchorPane root;
    public ArrayList<Player> players;
    public MainScreenController msc;
    public VBox clickToStart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        players = new ArrayList<>();
        msc = new MainScreenController(root);
        KeyboardInput keyboardInput = new KeyboardInput(this);
        MouseInput mouseInput = new MouseInput(this);
        players.add(new Player(msc, keyboardInput, mouseInput));

        clickToStart.setOnMouseClicked(event -> {
            clickToStart.visibleProperty().setValue(false);
            keyboardInput.addListeners();
            mouseInput.addListeners();
        });
    }

    public void addKeyListeners(EventType<KeyEvent> event, EventHandler<KeyEvent> eventHandler) {
        root.getScene().addEventFilter(event, eventHandler);
    }

    public void addMouseListeners(EventType<MouseEvent> event, EventHandler<MouseEvent> eventHandler) {
        root.getScene().addEventFilter(event, eventHandler);
    }
}
