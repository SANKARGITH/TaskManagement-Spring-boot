package com.secondproject.tasks.TodoTasks;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TodoTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoTasksApplication.class, args);
		
	}
	
	@Bean
     ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
