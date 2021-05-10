package co.com.edestinos.vuelos.utils.read_excel.read;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static co.com.edestinos.vuelos.utils.read_excel.assign.AssignData.assignData;

public class ReadExcel implements AutoCloseable{
    private static String fileName;
    private static String sheetToRead;
    private static int headerRow;
    private static Object model;
    private static final List<Object> dataList = new ArrayList<>();
    private static Row headerDataList;

    private ReadExcel(Builder builder) {
        this.fileName = builder.fileName;
        this.model = builder.model;
        this.sheetToRead = builder.sheetToRead;
        this.headerRow = builder.headerRow;

        readExcel();
    }

    public static class Builder {

        private String fileName;
        private String sheetToRead;
        private int headerRow;
        private Object model;

        public Builder fileName(final String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder model(Object model) {
            this.model = model;
            return this;
        }

        public Builder sheetToRead(final String sheetToRead) {
            this.sheetToRead = sheetToRead;
            return this;
        }

        public Builder headerRow(final int headerRow) {
            this.headerRow = headerRow;
            return this;
        }

        public ReadExcel build() {
            return new ReadExcel(this);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public String getSheetToRead() {
        return sheetToRead;
    }

    public static int getHeaderRow() {
        return headerRow;
    }

    public Object getModel() {
        return model;
    }


    public static void readExcel() {
        String excludeTrue = "TRUE";
        int zero = 0;
        File archivo = new File(fileName);

        try (FileInputStream excelFile = new FileInputStream(archivo)) {

            XSSFWorkbook bookExcel = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = bookExcel.getSheetAt(bookExcel.getSheetIndex(sheetToRead));

            for (int rowFile = sheet.getFirstRowNum() + headerRow; rowFile <= sheet.getLastRowNum(); rowFile++) {
                if (!excludeTrue.equalsIgnoreCase(sheet.getRow(rowFile).getCell(zero).getStringCellValue())) {
                    if (rowFile == headerRow) {
                        Row row = sheet.getRow(rowFile);
                        headerDataList = row;
                    } else {
                        Object newModel = (model.getClass().newInstance());
                        Row fila = sheet.getRow(rowFile);
                        assignData(fila, newModel);
                        dataList.add(newModel);
                    }
                }
            }

            bookExcel.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

    public static List<Object> getListData() {
        return dataList;
    }

    public static Row getListDataHead() {
        return headerDataList;
    }

    @Override
    public void close() throws Exception {
        throw new IOException();
    }
}
