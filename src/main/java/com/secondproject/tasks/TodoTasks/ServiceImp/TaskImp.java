package com.secondproject.tasks.TodoTasks.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondproject.tasks.TodoTasks.Dto.TasksDto;
import com.secondproject.tasks.TodoTasks.Entity.Employee;
import com.secondproject.tasks.TodoTasks.Entity.employee_tasks;
import com.secondproject.tasks.TodoTasks.Exceptions.EmployeeNotFound;
import com.secondproject.tasks.TodoTasks.Exceptions.TaskNotFound;
import com.secondproject.tasks.TodoTasks.Respository.EmployeeRespository;
import com.secondproject.tasks.TodoTasks.Respository.TasksRepository;
import com.secondproject.tasks.TodoTasks.Services.TasksService;

@Service
public class TaskImp implements TasksService {
	
	@Autowired 
	private ModelMapper mapper;
	
	@Autowired
	private TasksRepository taskrepo;
	
	@Autowired
	private EmployeeRespository empRepo;

	@Override
	public TasksDto saveTask(Long empid,TasksDto tasksDto) {
		Employee emp = empRepo.findById(empid).orElseThrow(()-> new EmployeeNotFound("Employee does not exist..."));
		employee_tasks emptask = mapper.map(tasksDto, employee_tasks.class);
		emptask.setEmpId(emp);
		employee_tasks task = taskrepo.save(emptask);
		return mapper.map(task, TasksDto.class);
	}

	@Override
	public List<TasksDto> getAllTasks() {
		List<employee_tasks> tasks = taskrepo.findAll();
       return tasks.stream().map(
    		   task -> mapper.map(task, TasksDto.class)
    		   ).collect(Collectors.toList());
	}

	@Override
	public List<TasksDto> getdetails(Long empId) {
		Employee emp = empRepo.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee not Exists..."));
		if(taskrepo.findAllByEmpId(emp).isEmpty()) {
			throw new TaskNotFound("Task not assigned for the Employee.....");
		}
		List<employee_tasks> tasks = taskrepo.findAllByEmpId(emp);
		return tasks.stream().map(
				task -> mapper.map(task, TasksDto.class)
				).collect(Collectors.toList());
	}

	@Override
	public void deletTask(Long empId, Long taskId) {
		Employee emp = empRepo.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee not Exists..."));
		if(taskrepo.findAllByEmpId(emp).isEmpty()) {
			throw new TaskNotFound("Task not assigned for the Employee.....");
		}
	    taskrepo.findById(taskId).orElseThrow(()->new RuntimeException("Task Not found"));
		taskrepo.deleteById(taskId);
	
	}

	@Override
	public TasksDto updateTask(Long empId,Long taskId, TasksDto task) {
		Employee emp = empRepo.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee does not exist..."));
		if(taskrepo.findAllByEmpId(emp).isEmpty()) {
			throw new TaskNotFound("Task not assigned for the Employee.....");
		}
	    taskrepo.findById(taskId).orElseThrow(()->new RuntimeException("Task Not found"));
		employee_tasks emptask = mapper.map(task, employee_tasks.class);
		emptask.setEmpId(emp);
		emptask.setId(taskId);
		emptask.setAssignTaks(task.getAssignTaks());
		employee_tasks task1 = taskrepo.save(emptask);
		return mapper.map(task1, TasksDto.class);
	}

}
