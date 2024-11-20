package com.secondproject.tasks.TodoTasks.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class JwtObjectResponse {
  private String token;
  private String tokenType = "Bearer ";
  
  public JwtObjectResponse(String token) {
	  this.token = token;
  }
}
