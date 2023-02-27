package com.etl.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.etl.domain.Student;
import com.etl.repository.StudentsRepository;
import com.etl.service.ExtensionDetector;
import com.etl.service.Processor;
import com.etl.service.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MultiPartController {

  @Autowired
  StudentsRepository studentsRepository;

  @Autowired
  @Qualifier("excelProcessor")
  Processor<Student> excelProcessor;

  @PostMapping("/upload")
  public ResponseEntity<?> upload(@RequestParam("file1") MultipartFile file1,
      @RequestParam("file2") MultipartFile file2) throws IOException {
    InputStream inputStream1 = file1.getInputStream();
    InputStream inputStream2 = file2.getInputStream();
    String name1 = file1.getOriginalFilename();
    String name2 = file2.getOriginalFilename();

    Type type1 = ExtensionDetector.detectType(name1);
    Type type2 = ExtensionDetector.detectType(name2);
    if (type1.equals(Type.EXCEL) && type2.equals(Type.EXCEL)) {

      List<Student> process1 = excelProcessor.process(inputStream1);
      List<Student> process2 = excelProcessor.process(inputStream2);

      ResponseEntity.ok().build();
      return ResponseEntity.ok(process2);
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping(value = "/all")
  public ResponseEntity<?> getAll() {
    List<Student> allStudents = studentsRepository.findAll();

    return ResponseEntity.ok(allStudents);
  }

  @GetMapping(value = "/clear")
  public ResponseEntity<?> clearAll() {
    studentsRepository.deleteAll();
    return ResponseEntity.ok().build();
  }
}
//produces = MediaType.APPLICATION_JSON_VALUE