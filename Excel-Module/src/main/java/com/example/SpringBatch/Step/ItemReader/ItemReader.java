package com.example.SpringBatch.Step.ItemReader;

import com.example.SpringBatch.Step.ItemProcess.Student1ItemProcessor;
import com.example.SpringBatch.Step.ItemReader.Students.Student1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemReader implements org.springframework.batch.item.ItemReader<Student1> {

  String path1="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student1.xlsx";
  String path2="/home/rafo/IdeaProjects/ETL/Excel-Module/src/main/resources/Student2.xlsx";

  FileInputStream inputStream1=new FileInputStream(path1);
  FileInputStream inputStream2=new FileInputStream(path2);
  @Autowired
  StudentReaderImpl studentReader;
  Student1ItemProcessor studentProcessor;

  public ItemReader() throws FileNotFoundException {
  }

  @Override
  public Student1 read()
      throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    return null;
  }

//  @Override
//  public Student1 read()
//      throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//    return studentReader.student1(studentReader.student1(),studentProcessor.parseDate());
//  }

}
