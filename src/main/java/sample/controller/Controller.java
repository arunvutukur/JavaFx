package sample.controller;

import Utilities.CustomException;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import sample.Model.DataGenerator;
import sample.Model.DataModel;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    @FXML
    private Label message;

    @FXML
    private Button ok,generate;

    @FXML
    private MenuItem menuitem;

    @FXML
    private Menu menu;

    @FXML
    private Label filestatus;

    private Boolean fileselected,fileDirSelected =false;

    private String fileName,dirName;

    @FXML
    private Label resourceStatus;

    @FXML
    private ListView listView;

    @FXML
    private ListView view;

    @FXML
    private VBox vBox1;

    @FXML
    private TextField Testlabel;

    @FXML
    private TextField Asignee;

    @FXML
    private TextField Component;

    DataGenerator datagen=new DataGenerator();
    DataModel dataModel =new DataModel();

    final LinkedList<String> list_labels = new LinkedList();

    public void generateRandom(ActionEvent event){
        Random rand = new Random();
        int myrand = rand.nextInt(50)+1;
        System.out.println(Integer.toString(myrand));
        message.setText(Integer.toString(myrand));
    }
    @FXML
    public void getFile(ActionEvent event){

        FileChooser fileChooser =new FileChooser();
        File selectedFile= fileChooser.showOpenDialog(null);

        try {
            if (selectedFile != null) {
                System.out.println(selectedFile);
                filestatus.setText(selectedFile.toString());
                fileName=selectedFile.toString();
                System.out.println("The absoulte path in file status is " + fileName);
                //filestatus.setText(selectedFile.toString());
                //Set FILE STATUS FLAG TO TRUE
                fileselected = true;
            } else {
                System.out.println("ERROR EXCEPTION");
            }
            System.out.println(menu);
        }catch (Exception e){
            e.printStackTrace();
        }
        File temp;
        String targetPath = fileName;
        //String targetPath = "D:/Test-Exceldemo/Demo.xlsx";
        //temp = File.createTempFile("myTempFile", ".txt");
        targetPath=targetPath.replaceAll("\'","");
        //targetPath=targetPath.replace("\\","/");

        try {
            System.out.println("The target file name is " +targetPath);
            File tempFile = new File(targetPath);
            System.out.println("Absoulute path is  " +tempFile.getAbsoluteFile());
            //boolean exists = tempFile.exists();
            //boolean exists = tempFile.isFile();
            boolean exists = tempFile.isFile();
            System.out.println("Temp file exists : " + exists +" If not is the file exists " +tempFile.exists());
            if(exists==true) {
                resourceStatus.setText("File Exists");
            }else {
                resourceStatus.setText("File Not Available");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void appendSingleCopyExcel(ActionEvent event) throws CustomException, IOException, InvalidFormatException {

        list_labels.add("Name");
        list_labels.add(Component.getText());
        list_labels.add("Objective");
        list_labels.add(Testlabel.getText());
        list_labels.add(Asignee.getText());


        if(fileselected==true){
            dataModel.writeData(fileName,list_labels);
        }else{
            throw new CustomException("File not selected");
        }
    }

    @FXML
    public void appendMultipleCopyExcel(ActionEvent event) throws InvalidFormatException, CustomException, IOException {

        list_labels.add("Name");
        list_labels.add(Component.getText());
        list_labels.add("Objective");
        list_labels.add(Testlabel.getText());
        list_labels.add(Asignee.getText());

        if(fileDirSelected==true){
            dataModel.writeData(fileName,list_labels);
        }else{
            throw new CustomException("File not selected");
        }


    }



    @FXML
    public void getMultipleExcelListView(ActionEvent event){

        DirectoryChooser chooser = new DirectoryChooser();
        File selectedFile= chooser.showDialog(null);

        try {
            if (selectedFile != null) {
                System.out.println(selectedFile);
                filestatus.setText(selectedFile.toString());
                dirName=selectedFile.toString();
                System.out.println("The absoulte path in file status is " + dirName);
                //filestatus.setText(selectedFile.toString());
                //File Flag is set to true
                fileDirSelected=true;
            } else {
                System.out.println("ERROR EXCEPTION");
            }
            System.out.println(menu);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            System.out.println("The target file name is " +dirName);
            File tempFile = new File(dirName);
            System.out.println("Absoulute path is  " +tempFile.getAbsolutePath());
            boolean exists = tempFile.isDirectory();
            System.out.println("Temp file directory exists : " +tempFile.exists());
            if(exists==true) {
                resourceStatus.setText("Directory Exists");
            }else {
                resourceStatus.setText("Directory Not Available");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //getAllFilesInListView(dirName);

    }

    @FXML
    public void getAllFilesInListView(URL url, ResourceBundle rn){

        String dirPath =dirName;
        LinkedList list =new LinkedList<String>();
        listView =new ListView();
        listView.setEditable(true);

        final ObservableList names =
                FXCollections.observableArrayList();
        final ObservableList data =
                FXCollections.observableArrayList();
        File dir = new File(dirPath);
        for (File file : dir.listFiles()) {
            System.out.println(file.getAbsoluteFile());
            //list.add(file);
            data.add(file);

        }
        //listView.setItems((ObservableList) list);
        //listView.getItems().addAll(list);
        listView.setItems(data);

        //listView.getItems();
    }


    public void initialize(URL location, ResourceBundle resources) {

        listView = new ListView<String>();
        view=new ListView<String>();
        //listView.setEditable(true);
        ObservableList<String> data =
                FXCollections.observableArrayList("Nothing to show");
        vBox1 = new VBox();
        listView.setItems(data);
        view.setItems(data);

        if (fileselected == true) {
            String dirPath = dirName;
            File dir = new File(dirPath);

            for (File file : dir.listFiles()) {
                System.out.println(file.getAbsoluteFile());
                //list.add(file);
                data.add(file.toString());

            }
            //listView.setItems((ObservableList) list);
            //listView.getItems().addAll(list);
            listView.getItems().addAll(data);


        }else{
            System.out.println("Here no files to show");
            //data.add("No Files to show");
            //listView.getItems().addAll(data);
            //listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            //vBox1.getChildren().add(listView);

        }
        vBox1.getChildren().add(listView);
    }
}
