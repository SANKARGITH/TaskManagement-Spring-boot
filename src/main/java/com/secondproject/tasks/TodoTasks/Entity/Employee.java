package com.secondproject.tasks.TodoTasks.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "emp_email" })
})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "emp_name",nullable = false)
	private String name;
	@Column(name = "emp_email",nullable = false)
	private String email;
	@Column(name = "password",nullable = false)
	private String password;

}
