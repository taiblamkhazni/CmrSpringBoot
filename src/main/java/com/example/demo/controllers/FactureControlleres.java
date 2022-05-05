package com.example.demo.controllers;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

import com.example.demo.dto.FactureDto;
import com.example.demo.dto.FactureReponse;
import com.example.demo.dto.FactureRequest;
import com.example.demo.dto.UserDto;
import com.example.demo.models.UsersEntity;
import com.example.demo.services.FactureService;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/factures")
public class FactureControlleres {

	@Autowired
	FactureService factureService;
	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<FactureReponse> getFacture(@PathVariable String id,Principal principal) {
		FactureDto factureDto = factureService.getFactureByFactureId(id,principal.getName());
		if (factureDto == null)
			throw new RuntimeException("La facture n'a pas Existé !");
		ModelMapper modelMapper = new ModelMapper();
		FactureReponse factureReponse = modelMapper.map(factureDto, FactureReponse.class);

		return new ResponseEntity<FactureReponse>(factureReponse, HttpStatus.OK);

	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<FactureReponse> createFacture(@RequestBody @Valid FactureRequest factureRequest) {
		if (factureRequest.getUsersEntity().getUserId() == null)
			throw new RuntimeException("User is null !");
		ModelMapper modelMapper = new ModelMapper();

		FactureDto factureDto = modelMapper.map(factureRequest, FactureDto.class);
		UserDto userDto = userService.getUserByUserId(factureRequest.getUsersEntity().getUserId());

		factureDto.setUser(userDto);
		FactureReponse factureReponse = modelMapper.map(factureService.createFacture(factureDto), FactureReponse.class);

		return new ResponseEntity<FactureReponse>(factureReponse, HttpStatus.CREATED);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<FactureReponse>> getAllFactures(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit, Principal principal) {
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = userService.getUser(principal.getName());
		List<FactureDto> factureDtos = factureService.getAllFactures(page, limit, userDto.getId());
		Type listType = new TypeToken<List<FactureReponse>>() {
		}.getType();
		List<FactureReponse> factureReponses = new ModelMapper().map(factureDtos, listType);

		return new ResponseEntity<List<FactureReponse>>(factureReponses, HttpStatus.OK);

	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<FactureReponse> updateFacture(@RequestBody @Valid FactureRequest factureRequest,
			@PathVariable String id,Principal principal) {
		
		
		
		ModelMapper modelMapper = new ModelMapper();

		FactureDto factureDto = modelMapper.map(factureRequest, FactureDto.class);

		FactureReponse factureReponse = modelMapper.map(factureService.updateFacture(factureDto, id,principal.getName()),
				FactureReponse.class);

		return new ResponseEntity<FactureReponse>(factureReponse, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deletedFacture(@PathVariable String id,Principal principal){
		
		factureService.deleteFacture(id,principal.getName());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

}
