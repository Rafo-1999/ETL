package com.etl.service.excel;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.SyncReadListener;
import com.etl.domain.Student;
import com.etl.repository.StudentsRepository;
import com.etl.service.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ExcelProcessor implements Processor<Student> {


  @Autowired
  StudentsRepository repository;


  private final DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  private final DateTimeFormatter outputDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");


  public String parseDate(String dateStr) throws DateTimeParseException {
    LocalDate date = LocalDate.parse(dateStr, inputDateFormat);
    return date.format(outputDateFormat);
  }


  public String ratingValue(String rating){
    return rating.substring(0, rating.indexOf("/"));
  }


  @Override
  public List<Student> process(InputStream inputStream) {


    List<Student> students = EasyExcel.read(inputStream, Student.class, new SyncReadListener())
        .headRowNumber(1)  //out first line
        .doReadAllSync();   //read all line

    List<Student> formattedStudents = students.stream()

        .map(ExcelFormatter::format)
        .toList();

    return repository.saveAll(formattedStudents);

  }




}
