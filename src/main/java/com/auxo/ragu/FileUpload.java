package com.auxo.ragu;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import controller.FileUploadController;


@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.auxo.ragu","Controller"})
public class FileUpload {

	public static void main(String[] args) {
//		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(FileUpload.class, args);
	}
}
