package com.example.mergeExcel;


import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class mergeExcelImplementationTest {

  @Test
  void mergeExcelFiles() throws IOException {

    String firstFilePath = "/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";
    String secondFilePath = "/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Book.xlsx";

    String mergedFilePath = "/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/MergeExcel.xlsx";

    MergeExcelImplementation.mergeExcelFiles(firstFilePath, secondFilePath, mergedFilePath);

    File outputFile = new File(mergedFilePath);
    assertTrue(outputFile.exists());
    assertTrue(outputFile.length() > 0);


  }

  @Test
  void sortbyWave(){

  }

}

