package com.etl.service;

import java.io.InputStream;
import java.util.List;

public interface Processor<T> {
    List<T> process(InputStream inputStream);
}
