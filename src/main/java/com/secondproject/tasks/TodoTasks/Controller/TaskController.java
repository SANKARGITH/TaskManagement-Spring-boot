package com.secondproject.tasks.TodoTasks.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secondproject.tasks.TodoTasks.Dto.TasksDto;
import com.secondproject.tasks.TodoTasks.Services.TasksService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController 
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	TasksService taskservice;
	
	@PostMapping("/{empid}/save")
	public ResponseEntity<TasksDto>  saveTask(@PathVariable(name ="empid") Long id, @RequestBody TasksDto task){
		return new ResponseEntity<>(taskservice.saveTask(id,task),HttpStatus.CREATED);
	}
	
	//update task
	@PutMapping("/{empId}/update/{taskId}")
	public ResponseEntity<TasksDto>  updateTask(@PathVariable(name ="empId") Long id,@PathVariable(name="taskId") Long taskId, @RequestBody TasksDto task){
		return new ResponseEntity<>(taskservice.updateTask(id,taskId,task),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<TasksDto>> getAll(){
		return new ResponseEntity<>(taskservice.getAllTasks(),HttpStatus.OK);
		
	}
	
	@GetMapping("/{empId}/all")
	public ResponseEntity<List<TasksDto>> getDetails(@PathVariable(name="empId") Long empId){
		return new ResponseEntity<>(taskservice.getdetails(empId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{empId}/delete/{taskId}")
	public ResponseEntity<String> deleteTask(@PathVariable(name="empId") Long empId, @PathVariable(name="taskId") Long taskId){
		taskservice.deletTask(empId, taskId);
	return new ResponseEntity<>("Deleted Task",HttpStatus.OK);
	}

}
