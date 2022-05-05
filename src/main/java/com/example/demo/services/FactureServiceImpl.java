package com.example.demo.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FactureDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.Facture;

import com.example.demo.repository.FactureRepository;
import com.example.demo.shared.Utils;

@Service
public class FactureServiceImpl implements FactureService {

	@Autowired
	FactureRepository factureRepository;

	@Autowired
	Utils util;

	@Autowired
	UserService userService;

	@Override
	public FactureDto getFactureByFactureId(String idFacture,String email) {
		ModelMapper modelMapper = new ModelMapper();
		
		UserDto userDto=userService.getUser(email);

		Facture facture = factureRepository.findByFactureId(idFacture,userDto.getId());

		FactureDto factureDto = modelMapper.map(facture, FactureDto.class);
		return factureDto;
	}

	@Override
	public FactureDto createFacture(FactureDto factureDto) {
		ModelMapper modelMapper = new ModelMapper();

		Facture facture = factureRepository.findByRefFact(factureDto.getRefFact());

		if (facture != null)
			throw new RuntimeException("Facture déja Existé !");

		facture = modelMapper.map(factureDto, Facture.class);
		facture.setFactureId(util.generateStringId(32));

		factureDto = modelMapper.map(factureRepository.save(facture), FactureDto.class);

		return factureDto;
	}

	@Override
	public void deleteFacture(String id,String email) {
		UserDto userDto=userService.getUser(email);
		Facture facture=factureRepository.findByFactureId(id,userDto.getId());
		
		if (facture == null)
			throw new RuntimeException("La facture n'existe pas !");
		
		factureRepository.delete(facture);

	}

	@Override
	public List<FactureDto> getAllFactures(int page, int limit,long id) {
		if (page > 0)
			page = page - 1;
		
		ModelMapper modelMapper = new ModelMapper();
		

		Pageable pageableRequest = PageRequest.of(page, limit);

		//Page<Facture> factures = factureRepository.findAll(pageableRequest);
		
		Page<Facture>  factures=factureRepository.findByUserId(id, pageableRequest);
		
		

		List<Facture> factureList = factures.getContent();
		
		Type listType = new TypeToken<List<FactureDto>>() {}.getType();
		List<FactureDto> factureDtos = new ModelMapper().map(factureList, listType);
		

		return factureDtos;
	}

	@Override
	public FactureDto updateFacture(FactureDto factureDto,String id,String email) {
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto=userService.getUser(email);
		
		Facture facture=factureRepository.findByFactureId(id,userDto.getId());
		if (facture == null)
			throw new RuntimeException("La facture n'a pas Existé !");
		
		facture.setRefFact(factureDto.getRefFact());
		facture.setDatefact(factureDto.getDatefact());
		
		factureDto=modelMapper.map(factureRepository.save(facture), FactureDto.class);
		
		
		
		return factureDto;
	}

}
