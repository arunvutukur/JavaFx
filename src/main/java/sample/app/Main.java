package sample.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        //Parent root =loader.load();
        primaryStage.setTitle("JIRA_FORMAT");
        primaryStage.setScene(new Scene(root, 675, 650));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("wow");

        //File file = new File("D:\\Java-Spring Projects\\SocialMediaApp-Scratch\\JIRA-UPLOAD\\..\\..\\sample.fxml");
        //System.out.println("Path : " + file.getAbsolutePath());
        launch(args);


        //File file = File("C:\\abcfolder\\textfile.txt");
        //System.out.println("Path : " + file.getAbsolutePath());


    }
}
