package com.example.readExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//@Configuration
//@EnableBatchProcessing
//@Slf4j   //Stringi konkatenacia e anum  debugi jamanak

 class ExcelReaderImplementation {


  public static void readExcel(String filePath1, String filePath2) {
    try {
      FileInputStream inputStream1 = new FileInputStream(filePath1);
      FileInputStream inputStream2 = new FileInputStream(filePath2);

      Workbook workbook1 = new XSSFWorkbook(inputStream1);
      Workbook workbook2 = new XSSFWorkbook(inputStream2);

      Sheet sheet1 = workbook1.getSheetAt(0);
      Sheet sheet2 = workbook2.getSheetAt(0);

      for (Row row1 : sheet1) {
        iterateRow(row1);
      }

      for (Row row2 : sheet2) {
        if (row2.getRowNum() == 0) {
          continue;
        }
        iterateRow(row2);

      }
      workbook1.close();
      workbook2.close();
      inputStream1.close();
      inputStream2.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void iterateRow(Row row) {
    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext()) {
      Cell cell1 = cellIterator.next();

      switch (cell1.getCellType()) {
        case NUMERIC -> System.out.print(cell1.getNumericCellValue() + " ");
        case STRING -> System.out.print(cell1.getStringCellValue() + " ");
      }
    }
    System.out.println();
  }


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

      if (cell1.getCellType() == CellType.STRING && cell2.getCellType() == CellType.STRING) {
//        String cell1Value = cell1.getStringCellValue();
//        String cell2Value = cell2.getStringCellValue();
//        String[] cell1Parts = cell1Value.split("\\."); // Split the value using the "." delimiter
//        String[] cell2Parts = cell2Value.split("/"); // Split the value using the "/" delimiter
//        String commonValue = cell1Parts[0] + "-" + cell1Parts[1] + "-" + cell1Parts[2] + " " +
//            cell2Parts[0] + "-" + cell2Parts[1] + "-"
//            + cell2Parts[2]; // Merge the parts into a common format
//        columnValues.add(commonValue);

        Date date1 = cell1.getDateCellValue();
        Date date2 = cell2.getDateCellValue();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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


//  public static void main(String[] args) throws IOException {
//    String path1 = "/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";
//    String path2 = "/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Book.xlsx";
//    List<String> columnValues = dataParse(path1, path2,5 );
//
//    for (String value : columnValues) {
//      System.out.println(value);
//    }
//  }
//}

/*
  public static String dateParsing(String filePath1, String filePath2, String cellAddress1,
      String cell1Address2)
      throws IOException {
    FileInputStream inputStream1 = new FileInputStream(filePath1);
    FileInputStream inputStream2 = new FileInputStream(filePath2);

    Workbook workbook1 = new XSSFWorkbook(inputStream1);
    Workbook workbook2 = new XSSFWorkbook(inputStream2);

    Sheet sheet1 = workbook1.getSheetAt(0);
    Sheet sheet2 = workbook2.getSheetAt(0);

    CellAddress cell1Address = new CellAddress(cellAddress1);
    CellAddress cell2Address = new CellAddress(cell1Address2);
    Row row1 = sheet1.getRow(cell1Address.getRow());
    Row row2 = sheet2.getRow(cell2Address.getRow());
    Cell cell1 = row1.getCell(cell1Address.getColumn());
    Cell cell2 = row2.getCell(cell2Address.getColumn());

    if (cell1.getCellType() == CellType.NUMERIC && cell2.getCellType() == CellType.NUMERIC) {
      Date date = cell1.getDateCellValue();
//      Calendar cal = Calendar.getInstance();
//      cal.setTime(date);
//      int year = cal.get(Calendar.YEAR);
//      int month = cal.get(Calendar.MONTH) + 1; // add 1 to adjust for 0-based month index
//      int day = cal.get(Calendar.DAY_OF_MONTH);

      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
      return dateFormat.format(date);
    } else {
      return null;
    }

  }

  public static void main(String[] args) throws IOException {
    String path1 = "/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";
    String path2 = "/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Book.xlsx";
    System.out.println(dateParsing(path1, path2, "F2", "F2"));
  }
}
//    CellAddress cell1Address = new CellAddress(cellAddress1);
//    Row row1 = sheet1.getRow(cell1Address.getRow());
//    if (cell1.getCellType() == CellType.FORMULA) {
//      switch (cell1.getCachedFormulaResultType()) {
//        case BOOLEAN -> System.out.println(cell1.getBooleanCellValue());
//        case NUMERIC -> System.out.println(cell1.getNumericCellValue());
//        case STRING -> System.out.println(cell1.getRichStringCellValue());
//      }
//    }
//    Date date1 = cell1.getDateCellValue();
//    Calendar calendar1 = Calendar.getInstance();
//    calendar1.setTime(date1);
//    int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
//    int month1 = calendar1.      // Open second Excel file
//        get(Calendar.MONTH) + 1;//+1 vor amisnery 1indeqsic sksi
//    int year1 = calendar1.get(Calendar.YEAR);

//    CellAddress cell2Address = new CellAddress(cellAddress2);
//    Row row2 = sheet2.getRow(cell2Address.getRow());
//    Cell cell2 = row2.getCell(cell2Address.getColumn());
//    if (cell2.getCellType() == CellType.NUMERIC) {
//      Date date = cell2.getDateCellValue();
//      Calendar cal = Calendar.getInstance();
//      cal.setTime(date);
//      int year = cal.get(Calendar.YEAR);
//      int month = cal.get(Calendar.MONTH) + 1; // add 1 to adjust for 0-based month index
//      int day = cal.get(Calendar.DAY_OF_MONTH);
//
//      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//      return dateFormat.format(date);
//    } else {
//      return null;
//    }
//    Date date2 = cell2.getDateCellValue();
//    Calendar calendar2 = Calendar.getInstance();
//    calendar2.setTime(date1);
//    int day2 = calendar1.get(Calendar.DAY_OF_MONTH);
//    int month2 = calendar1.get(Calendar.MONTH) + 1;//+1 vor amisnery 1indeqsic sksi
//    int year2 = calendar1.get(Calendar.YEAR);






  /*
  public static Date dataParsing(String filePath1,String filePath2,String cellAddress)
      throws IOException ,NullPointerException{
    FileInputStream inputStream1 = new FileInputStream(filePath1);
    FileInputStream inputStream2=new FileInputStream(filePath2);

    Workbook workbook1 = new XSSFWorkbook(inputStream1);
    Workbook workbook2=new XSSFWorkbook(inputStream2);

    Sheet sheet1 = workbook1.getSheetAt(0);
    Sheet sheet2=workbook2.getSheetAt(0);
    String cellAddressStr = String.valueOf(cellAddress);
    Row row1 = sheet1.getRow(CellReference.convertColStringToIndex(cellAddressStr.substring(0, 1)));
    //CellReference.convertColStringToIndex  exceli syunaki orinak A1 hamary kpoxakerpi indexov orinak 0

    String cellIndexStr = cellAddressStr.substring(1);
    int cellIndex = 0;
    if (!cellIndexStr.isEmpty()) {
      cellIndex = Integer.parseInt(cellIndexStr) - 1;
    }
    Cell cell1 = row1.getCell(cellIndex);//nuyny toxeri hamar

    // Extract date1 from cell and parse into day, month, year

      Date date1=cell1.getDateCellValue();
    Calendar calendar1=Calendar.getInstance();
    calendar1.setTime(date1);
    int day1=calendar1.get(Calendar.DAY_OF_MONTH);
    int month1=calendar1.      // Open second Excel file
        get(Calendar.MONTH)+1;//+1 vor amisnery 1indeqsic sksi
    int year1=calendar1.get(Calendar.YEAR);


    // Open second Excel file

    Row row2=sheet2.getRow(CellReference.convertColStringToIndex(cellAddressStr.substring(0,1)));

    if (!cellIndexStr.isEmpty()) {
      cellIndex = Integer.parseInt(cellIndexStr) - 1;
    }
    Cell cell2 =row2.getCell(cellIndex);

    Date date2=cell2.getDateCellValue();
    Calendar calendar2=Calendar.getInstance();
    calendar2.setTime(date1);
    int day2=calendar1.get(Calendar.DAY_OF_MONTH);
    int month2=calendar1.get(Calendar.MONTH)+1;//+1 vor amisnery 1indeqsic sksi
    int year2=calendar1.get(Calendar.YEAR);


    return new Date(year1 - 1900, month1 - 1, day1);

  }





}

/*package com.example.readExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//@Configuration
//@EnableBatchProcessing
//@Slf4j   //Stringi konkatenacia e anum  debugi jamanak

public class ExcelReaderImplementation {


  public static List<T> readExcel(String filePath1,String filePath2) throws FileNotFoundException {

    List<T> dataList=new ArrayList<>();
    try {
      FileInputStream inputStream1 = new FileInputStream(filePath1);
      FileInputStream inputStream2=new FileInputStream(filePath2);

      Workbook workbook1 = new XSSFWorkbook(inputStream1);
      Workbook workbook2=new XSSFWorkbook(inputStream2);

      Sheet sheet1 = workbook1.getSheetAt(0);
      Sheet sheet2=workbook2.getSheetAt(0);

      for (Row row1 : sheet1) {
        dataList.add(iterateRow(row1,List<T>.class).stream());
      }

      for (Row row2:sheet2){
     dataList.add(iterateRow(row2));

      }
      workbook1.close();
      workbook2.close();
      inputStream1.close();
      inputStream2.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (int i=0;i<dataList.size();i++){
      System.out.println(dataList.get(i));
    }


    return dataList;
  }

  public  static List<T> iterateRow(Row row,Class <T>type ){
    List <T> rowData=new ArrayList<>();

    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext()) {
      Cell cell = cellIterator.next();
      switch (cell.getCellType()) {
        case NUMERIC -> rowData.add(type.cast(cell.getNumericCellValue()));
        case STRING -> rowData.add(type.cast(cell.getStringCellValue()));
      }
    }
    return rowData;
  }


//  public  static String dataParser(String filePath1,String filePath2,int cellAddress){
//
//  }

}

*/
