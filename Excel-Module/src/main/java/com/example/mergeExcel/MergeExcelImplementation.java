package com.example.mergeExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MergeExcelImplementation {

  public static void mergeExcelFiles(String file1Path, String file2Path, String outputPath)
      throws IOException {
    List<XSSFSheet> sheets = new ArrayList<>();
    //XSSFWorkbook-> exceli .xlsx formati faylery kardalu hamar

    XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(file1Path));
    XSSFWorkbook workbook2 = new XSSFWorkbook(new FileInputStream(file2Path));

    sheets.add(workbook1.getSheetAt(0));
    sheets.add(workbook2.getSheetAt(0));

    XSSFWorkbook mergedWorkbook = new XSSFWorkbook();
    XSSFSheet mergedSheet = mergedWorkbook.createSheet();

    int currentRow = 0;

    for (XSSFSheet sheet : sheets) {
      for (Row row : sheet) {
        if (row.getRowNum() == 0) {
          continue;
        }
        Row newRow = mergedSheet.createRow(currentRow++);

        for (Cell cell : row) {

          Cell newCell = newRow.createCell(cell.getColumnIndex());
          //newCell.setCellValue(cell.getStringCellValue());
          if (cell.getCellType() == CellType.STRING) {
            newCell.setCellValue(cell.getStringCellValue());
          } else if (cell.getCellType() == CellType.NUMERIC) {
            newCell.setCellValue(cell.getNumericCellValue());
          }
        }
      }
    }

    FileOutputStream out = new FileOutputStream(outputPath);
    mergedWorkbook.write(out);
    out.close();

  }


}


//  public static void sortById(String inputFile,String outputFile) throws IOException {
//    try {
//      XSSFWorkbook inputBook = new XSSFWorkbook(new FileInputStream(inputFile));
//      XSSFSheet sheet = inputBook.getSheetAt(0);
//
//      int numRows = sheet.getLastRowNum() + 1;
//      int[] data = new int[numRows];
//      int h = 0;
//
//      // Read in data to be sorted
//      for (Row row : sheet) {
//        if (row.getRowNum() == 0) {
//          continue;
//        }
//        Cell cell = row.getCell(0);
//        if (cell.getCellType() == CellType.NUMERIC) {
//          data[h] = (int) cell.getNumericCellValue();
//        } else if (cell.getCellType() == CellType.STRING) {
//          data[h] = Integer.parseInt(cell.getStringCellValue());
//        }
//        h++;
//      }
//
//      // Sort data
//      Arrays.sort(data);
//
//      XSSFWorkbook outputBook = new XSSFWorkbook(new FileInputStream(outputFile));
//      XSSFSheet outputFileSheet = outputBook.getSheetAt(0);
//
//      int numExistingRows = outputFileSheet.getLastRowNum() + 1;
//
//      // Append sorted data to output file
//      for (int i = 0; i < numRows; i++) {
//        Row newRow = outputFileSheet.createRow(numExistingRows + i);
//        Cell cell = newRow.createCell(0);
//        cell.setCellValue(data[i]);
//      }
//
//      FileOutputStream outputFileStream = new FileOutputStream(outputFile);
//      outputBook.write(outputFileStream);
//      outputFileStream.close();
//
//    } catch (IOException e){
//      e.printStackTrace();
//    }
//  }
//
//  }
  /*  try {

      List<XSSFSheet> sheets=new ArrayList<>();

      //FileInputStream fileInputStream = new FileInputStream(inputFile);

      XSSFWorkbook inputBook= new XSSFWorkbook(new FileInputStream(inputFile));

      //Workbook workbook = WorkbookFactory.create(fileInputStream);

      sheets.add(inputBook.getSheetAt(0));

     Sheet sheet = inputBook.getSheetAt(0);




      int numRows = sheet.getLastRowNum() + 1;
      int[] data = new int[numRows];
      int h = 0;

      for (Row row : sheet) {
        if (row.getRowNum() == 0) {

          continue;
        }


        Cell cell = row.getCell(0);
        if (cell.getCellType() == CellType.NUMERIC) {
          data[h] = (int) cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
          data[h] = Integer.parseInt(cell.getStringCellValue());
        }
        h++;
      }

      Arrays.sort(data);

      XSSFWorkbook outputBook=new XSSFWorkbook(new FileInputStream(outputFile));
      XSSFSheet outputFileSheet=outputBook.getSheetAt(0);

      int numExistingRows = outputFileSheet.getLastRowNum() + 1;

      // Append sorted data to output file
      for (int i = 0; i < numRows; i++) {
        Row newRow = outputFileSheet.createRow(numExistingRows + i);
        Cell cell = newRow.createCell(0);
        cell.setCellValue(data[i]);
      }



//      int n = data.length;
//
//      for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n - i - 1; j++) {
//          if (data[j] > data[j + 1]) {
//            int temp = data[j];
//            data[j] = data[j + 1];
//            data[j + 1] = temp;
//
//          }
//        }
//      }

//      FileInputStream inputFileStream = new FileInputStream(outputFile);
//      Workbook outputWorkbook = WorkbookFactory.create(inputFileStream);
//      Sheet outputSheet = outputWorkbook.getSheetAt(0);

//      h = 0;
//      for (Row row : sheet) {
//        Cell cell = row.getCell(0);
//        cell.setCellValue(data[h]);
//        h++;
//      }
//
//      for (int i = 0; i < data.length; i++) {
//        Row row = outputSheet.createRow(i);
//        Cell cell = row.createCell(0);
//        cell.setCellValue(data[i]);
//      }


      FileOutputStream outputFileStream = new FileOutputStream(outputFile);
      outputBook.write(outputFileStream);
      outputFileStream.close();

//      fileInputStream.close();
//      outputFileStream.close();
//      inputBook.close();
//      outputWorkbook.close();

    }catch (IOException e){
      e.printStackTrace();
    }


  }




*/











/*
  public static void sortAndSplitExcelFile(String inputFilePath, String outputFilePath1, String outputFilePath2) throws IOException {
    // read input file
    FileInputStream file = new FileInputStream((inputFilePath));
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);

    // sort by name
    List<Row> rows = new ArrayList<>();
    for (Row row : sheet) {
      rows.add(row);
    }
    Collections.sort(rows, new Comparator<Row>() {
      public int compare(Row row1, Row row2) {
        String name1 = row1.getCell(1).getStringCellValue();
        String name2 = row2.getCell(1).getStringCellValue();
        return name1.compareTo(name2);
      }
    });

    // split into two files
    Set<String> uniqueNames = new HashSet<>();
    XSSFWorkbook outputWorkbook1 = new XSSFWorkbook();
    XSSFWorkbook outputWorkbook2 = new XSSFWorkbook();
    XSSFSheet outputSheet1 = outputWorkbook1.createSheet();
    XSSFSheet outputSheet2 = outputWorkbook2.createSheet();
    int currentRow1 = 0;
    int currentRow2 = 0;
    for (Row row : rows) {
      String name = row.getCell(1).getStringCellValue();
      if (uniqueNames.contains(name)) {
        // add to output file 2 if name is already in set
        Row newRow = outputSheet2.createRow(currentRow2++);
        for (Cell cell : row) {
          Cell newCell = newRow.createCell(cell.getColumnIndex());
          if (cell.getCellType() == CellType.STRING) {
            newCell.setCellValue(cell.getStringCellValue());
          } else if (cell.getCellType() == CellType.NUMERIC) {
            newCell.setCellValue(cell.getNumericCellValue());
          }
        }
      } else {
        // add to output file 1 if name is not in set
        uniqueNames.add(name);
        Row newRow = outputSheet1.createRow(currentRow1++);
        for (Cell cell : row) {
          Cell newCell = newRow.createCell(cell.getColumnIndex());
          if (cell.getCellType() == CellType.STRING) {
            newCell.setCellValue(cell.getStringCellValue());
          } else if (cell.getCellType() == CellType.NUMERIC) {
            newCell.setCellValue(cell.getNumericCellValue());
          }
        }
      }
    }

    // write output files
    FileOutputStream out1 = new FileOutputStream((outputFilePath1));
    outputWorkbook1.write(out1);
    out1.close();

    FileOutputStream out2 = new FileOutputStream((outputFilePath2));
    outputWorkbook2.write(out2);
    out2.close();

    // close input file
    file.close();
  }



  /*  public static void sortAndSplitExcelFile(String inputFilePath, String outputFilePath1, String outputFilePath2) throws IOException {
    // read input file
    try (FileInputStream file = new FileInputStream(new File(inputFilePath));
        XSSFWorkbook workbook = new XSSFWorkbook(file)) {
      XSSFSheet sheet = workbook.getSheetAt(0);

      // sort by name
      List<Row> rows = new ArrayList<>();
      for (Row row : sheet) {
        rows.add(row);
      }
      Collections.sort(rows, new Comparator<Row>() {
        public int compare(Row row1, Row row2) {
          String name1 = row1.getCell(1).getStringCellValue();
          String name2 = row2.getCell(1).getStringCellValue();
          return name1.compareTo(name2);
        }
      });

      // split into two files
      Set<String> uniqueNames = new HashSet<>();
      try (XSSFWorkbook outputWorkbook1 = new XSSFWorkbook();
          XSSFWorkbook outputWorkbook2 = new XSSFWorkbook();
          FileOutputStream out1 = new FileOutputStream(new File(outputFilePath1));
          FileOutputStream out2 = new FileOutputStream(new File(outputFilePath2))) {

        XSSFSheet outputSheet1 = outputWorkbook1.createSheet();
        XSSFSheet outputSheet2 = outputWorkbook2.createSheet();
        int currentRow1 = 0;
        int currentRow2 = 0;
        for (Row row : rows) {
          String name = row.getCell(1).getStringCellValue();
          if (uniqueNames.contains(name)) {
            // add to output file 2 if name is already in set
            Row newRow = outputSheet2.createRow(currentRow2++);
            for (Cell cell : row) {
              Cell newCell = newRow.createCell(cell.getColumnIndex());
              if (cell.getCellType() == CellType.STRING) {
                newCell.setCellValue(cell.getStringCellValue());
              } else if (cell.getCellType() == CellType.NUMERIC) {
                newCell.setCellValue(cell.getNumericCellValue());
              }
            }
          } else {
            // add to output file 1 if name is not in set
            uniqueNames.add(name);
            Row newRow = outputSheet1.createRow(currentRow1++);
            for (Cell cell : row) {
              Cell newCell = newRow.createCell(cell.getColumnIndex());
              if (cell.getCellType() == CellType.STRING) {
                newCell.setCellValue(cell.getStringCellValue());
              } else if (cell.getCellType() == CellType.NUMERIC) {
                newCell.setCellValue(cell.getNumericCellValue());
              }
            }
          }
        }

        // write output files
        outputWorkbook1.write(out1);
        outputWorkbook2.write(out2);
      }
    }
  }*/
