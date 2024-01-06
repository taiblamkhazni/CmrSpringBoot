package com.example.demo.services;

import com.example.demo.dto.PersonDto;

public interface PersonService {

	PersonDto getPersonById(String id);
	PersonDto GetAchraf(String id);

	PersonDto getPersonById(String id, String name);
	

}
