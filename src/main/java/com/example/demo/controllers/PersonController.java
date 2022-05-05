package com.example.demo.controllers;

import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.PersonReponse;
import com.example.demo.models.Person;
import com.example.demo.services.PersonService;
import com.example.demo.shared.Utils;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {
	
	//consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
	//produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
	//Service
	@Autowired
	PersonService personService;
	
	

	//getpersobyid
	
	@GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PersonReponse> getPerson(@PathVariable String id,Principal principal){
		
		ModelMapper modelMapper=new ModelMapper();
		
		PersonDto personDto=personService.getPersonById(id,principal.getName());
		
		PersonReponse personReponse=modelMapper.map(personDto, PersonReponse.class);
		
		return new ResponseEntity<PersonReponse>(personReponse,HttpStatus.OK);
	}
	//getallperson
	//@GetMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
	//produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	//public ResponseEntity<List<Person>> getAllPerson()
	//add
	//update
	//deleted

}
