package com.example.SpringBatch.Step.ItemProcess;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.SpringBatch.Step.ItemReader.Students.Student1;
import com.example.SpringBatch.Step.StudentsMainModel.StudentMainModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;

class Student1ItemProcessorTest {

  String path1="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";
  String path2="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student2.xlsx";

  FileInputStream inputStream1=new FileInputStream(path1);
  FileInputStream inputStream2=new FileInputStream(path2);


  private final Student1ItemProcessor processor = new Student1ItemProcessor();
  private final SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  private final SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");

  Student1ItemProcessorTest() throws FileNotFoundException {
  }

  @Test
  void processTest() throws ParseException {
    Student1 student1 = new Student1();
    student1.setId(1L);
    student1.setName("Anun1");
    student1.setSurname("Azganun1");
    student1.setWave(2);
    student1.setEmail("email1");
    student1.setDate("2022-01-01");

    StudentMainModel result = processor.process(student1);

    assert result != null;
    assertEquals(student1.getId(), result.getId());
    assertEquals(student1.getName(), result.getName());
    assertEquals(student1.getSurname(), result.getSurname());
    assertEquals(student1.getWave(), result.getWave());
    assertEquals(student1.getEmail(), result.getEmail());
    assertEquals("01-01-2022", result.getDate());

  }

  @Test
  void parseDate() {
  }

  @Test
  void ratingValue() throws FileNotFoundException {
    String path1="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";

    FileInputStream inputStream1=new FileInputStream(path1);
    Student1ItemProcessor student1ItemProcessor=new Student1ItemProcessor();
    String rating="75/100";
    System.out.println(student1ItemProcessor.ratingValue(rating));

  }


}
