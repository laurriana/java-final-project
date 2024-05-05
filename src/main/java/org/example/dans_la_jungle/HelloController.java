package org.example.dans_la_jungle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label lionCount;
    @FXML
    private Label antilopeCount;
    @FXML
    private Label grassValue;
    @FXML
    private Label deathValue;
    @FXML
    private Label errMsg;
    @FXML
    private Label grassErr;


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

    @FXML
    private TextField lionBirthrate;
    @FXML
    private TextField antilopeBirthrate;
    @FXML
    private TextField grassBirthrate;

    private World world;


    // méthodes utiles
    protected void refresh() {
        currentYear.setText(String.valueOf(world.getYear()));
        lionCount.setText(String.valueOf(world.getLionCount()));
        antilopeCount.setText(String.valueOf(world.getAntilopeCount()));
        deathValue.setText(String.valueOf(world.getAnimauxMorts()));
        grassValue.setText(String.valueOf(world.getHerbe()));

        newbornLions.setText(String.valueOf(world.getNewbornLions()));
        newbornAntilopes.setText(String.valueOf(world.getNewbornAntilopes()));
    }

    protected void disable(boolean lightSwitch) {
        startBtn.setDisable(lightSwitch);
        lionBirthrate.setDisable(lightSwitch);
        antilopeBirthrate.setDisable(lightSwitch);
        grassBirthrate.setDisable(lightSwitch);
        slayBtn.setDisable(!lightSwitch);
    }

    @FXML
    public void initialize() {
        slayBtn.setDisable(true);
        errMsg.setVisible(false);
        grassErr.setVisible(false);
    }

    @FXML
    protected void onStartBtnClick() {
        if (lionBirthrate.getText().isEmpty() || antilopeBirthrate.getText().isEmpty() || grassBirthrate.getText().isEmpty()) {
            errMsg.setVisible(true);
        } else if (Integer.parseInt(grassBirthrate.getText()) < Integer.parseInt(antilopeBirthrate.getText()) * 100) {
            grassErr.setVisible(true);
        } else {
            errMsg.setVisible(false);
            grassErr.setVisible(false);

            disable(true);

            // nouvelle instance de monde
            world = new World(Integer.parseInt(grassBirthrate.getText()));

            world.addAnimal("Lion", Integer.parseInt(lionBirthrate.getText()));
            world.addAnimal("Antilope", Integer.parseInt(antilopeBirthrate.getText()));

            // change the labels
            lionCount.setText(String.valueOf(Integer.parseInt(lionBirthrate.getText())));
            antilopeCount.setText(String.valueOf(Integer.parseInt(antilopeBirthrate.getText())));
            grassValue.setText(String.valueOf(Integer.parseInt(grassBirthrate.getText())));

            // empty inputs
            lionBirthrate.setText("");
            antilopeBirthrate.setText("");
            grassBirthrate.setText("");

        }
    }

    @FXML
    protected void onYearBtnClick() {
        world.incrementYear();
        refresh();
    }

    @FXML
    protected void onResetBtnClick() {
        world.reset();
        refresh();

        disable(false);
    }
}