package model;

import controller.MainController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


/**
 * Created by Jim on 4/14/2016.
 *
 * @author Jim
 * @version 1.0
 * @since 4/14/2016
 */
public class MouseInput {

    double x_coord;
    double y_coord;
    boolean changed;
    MainController mc;

    public MouseInput(MainController mc) {
        this.x_coord = 0;
        this.y_coord = 0;
        this.mc = mc;
    }

    public void addListeners() {
        mc.addMouseListeners(MouseEvent.MOUSE_MOVED, mouseMovedHandler);
    }

    private EventHandler<MouseEvent> mouseMovedHandler = event -> {

        x_coord = event.getX();
        y_coord = event.getY();

    };

    public double getY() {
        return y_coord;
    }

    public double getX() {
        return x_coord;
    }
}
