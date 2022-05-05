package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Person;



@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

	Person findByPersonId(String id);

	@Query(value="SELECT * FROM person p WHERE p.person_id=:personId AND p.users_id=:userId",nativeQuery = true)
	Person findByPersonId(@Param("personId") String id,@Param("userId") String email);

}
