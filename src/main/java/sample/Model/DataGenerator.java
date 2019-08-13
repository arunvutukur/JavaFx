package sample.Model;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.io.File;
import java.io.IOException;

public class DataGenerator {

    /*public static void main() {
        File file = new File("firstexcel.xls");
        if (!file.exists()) {
            try {
                create();
                excelWritingwriting();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }
        }
        try {
            excelWritingwriting();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }*/
        private static void create() throws IOException, WriteException {

            WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("firstexcel.xls"));
            writableWorkbook.createSheet("firstexcel.xls",0);
            writableWorkbook.write();
            writableWorkbook.close();
        }

        public static WritableWorkbook excelWritingPath(String ExistingFilePath,String NewPath) throws WriteException, IOException, BiffException {

            Workbook aWorkBook = Workbook.getWorkbook(new File(ExistingFilePath));
            WritableWorkbook aCopy = Workbook.createWorkbook(new File(NewPath), aWorkBook);
        //WritableSheet aCopySheet = aCopy.getSheet(0);
        //Label anotherWritableCell = new Label(0,3,"Torab");
        //aCopySheet.addCell(anotherWritableCell);
            return aCopy;
    }

        public static void writeData(WritableWorkbook Copy,int Row, int Column,String data) throws WriteException, IOException {

            WritableSheet aCopySheet = Copy.getSheet(0);
            Label anotherWritableCell = new Label(Column,Row,data);
            aCopySheet.addCell(anotherWritableCell);
            Copy.write();
            Copy.close();
        }

}
