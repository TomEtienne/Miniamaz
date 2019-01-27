package com.example.dto;

public class UserDto {
	
	private Long userId;
    private String firstname;
    private String lastname;
    private String email;

    public UserDto() {
    }
    
    public Long getId() {
    	return userId;
    }
    
    public void setId(Long i) {
    	this.userId  = i;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
