package sample.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception{
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        //scene.getStylesheets().addAll(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setTitle("JIRA_FORMAT");
        Scene scene =new Scene(root);
        //primaryStage.setScene(new Scene(root, 675, 650));
        primaryStage.setScene(scene);

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
