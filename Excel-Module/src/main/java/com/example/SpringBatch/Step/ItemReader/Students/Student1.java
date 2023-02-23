package com.example.SpringBatch.Step.ItemReader.Students;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@AllArgsConstructor
@NoArgsConstructor
public class Student1 {

//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String surname;
  private int wave;
  private String email;
  private String date;
  private String rating;


}
