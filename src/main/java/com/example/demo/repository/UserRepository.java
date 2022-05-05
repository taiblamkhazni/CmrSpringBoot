package com.example.demo.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UsersEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UsersEntity, Long>{
	
	
	UsersEntity findByUserId(String UsersEntityId);
	UsersEntity findByEmail(String email);

}
