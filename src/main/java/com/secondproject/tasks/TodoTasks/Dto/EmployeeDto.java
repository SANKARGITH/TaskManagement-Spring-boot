package com.secondproject.tasks.TodoTasks.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {
    
	private long id;
	private String name;
	private String email;
	private String password;
}
