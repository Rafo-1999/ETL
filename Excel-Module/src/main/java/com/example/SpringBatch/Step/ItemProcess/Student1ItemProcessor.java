package com.example.SpringBatch.Step.ItemProcess;
import com.example.SpringBatch.Step.ItemReader.Students.Student1;
import com.example.SpringBatch.Step.StudentsMainModel.StudentMainModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component

public class Student1ItemProcessor implements ItemProcessor<Student1,StudentMainModel> {
  private final SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

  private final SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");

//localdate
  public Date parseDate(String dateStr) throws ParseException {
    return inputDateFormat.parse(dateStr);
  }


  public String ratingValue(String rating){
    return rating.substring(0, rating.indexOf("/"));
  }



  @Override
  public StudentMainModel process(Student1 student1) throws ParseException {
    Date date = parseDate(student1.getDate());
    String formattedDate = outputDateFormat.format(date);
    return StudentMainModel.builder()
        .id(student1.getId())
        .name(student1.getName())
        .surname(student1.getSurname())
        .wave(student1.getWave())
        .email(student1.getEmail())
        .date(formattedDate)
        .rating(student1.getRating())
        .build();
  }



}
