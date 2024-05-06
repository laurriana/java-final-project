package org.example.dans_la_jungle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Simulator extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Simulator.class.getResource("hello-simulator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 465);
        stage.setTitle("SURVIVAL OF THE FITTEST");
stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/makkachin.png")))); // icon for fun
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}