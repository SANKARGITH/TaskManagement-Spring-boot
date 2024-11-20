package com.secondproject.tasks.TodoTasks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secondproject.tasks.TodoTasks.Dto.EmployeeDto;
import com.secondproject.tasks.TodoTasks.Dto.JwtObjectResponse;
import com.secondproject.tasks.TodoTasks.Dto.LoginDto;
import com.secondproject.tasks.TodoTasks.Exceptions.EmployeeNotFound;
import com.secondproject.tasks.TodoTasks.Services.EmployeeService;
import com.secondproject.tasks.TodoTasks.securityConfig.JwtTokenGenerate;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired private JwtTokenGenerate jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
//    
//    @Autowired JwtObjectResponse jwtResponse;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employee) {
		return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	  @PostMapping("/login")
	    public ResponseEntity<JwtObjectResponse> authenticateAndGetToken(@RequestBody LoginDto authRequest) {
	        Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
	        );
	        if (authentication.isAuthenticated()) {
	            return ResponseEntity.ok( new JwtObjectResponse(jwtService.generateToken(authRequest.getEmail())));
	        } else {
	            throw new EmployeeNotFound("Invalid user request!");
	        }
	    }
	  
	  
	
}

