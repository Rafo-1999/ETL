package com.example.ETL;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableBatchProcessing

public class EtlApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtlApplication.class, args);
	}




//	@Bean
//	public Step step (){
//		new StepBuilder("anun").chunk(15).reader()
//	}

}
