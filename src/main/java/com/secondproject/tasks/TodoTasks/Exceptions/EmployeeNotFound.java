package com.secondproject.tasks.TodoTasks.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFound extends RuntimeException{
    
	private String message;

	public EmployeeNotFound(String message) {
		super(message);
		this.message= message;
	}
     
}
