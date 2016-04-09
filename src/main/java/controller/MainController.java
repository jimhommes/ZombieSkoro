package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        players = new ArrayList<>();
        msc = new MainScreenController(root);
        players.add(new Player(msc));
    }
}
