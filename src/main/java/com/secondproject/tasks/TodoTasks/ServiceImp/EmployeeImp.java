package com.secondproject.tasks.TodoTasks.ServiceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.secondproject.tasks.TodoTasks.Dto.EmployeeDto;
import com.secondproject.tasks.TodoTasks.Entity.Employee;
import com.secondproject.tasks.TodoTasks.Respository.EmployeeRespository;
import com.secondproject.tasks.TodoTasks.Services.EmployeeService;


@Service
public class EmployeeImp implements EmployeeService {
	
	@Autowired
	EmployeeRespository employeeRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		employeeDto.setPassword(encoder.encode(employeeDto.getPassword()));
		Optional<Employee> empExit = employeeRepository.findByEmail(employeeDto.getEmail());
		if(!empExit.isEmpty()) {
			System.out.println(empExit);
			throw new RuntimeException("Employee Exists...");
		}else {
		Employee employee = dtoToemp(employeeDto);
		Employee savedEmp = employeeRepository.save(employee);
		savedEmp.setId(savedEmp.getId());
		EmployeeDto employeeDto1 = empTodto(savedEmp);
		return employeeDto1;
		}
	}
	
	public Employee dtoToemp(EmployeeDto emp) {
		Employee e = new Employee();
		e.setName(emp.getName());
		e.setEmail(emp.getEmail());
		e.setPassword(emp.getPassword());
		return e;
	}
	public EmployeeDto empTodto(Employee emp) {
		EmployeeDto  empdto = new EmployeeDto();
		empdto.setEmail(emp.getEmail());
		empdto.setName(emp.getName());
		empdto.setPassword(emp.getPassword());
		return empdto;
	}
}
