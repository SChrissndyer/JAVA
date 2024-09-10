package org.example.day81.dto;

class UserDetails {
	private String username;
	private String email;
	private Integer id;
	public UserDetails(String username, String email, Integer id) {
		this.username = username;
		this.email = email;
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

public class UserLoginResponseDto {
	private boolean success;
	private String message;
	private String token;
	private UserDetails teacher;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserDetails getTeacher() {
		return teacher;
	}
	public void setTeacher(String username, String email, Integer id) {
		this.teacher = new UserDetails(username, email, id);
	}
	
	
}
