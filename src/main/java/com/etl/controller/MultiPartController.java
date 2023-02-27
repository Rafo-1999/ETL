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
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String name = file.getOriginalFilename();

        Type type = ExtensionDetector.detectType(name);
        if (type.equals(Type.EXCEL)) {

            List<Student> process = excelProcessor.process(inputStream);
            return ResponseEntity.ok(process);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAll() {
        List<Student> allStudents = studentsRepository.findAll();

        return ResponseEntity.ok(allStudents);
    }
}
//produces = MediaType.APPLICATION_JSON_VALUE