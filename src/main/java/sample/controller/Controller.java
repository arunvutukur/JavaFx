package sample.controller;

import Utilities.CustomException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Random;

public class Controller {

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

    private Boolean fileselected;

    private String fileName;

    @FXML
    private Label resourceStatus;


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
                fileName=selectedFile.toString();
                System.out.println("The absoulte path in file status is " + fileName);
                //filestatus.setText(selectedFile.toString());
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

    public void writeData(ActionEvent event) throws CustomException, IOException, InvalidFormatException {

        if(fileselected==true){
            System.out.println("Executing the below operation");
            //Get the file from the file chooser dialog
            String targetPath = fileName;
            targetPath=targetPath.replaceAll("\'","");
            System.out.println("The targetPath is " +targetPath);
            //String filename="";
            try {
                File excelFilePath = new File(targetPath);
                System.out.println("The excel file path is" +excelFilePath);
                FileInputStream inputStream = new FileInputStream(new File(String.valueOf(excelFilePath)));
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(0);
                System.out.println("Execute 2 below commands");

                Object[][] bookData = {
                        {"The Passionate Programmer", "Chad Fowler", 16},
                        {"Software Craftmanship", "Pete McBreen", 26},
                        {"The Art of Agile Development", "James Shore", 32},
                        {"Continuous Delivery", "Jez Humble", 41},
                };
                int rowCount = sheet.getLastRowNum();
                for (Object[] aBook : bookData) {

                    Row row = sheet.createRow(++rowCount);
                    int columnCount = 0;
                    Cell cell = row.createCell(columnCount);
                    cell.setCellValue(rowCount);

                    for (Object field : aBook) {
                        cell = row.createCell(++columnCount);
                        if (field instanceof String) {
                            cell.setCellValue((String) field);
                        } else if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        }
                    }
                }
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream("Demo.xlsx");
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

            } catch (Exception e) {
                System.out.println("File not Found");
                e.printStackTrace();
            }
        }else{
            throw new CustomException("File not selected");
        }
    }
}
