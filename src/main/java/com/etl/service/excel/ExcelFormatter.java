package com.etl.service.excel;

import com.etl.domain.Student;

public class ExcelFormatter {

  public static Student format(Student st){

    return st.toBuilder()
        .name(st.getName().toUpperCase())
        .build();
  }

}
