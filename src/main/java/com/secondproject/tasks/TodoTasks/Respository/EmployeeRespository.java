package com.secondproject.tasks.TodoTasks.Respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secondproject.tasks.TodoTasks.Entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long>{
//	Employee findByEmail(String email);

	Optional<Employee> findByEmail(String email);

}
