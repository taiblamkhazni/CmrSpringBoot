package com.example.demo.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto getUserByUserId(String id);

	UserDto createUser(UserDto userDto);

	void deleteUser(String id);
	
	UserDto getUser(String email);

	List<UserDto> getAllUsers(int page, int limit);
	
	
	

}
