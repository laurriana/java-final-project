package org.example.dans_la_jungle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    // labels
    @FXML
    private Label lionCount;
    @FXML
    private Label antilopeCount;
    @FXML
    private Label grassValue;

    @FXML
    private Label newbornLions;
    @FXML
    private Label newbornAntilopes;

    @FXML
    private Label currentYear;
    @FXML
    private Button startBtn;
    @FXML
    private Button slayBtn;

    // inputs
    @FXML
    private TextField lionBirthrate;
    @FXML
    private TextField antilopeBirthrate;
    @FXML
    private TextField grassBirthrate;

    // world instance (not sure about this either)
    private World world;

    @FXML
    public void initialize() {
        // disable the slay button
        slayBtn.setDisable(true);
    }


    @FXML
    protected void onYearBtnClick() {
        world.incrementYear();
        currentYear.setText(String.valueOf(world.getYear()));
    }

    @FXML
    protected void onResetBtnClick() {
        // clear the animals
        world.reset();
        currentYear.setText(String.valueOf(world.getYear()));

        startBtn.setDisable(false);
        lionBirthrate.setDisable(false);
        antilopeBirthrate.setDisable(false);
        grassBirthrate.setDisable(false);
    }

    @FXML
    protected void onStartBtnClick() {
        startBtn.setDisable(true);
        lionBirthrate.setDisable(true);
        antilopeBirthrate.setDisable(true);
        grassBirthrate.setDisable(true);

        // à revoir au cas où the user doesn't input a number
        int lionBirthRateValue = Integer.parseInt(lionBirthrate.getText());
        int antilopeBirthRateValue = Integer.parseInt(antilopeBirthrate.getText());
        int grassBirthRateValue = Integer.parseInt(grassBirthrate.getText());

        // nouvelle instance de monde
        world = new World(grassBirthRateValue);

        world.addAnimal(new Lion(), lionBirthRateValue);
        world.addAnimal(new Antilope(), antilopeBirthRateValue);

        // change the labels
        lionCount.setText(String.valueOf(lionBirthRateValue));
        antilopeCount.setText(String.valueOf(antilopeBirthRateValue));
        grassValue.setText(String.valueOf(grassBirthRateValue));

        // empty inputs
        lionBirthrate.setText("");
        antilopeBirthrate.setText("");
        grassBirthrate.setText("");

        slayBtn.setDisable(false);
    }
}