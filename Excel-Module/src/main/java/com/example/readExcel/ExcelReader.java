package com.example.readExcel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public   interface ExcelReader {

  <T>  List<T> read(InputStream stream, Class<? extends T> type) throws IOException;

}
