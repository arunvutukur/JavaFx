package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Random;

public class Controller {

    @FXML
    private Label message;

    @FXML
    private Button ok;

    @FXML
    private MenuItem menuitem;

    @FXML
    private Menu menu;

    @FXML
    private Label filestatus;

    private Boolean fileselected;

    public void generateRandom(ActionEvent event){
        Random rand = new Random();
        int myrand = rand.nextInt(50)+1;
        System.out.println(Integer.toString(myrand));
        message.setText(Integer.toString(myrand));
    }

    public void getFile(ActionEvent event){

        FileChooser fileChooser =new FileChooser();
        File selectedFile= fileChooser.showOpenDialog(null);
        try {
            if (selectedFile != null) {
                System.out.println(selectedFile);
                filestatus.setText(selectedFile.toString());
                fileselected = true;
            } else {
                System.out.println("ERROR EXCEPTION");
            }
            System.out.println(menu);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeData(ActionEvent event){
        if(fileselected==true){

            System.out.println("Executing the below operation");


        }else{
            System.out.println("Cant execute this operation");

        }


    }
}
