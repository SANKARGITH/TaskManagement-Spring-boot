package com.secondproject.tasks.TodoTasks.Respository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secondproject.tasks.TodoTasks.Entity.Employee;
import com.secondproject.tasks.TodoTasks.Entity.employee_tasks;

public interface TasksRepository extends JpaRepository<employee_tasks, Long> {
	List<employee_tasks> findAllByEmpId(Employee emp);
}
