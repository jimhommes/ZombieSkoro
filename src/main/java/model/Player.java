package model;

import controller.MainScreenController;
import javafx.animation.AnimationTimer;
import utility.Settings;

import java.util.Observable;

/**
 * Created by Jim on 4/9/2016.
 *
 * @author Jim
 * @version 1.0
 * @since 4/9/2016
 */
public class Player extends Observable {

    Input input;

    int x_coord;
    int y_coord;

    int spriteTopID;
    int spriteBottomID;
    boolean walking;

    AnimationTimer timer;

    public Player(MainScreenController msc, Input input) {
        this.x_coord = 10;
        this.y_coord = 10;
        this.input = input;
        this.walking = false;

        addObserver(msc);

        spriteBottomID = msc.addImage(Settings.PLAYERLEGS, false);
        spriteTopID = msc.addImage(Settings.PLAYERTOP, true);

        timer = createTimer();
        timer.start();
    }

    private AnimationTimer createTimer() {
        return new AnimationTimer(){
            @Override
            public void handle(long now) {
                move();
                notifyObservers();
            }
        };
    }

    private void move() {
        if(!(input.isMoveLeft() || input.isMoveRight() || input.isMoveUp() || input.isMoveDown())) {
            if(walking) {
                walking = false;
                setChanged();
            }
        } else {
            walking = true;
            setChanged();
            if (input.isMoveLeft()) {
                x_coord -= Settings.PLAYERSPEED;
            }
            if (input.isMoveRight()) {
                x_coord += Settings.PLAYERSPEED;
            }
            if (input.isMoveUp()) {
                y_coord -= Settings.PLAYERSPEED;
            }
            if (input.isMoveDown()) {
                y_coord += Settings.PLAYERSPEED;
            }
        }
    }

    public int getX_coord() {
        return x_coord;
    }

    public int getY_coord() {
        return y_coord;
    }

    public int getSpriteTopID() {

        return spriteTopID;
    }

    public int getSpriteBottomID() {
        return spriteBottomID;
    }

    public boolean isWalking() {
        return walking;
    }
}
