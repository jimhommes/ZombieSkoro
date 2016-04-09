package controller;

import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jim on 4/9/2016.
 *
 * @author Jim
 * @version 1.0
 * @since 4/9/2016
 */
public class MainScreenController implements Observer {

    private Pane playfield;

    public MainScreenController(Pane playfield) {
        this.playfield = playfield;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
