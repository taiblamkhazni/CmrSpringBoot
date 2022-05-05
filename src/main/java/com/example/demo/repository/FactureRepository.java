package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Facture;


@Repository
public interface FactureRepository extends PagingAndSortingRepository<Facture, Long>{
	
	Facture findByRefFact(String refFact);
	//Facture findByFactureId(String factureId);
	
	Page<Facture> findByUserId(long id, Pageable pageable);
	
	@Query(value = "SELECT * FROM facture f WHERE f.facture_id=:factureId AND f.users_id=:userId",nativeQuery = true)
	Facture findByFactureId(@Param("factureId") String idFacture,@Param("userId") long id);
	
	

}
