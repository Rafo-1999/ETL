package com.etl.service;

public class ExtensionDetector {

    public static Type detectType(String fileName){
        if (fileName.endsWith("xlsx")){
            return Type.EXCEL;
        }else if (fileName.endsWith("pdf")){
           return Type.PDF;
        }
        throw  new UnsupportedOperationException();
    }
}
