package com.example.SpringBatch.Step.StudentsMainModel;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class StudentMainModel {


  private long id;
  private String name;
  private String surname;
  private int wave;
  private String email;
  private String date;
  private String rating;

}
