package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Player;

import java.util.ArrayList;
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
    private ArrayList<ImageView> images;

    public MainScreenController(Pane playfield) {
        this.playfield = playfield;
        this.images = new ArrayList<>();
    }

    public int addImage(String path, boolean visible) {
        ImageView imageView = new ImageView(
                new Image(getClass()
                .getClassLoader()
                .getResource(path).toExternalForm())
        );

        imageView.setVisible(visible);
        playfield.getChildren().add(imageView);
        images.add(imageView);
        return images.size() - 1;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Player) {
            updatePlayer((Player) o);
        }
    }

    private void updatePlayer(Player player) {
        images.get(player.getSpriteBottomID())
                .setVisible(player.isWalking());

        images.get(player.getSpriteBottomID())
                .relocate(player.getX_coord(), player.getY_coord());

        images.get(player.getSpriteTopID())
                .relocate(player.getX_coord(), player.getY_coord());
    }
}
