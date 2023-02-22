package com.example.SpringBatch.Step.ItemReader.Students;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Student2 {
  private long id;
  private String name;
  private  String surname;
  private int wave;
  private String  email;
  private String date;

}

