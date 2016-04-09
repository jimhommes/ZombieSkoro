package controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jim on 4/7/2016.
 *
 * @author Jim
 * @version 1.0
 * @since 4/7/2016
 */
public class StartscreenController implements Initializable {

    public AnchorPane root;
    public Button startButton;
    public ImageView logo;
    public Button helpButton;
    public Button highscoresButton;
    public Button exitButton;
    public VBox highscoreOverlay;
    public VBox instructionsOverlay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addEvents();

    }

    private void addEvents() {
        //StartButton -> starts game
        startButton.setOnAction(event -> {
            Stage stage = (Stage) root.getScene().getWindow();
            Parent newRoot;
            try {
                newRoot = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
                stage.setScene(new Scene(newRoot, 800, 600));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //Instructions -> overlay with instructions
        helpButton.setOnAction(event -> instructionsOverlay.setVisible(true));
        instructionsOverlay.setOnMouseClicked(event -> instructionsOverlay.setVisible(false));

        //Highscores -> overlay with highscores
        highscoresButton.setOnAction(event -> highscoreOverlay.setVisible(!highscoreOverlay.isVisible()));
        root.setOnMouseClicked(event -> {
            highscoreOverlay.setVisible(false);
            instructionsOverlay.setVisible(false);
        });
        highscoreOverlay.setOnMouseClicked(event -> highscoreOverlay.setVisible(false));

        exitButton.setOnAction(event -> {
            System.exit(0);
        });
    }

}
