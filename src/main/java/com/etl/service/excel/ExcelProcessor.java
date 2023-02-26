package com.etl.service.excel;

import java.io.InputStream;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.SyncReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.etl.domain.Student;
import com.etl.repository.StudentsRepository;
import com.etl.service.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ExcelProcessor implements Processor<Student> {

    @Autowired
    StudentsRepository repository;

    @Override
    public List<Student> process(InputStream inputStream) {

       List<Student> students = EasyExcel.read(inputStream, Student.class, new SyncReadListener())
            .headRowNumber(1)
            .doReadAllSync();

      List<Student> formatedStudents = students.stream()
          .map(ExcelFormatter::format)
          .toList();

      return repository.saveAll(formatedStudents);

    }
}
