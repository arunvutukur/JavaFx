package sample.Model;

import Utilities.CustomException;
import javafx.event.ActionEvent;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DataModel {

    private final int StartingCell=2;
    private final int SheetNo=0;
    private final int RowNo=1;
    private int Label_Starting=3;
    private String Filename_Output=null;
    private String ResultLocation ="D:/Dummy/"+Filename_Output;

    public void appendSingleExcel(Boolean fileselected,String fileName)  {

        if (fileselected == true) {
            System.out.println("Executing the below operation");
            //Get the file from the file chooser dialog
            String targetPath = fileName;
            targetPath = targetPath.replaceAll("\'", "");
            System.out.println("The targetPath is " + targetPath);
            //String filename="";
            try {
                File excelFilePath = new File(targetPath);
                System.out.println("The excel file path is" + excelFilePath);
                FileInputStream inputStream = new FileInputStream(new File(String.valueOf(excelFilePath)));
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(SheetNo);
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
        } else {

        }

    }

    public void writeData(String fileName, LinkedList<String> label, File file) throws CustomException, IOException, InvalidFormatException {

            final String targetPath=fileName.replaceAll("\'","");
            System.out.println("The targetPath is ---->" +targetPath);
            Filename_Output=file.getName();
            try {
                File excelFilePath = new File(targetPath);
                FileInputStream inputStream = new FileInputStream(new File(String.valueOf(excelFilePath)));
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(SheetNo);
                System.out.println("Executing Excel operations");
                Row row = sheet.getRow(RowNo);
                System.out.println("The value of the cell is --> " +row.getCell(0));
                System.out.println("The last row number is" +sheet.getLastRowNum());
                // System.out.println("Total number of cells is " +row.getPhysicalNumberOfCells() +"first cell num" +row.getFirstCellNum());
                //Cell cell = row.createCell(Label_Starting);
                //cell.setCellValue("Date");
                //cell = row.createCell(4);
                //cell.setCellValue("Logged in User");
                //cell = row.createCell(5);
                //cell.setCellValue("Amount");

                System.out.println("Label size is "+label.size());

                for(int i=Label_Starting,j=0;i<=((label.size()+Label_Starting)-1)&&j<=5;i++,j++) {
                    System.out.println("inside loop");
                    row.createCell(i).setCellValue(label.get(j));
                    System.out.println("The value inside these cells are--> " + row.getCell(i));
                    System.out.println("The i --> " +i+"  The value inside the list is " +label.get(j));
                }
                    /*for (Object field : aBook) {
                        cell = row.createCell(++columnCount);
                        if (field instanceof String) {
                            cell.setCellValue((String) field);
                        } else if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        }
                    }*/
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(ResultLocation);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void compareAndAddData(File file1, File file2){

        final String targetPath1=file1.toString().replaceAll("\'","");
        final String targetPath2=file2.toString().replaceAll("\'","");
        System.out.println("Comparing the files");
        System.out.println("The targetPath is ----> " +targetPath1+" ...The target path for the second file is ----> " +targetPath2);
        String Result_Filename_Output=file2.getName();
        try {
            File excelFilePath1= new File(targetPath1);
            File excelFilePath2= new File(targetPath2);
            FileInputStream inputStream1 = new FileInputStream(new File(String.valueOf(excelFilePath1)));
            FileInputStream inputStream2 = new FileInputStream(new File(String.valueOf(excelFilePath1)));
            Workbook workbook1 = WorkbookFactory.create(inputStream1);
            Workbook workbook2= WorkbookFactory.create(inputStream2);
            Sheet sheet1 = workbook1.getSheetAt(SheetNo);
            Sheet sheet2 = workbook2.getSheetAt(SheetNo);
            System.out.println("Executing Excel operations");
            Row row1 = sheet1.getRow(RowNo);
            Row row2 = sheet2.getRow(RowNo);

            System.out.println("The value of the cell is --> " +row1.getCell(0));
            System.out.println("The value of the cell is --> " +row2.getCell(0));
            System.out.println("The last row number is" +sheet1.getLastRowNum());
            // System.out.println("Total number of cells is " +row.getPhysicalNumberOfCells() +"first cell num" +row.getFirstCellNum());
            //Cell cell = row.createCell(Label_Starting);
            //cell.setCellValue("Date");
            //cell = row.createCell(4);
            //cell.setCellValue("Logged in User");
            //cell = row.createCell(5);
            //cell.setCellValue("Amount");
            /*for(int i=Label_Starting,j=0;i<=((label.size()+Label_Starting)-1)&&j<=5;i++,j++) {
                System.out.println("inside loop");
                row.createCell(i).setCellValue(label.get(j));
                System.out.println("The value inside these cells are--> " + row.getCell(i));
                System.out.println("The i --> " +i+"  The value inside the list is " +label.get(j));
            }*/
                    /*for (Object field : aBook) {
                        cell = row.createCell(++columnCount);
                        if (field instanceof String) {
                            cell.setCellValue((String) field);
                        } else if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        }
                    }*/
            inputStream1.close();
            inputStream2.close();
            //FileOutputStream outputStream = new FileOutputStream(ResultLocation);
            //workbook.write(outputStream);
            workbook1.close();
            workbook2.close();
            //outputStream.close();
            System.out.println("OPERATION EXECUTED SUCCESSFULLY !!!");

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
