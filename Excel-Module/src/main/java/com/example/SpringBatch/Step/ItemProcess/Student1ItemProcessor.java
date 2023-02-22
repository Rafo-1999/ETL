package com.example.SpringBatch.Step.ItemProcess;
import com.example.SpringBatch.Step.ItemReader.Students.Student1;
import com.example.SpringBatch.Step.StudentsMainModel.StudentMainModel;

import javax.batch.api.chunk.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component

public class Student1ItemProcessor implements ItemProcessor{



@Bean
  public StudentMainModel processItem(Student1 student1)  {
    return StudentMainModel.builder()
        .id(student1.getId())
        .name(student1.getName())
        .surname(student1.getSurname())
        .wave(student1.getWave())
        .email(student1.getEmail())
        .date(student1.getDate())
        .build();
  }


  @Override
  public Object processItem(Object o)  {
    return null;
  }
}
