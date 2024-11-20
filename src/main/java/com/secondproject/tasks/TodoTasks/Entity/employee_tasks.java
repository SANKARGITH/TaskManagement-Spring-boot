package com.secondproject.tasks.TodoTasks.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor

@Entity
@Table(name = "employee_tasks")
public class employee_tasks {
     
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taskId")
	private Long id;
	@Column(name = "TaskStmt")
	private String assignTaks;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id")
	private Employee empId;
}
