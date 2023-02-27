package com.etl.service.excel;

import com.etl.domain.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class ExcelFormatter {



  public static Student format(Student st){

    ExcelProcessor excelProcessor=new ExcelProcessor();

    return st.toBuilder()
        .id(null)
        .name(st.getName().toUpperCase())
        .surname(st.getSurname().toUpperCase())
        .wave(st.getWave())
        .email(st.getEmail().toUpperCase())
        .date(excelProcessor.parseDate(st.getDate()))
        .rating(excelProcessor.ratingValue(st.getRating()))
        .build();
  }


}
