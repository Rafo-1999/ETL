package com.example.readExcel;



import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class ExcelReaderImplementationTest {

  @Test
  void read() {

    String path1 = "/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";
    String path2 = "/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Book.xlsx";

    assertDoesNotThrow(() -> ExcelReaderImplementation.readExcel(path1, path2));


  }
//  @Test
//  public void testDateParsing()throws NullPointerException{
//    String filePath1="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";
//   String filePath2="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Book.xlsx";
//   assertDoesNotThrow(()->ExcelReaderImplementation.dataParsing(filePath1,filePath2,"F2"));
//
//  }
//@Test
//  public void testDateParsing() throws IOException {
//
//    Workbook workbook1 = new XSSFWorkbook();
//    Sheet sheet1 = workbook1.createSheet();
//    Row row1 = sheet1.createRow(0);
//    Cell cell1 = row1.createCell(0);
//    Calendar calendar = Calendar.getInstance();
//    calendar.set(2022, Calendar.FEBRUARY, 19);
//    cell1.setCellValue(calendar.getTime());
//    Workbook workbook2 = new XSSFWorkbook();
//    Sheet sheet2 = workbook2.createSheet();
//    Row row2 = sheet2.createRow(0);
//    Cell cell2 = row2.createCell(0);
//    cell2.setCellValue(calendar.getTime());
//    // Invoke method to test
//    Date result = dataParsing(filePath1,filePath2 , 5);
//    // Verify result
//    assertEquals(calendar.getTime(), result);
//  }
//  @Test
//  public void testDataParsing() {
//    String filePath1="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";
//    String filePath2="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Book.xlsx";
//    int cellAddress = 0;
//    Date expectedDate = new Date(2023 - 1900, 1 - 1, 1); // year, month, day
//
//    try {
//      Date result = dataParsing(filePath1, filePath2, cellAddress);
//      assertEquals(expectedDate, result);
//    } catch (IOException e) {
//      fail("An IOException was thrown: " + e.getMessage());
//    }
//  }



}