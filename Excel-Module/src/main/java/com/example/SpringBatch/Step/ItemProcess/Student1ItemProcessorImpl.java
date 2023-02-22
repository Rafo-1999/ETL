package com.example.SpringBatch.Step.ItemProcess;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Student1ItemProcessorImpl {



    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }


}
