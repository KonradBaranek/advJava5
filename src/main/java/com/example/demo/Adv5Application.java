package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackageClasses = WarmingExercise.class)
public class Adv5Application {

	public static List<Book> books = new ArrayList<>();
	public static List<Author> authors = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(Adv5Application.class, args);
	}

}
