/**
 * Created by Jim on 4/2/2016.
 *
 * @author Jim
 * @version 1.0
 * @since 4/2/2016
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.Settings;

import java.io.IOException;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("startscreen.fxml"));
        primaryStage.setTitle("ZombieSkoro");
        primaryStage.setScene(new Scene(root, Settings.WIDTH, Settings.HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
