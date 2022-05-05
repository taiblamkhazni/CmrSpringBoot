package com.example.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PersonDto;
import com.example.demo.models.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.shared.Utils;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	Utils utils;

	@Override
	public PersonDto getPersonById(String id,String email) {
		Person person=personRepository.findByPersonId(id,email);
		if (person == null) throw new RuntimeException("La personne n'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		PersonDto personDto=modelMapper.map(person, PersonDto.class);
		
		return personDto;
	}

	@Override
	public PersonDto getPersonById(String id) {
		Person person=personRepository.findByPersonId(id);
		if (person == null) throw new RuntimeException("La personne n'existe pas");
		ModelMapper modelMapper=new ModelMapper();
		PersonDto personDto=modelMapper.map(person, PersonDto.class);
		
		return personDto;
	}

}
