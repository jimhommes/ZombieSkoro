package model;

import controller.MainScreenController;

import java.util.Observable;

/**
 * Created by Jim on 4/9/2016.
 *
 * @author Jim
 * @version 1.0
 * @since 4/9/2016
 */
public class Player extends Observable {

    int x_coord;
    int y_coord;

    public Player(MainScreenController msc) {
        this.x_coord = 10;
        this.y_coord = 10;
        addObserver(msc);
        notifyObservers();
    }

}
