package com.example.Excel;


import com.example.SpringBatch.Step.ItemReader.StudentReaderImpl;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class StudentReaderImplTest {

  @Test
  void doRead() throws IOException {
    String path1="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";
    String path2="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student2.xlsx";

    FileInputStream inputStream1=new FileInputStream(path1);
    FileInputStream inputStream2=new FileInputStream(path2);
    StudentReaderImpl student =new StudentReaderImpl();



    System.out.println(student.student1(inputStream1));
    System.out.println(student.student2(inputStream2));



      inputStream1.close();
      inputStream2.close();
  }
}