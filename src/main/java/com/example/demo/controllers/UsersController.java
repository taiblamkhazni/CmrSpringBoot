package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ErrorMessages;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserReponse;
import com.example.demo.dto.UserRequest;
import com.example.demo.exception.UserException;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserReponse> getUser(@PathVariable String id) {

		UserDto userDto = userService.getUserByUserId(id);

		ModelMapper modelMapper = new ModelMapper();

		UserReponse userReponse = modelMapper.map(userDto, UserReponse.class);

		return new ResponseEntity<UserReponse>(userReponse, HttpStatus.OK);

	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<UserReponse>> getAllUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {
		List<UserReponse> usersReponse = new ArrayList<>();

		List<UserDto> users = userService.getAllUsers(page, limit);

		for (UserDto userDto : users) {

			ModelMapper modelMapper = new ModelMapper();
			UserReponse userResponse = modelMapper.map(userDto, UserReponse.class);

			usersReponse.add(userResponse);
		}

		return new ResponseEntity<List<UserReponse>>(usersReponse, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserReponse> createUser(@RequestBody @Valid UserRequest userRequest) {
//		if (userRequest.getEmail().isEmpty())
//			throw new UserException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

		ModelMapper modelMapper = new ModelMapper();

		UserDto userDto = modelMapper.map(userRequest, UserDto.class);

		UserReponse userReponse = modelMapper.map(userService.createUser(userDto), UserReponse.class);

		return new ResponseEntity<UserReponse>(userReponse, HttpStatus.CREATED);
	}

//	@PutMapping
//	public UserReponse updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
//		
//		
//		
//		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		userService.deleteUser(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
