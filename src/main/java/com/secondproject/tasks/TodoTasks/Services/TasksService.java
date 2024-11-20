package com.secondproject.tasks.TodoTasks.Services;

import java.util.List;

import com.secondproject.tasks.TodoTasks.Dto.TasksDto;

public interface TasksService {

	
	public TasksDto saveTask(Long empid,TasksDto tasksDto);
	public List<TasksDto> getAllTasks();
	public List<TasksDto> getdetails(Long empId);
	public void  deletTask(Long empId, Long taskId);
	public TasksDto updateTask(Long empId,Long taskId,TasksDto task);
}
