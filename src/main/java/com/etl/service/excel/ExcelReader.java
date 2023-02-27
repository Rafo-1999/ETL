package com.etl.service.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static void readExcel(InputStream excelInputStream) {

            //Workbook workbook1 = new XSSFWorkbook(excelInputStream);
            //Sheet sheet1 = workbook1.getSheetAt(0);
            //
            //for (Row row1 : sheet1) {
            //    iterateRow(row1);
            //}
            //workbook1.close();

    }

    //public static void iterateRow(Row row) {
    //    StreamSupport.stream(row.spliterator(), false)
    //        .map(cell1 -> {
    //            switch (cell1.getCellType()) {
    //                case NUMERIC -> System.out.print(cell1.getNumericCellValue() + " ");
    //                case STRING -> System.out.print(cell1.getStringCellValue() + " ");
    //            }
    //        })
    //
    //}

    public static List<String> dataParse(String filePath1, String filePath2, int columnIndex)
        throws IOException {
        List<String> columnValues = new ArrayList<>();

        FileInputStream inputStream1 = new FileInputStream(filePath1);
        FileInputStream inputStream2 = new FileInputStream(filePath2);

        Workbook workbook1 = new XSSFWorkbook(inputStream1);
        Workbook workbook2 = new XSSFWorkbook(inputStream2);

        Sheet sheet1 = workbook1.getSheetAt(0);
        Sheet sheet2 = workbook2.getSheetAt(0);

        Iterator<Row> rowIterator1 = sheet1.iterator();
        Iterator<Row> rowIterator2 = sheet2.iterator();

        rowIterator2.next();

        while (rowIterator1.hasNext() && rowIterator2.hasNext()) {
            Row row1 = rowIterator1.next();
            Row row2 = rowIterator2.next();
            Cell cell1 = row1.getCell(columnIndex);
            Cell cell2 = row2.getCell(columnIndex);

            if (cell1.getCellType() == CellType.NUMERIC && cell2.getCellType() == CellType.NUMERIC) {
                Date date1 = cell1.getDateCellValue();
                Date date2 = cell2.getDateCellValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat();
                columnValues.add(dateFormat.format(date1));
                columnValues.add(dateFormat.format(date2));
            } else if (cell1.getCellType() == CellType.STRING && cell2.getCellType() == CellType.STRING) {
                columnValues.add(cell1.getStringCellValue());
                columnValues.add(cell2.getStringCellValue());
            }
        }

        workbook1.close();
        workbook2.close();
        inputStream1.close();
        inputStream2.close();

        return columnValues;
    }

}
