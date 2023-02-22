package com.example.SpringBatch.Step.ItemReader;

import com.example.SpringBatch.Step.ItemReader.Students.Student1;
import com.example.SpringBatch.Step.ItemReader.Students.Student2;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;


@Slf4j
public class StudentFieldList {

  public static Student1 toStudent1(Row row) {
    return Student1.builder()
        .id((long) row.getCell(0).getNumericCellValue())
        .name(row.getCell(1).getStringCellValue())
        .surname(row.getCell(2).getStringCellValue())
        .wave((int) row.getCell(3).getNumericCellValue())
        .email(row.getCell(4).getStringCellValue())
        .date(row.getCell(5).getCellType() == CellType.STRING ? row.getCell(5).getStringCellValue() :
            String.valueOf(row.getCell(5).getNumericCellValue()))

        .build();
  }

  public static Student2 toStudent2(Row row){
    return Student2.builder()
        .id((long) row.getCell(0).getNumericCellValue())
        .name(row.getCell(1).getStringCellValue())
        .surname(row.getCell(2).getStringCellValue())
        .wave((int) row.getCell(3).getNumericCellValue())
        .email(row.getCell(4).getStringCellValue())
        .date(row.getCell(5).getCellType() == CellType.STRING ? row.getCell(5).getStringCellValue() :
            String.valueOf(row.getCell(5).getNumericCellValue()))

        .build();
  }



}
