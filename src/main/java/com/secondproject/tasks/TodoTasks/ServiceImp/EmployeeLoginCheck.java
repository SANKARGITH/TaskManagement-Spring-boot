package com.secondproject.tasks.TodoTasks.ServiceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.secondproject.tasks.TodoTasks.Entity.Employee;
import com.secondproject.tasks.TodoTasks.Respository.EmployeeRespository;

@Service
public class EmployeeLoginCheck implements UserDetailsService{
	 
	@Autowired
	EmployeeRespository empRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> userDetail = empRepo.findByEmail(username); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
	
	
	
}
