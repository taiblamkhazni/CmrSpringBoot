package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.FactureDto;

public interface FactureService {
	
	FactureDto getFactureByFactureId(String id,String email);

	FactureDto createFacture(FactureDto factureDto);
	FactureDto updateFacture(FactureDto factureDto,String id,String email);

	void deleteFacture(String id,String email);
	


	List<FactureDto> getAllFactures(int page, int limit, long id);

}
