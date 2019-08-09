package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class Controller {

    @FXML
    private Label message;

    @FXML
    private Button ok;

    public void generateRandom(ActionEvent event){
        Random rand = new Random();
        int myrand = rand.nextInt(50)+1;
        System.out.println(Integer.toString(myrand));
        message.setText(Integer.toString(myrand));
    }
}
