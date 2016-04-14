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

    KeyboardInput keyboardInput;
    MouseInput mouseInput;

    double x_coord;
    double y_coord;
    double r_coord;

    int spriteBottomID;
    int spritePistolID;
    int spriteSMGID;
    int spriteBazookaID;
    int spriteSniperID;
    boolean walking;

    int equipped;

    double mostRecentMouseX;
    double mostRecentMouseY;

    AnimationTimer timer;

    public Player(MainScreenController msc, KeyboardInput keyboardInput, MouseInput mouseInput) {
        this.x_coord = 10;
        this.y_coord = 10;
        this.r_coord = 0;
        this.keyboardInput = keyboardInput;
        this.mouseInput = mouseInput;
        this.walking = false;
        this.equipped = Settings.PLAYERPISTOL;

        this.mostRecentMouseX = 0;
        this.mostRecentMouseY = 0;

        addObserver(msc);

        spriteBottomID = msc.addImage(Settings.SPRITE_PLAYERLEGS, false, 75);
        spritePistolID = msc.addImage(Settings.SPRITE_PLAYERPISTOL, true);
        spriteSMGID = msc.addImage(Settings.SPRITE_PLAYERSMG, false);
        spriteBazookaID = msc.addImage(Settings.SPRITE_PLAYERBAZOOKA, false);
        spriteSniperID = msc.addImage(Settings.SPRITE_PLAYERSNIPER, false);

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

        if(mouseInput.getX() != mostRecentMouseX ||
                mouseInput.getY() != mostRecentMouseY) {
            mostRecentMouseX = mouseInput.getX();
            mostRecentMouseY = mouseInput.getY();

            r_coord = Math.tan(Math.abs(mostRecentMouseY - y_coord) / Math.abs(mostRecentMouseX - x_coord)) * 360;

            setChanged();
        }

        if(!(keyboardInput.isMoveLeft() || keyboardInput.isMoveRight() || keyboardInput.isMoveUp() || keyboardInput.isMoveDown())) {
            if(walking) {
                walking = false;
                setChanged();
            }
        } else {
            walking = true;
            setChanged();
            if (keyboardInput.isMoveLeft()) {
                x_coord -= Settings.PLAYERSPEED;
            }
            if (keyboardInput.isMoveRight()) {
                x_coord += Settings.PLAYERSPEED;
            }
            if (keyboardInput.isMoveUp()) {
                y_coord -= Settings.PLAYERSPEED;
            }
            if (keyboardInput.isMoveDown()) {
                y_coord += Settings.PLAYERSPEED;
            }
        }
    }

    public double getX_coord() {
        return x_coord;
    }

    public double getY_coord() {
        return y_coord;
    }

    public int getSpritePistolID() {
        return spritePistolID;
    }

    public int getSpriteSMGID() {
        return spriteSMGID;
    }

    public int getSpriteBazookaID() {
        return spriteBazookaID;
    }

    public int getSpriteSniperID() {
        return spriteSniperID;
    }

    public int getSpriteBottomID() {
        return spriteBottomID;
    }

    public boolean isWalking() {
        return walking;
    }

    public int getEquipped() {
        return equipped;
    }

    public double getR_coord() {
        return r_coord;
    }
}
