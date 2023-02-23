package com.example.SpringBatch.Step.ItemReader;

import com.example.SpringBatch.Step.ItemReader.Students.Student1;
import com.example.SpringBatch.Step.ItemReader.Students.Student2;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.Function;
import java.util.stream.StreamSupport;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
@Slf4j   //Stringi konkatenacia e anum  debugi jamanak
public  class StudentReaderImpl implements StudentReader  {


  public  static Sheet createWorkbook(InputStream stream) throws IOException {
    XSSFWorkbook workbook=new XSSFWorkbook(stream);

    return workbook.getSheetAt(0);
  }


  @Override
  public    List<Student1> student1(InputStream stream1) throws IOException {

    return StreamSupport.stream(createWorkbook(stream1).spliterator(), false)
        .skip(1)  //skip head row
        .map(StudentFieldList::toStudent1)
        .toList();
  }
  @Override
  public    List<Student2> student2(InputStream stream2) throws IOException {
    

    return StreamSupport.stream(createWorkbook(stream2).spliterator(), false)
        .skip(1)
        .map(StudentFieldList::toStudent2)
        .toList();
  }




}
