package com.example.SpringBatch.Step.ItemReader;

import com.example.SpringBatch.Step.ItemReader.Students.Student1;
import com.example.SpringBatch.Step.ItemReader.Students.Student2;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface StudentReader {

   List<Student1> student1(InputStream stream1) throws IOException;
   List<Student2> student2(InputStream stream2) throws IOException;


}
