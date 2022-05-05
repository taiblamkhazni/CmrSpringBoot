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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FactureDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.UsersEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.shared.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	Utils util;

	@Override
	public UserDto getUserByUserId(String id) {

		UsersEntity user = userRepository.findByUserId(id);

		ModelMapper modelMapper = new ModelMapper();

		UserDto userDto = modelMapper.map(user, UserDto.class);

		return userDto;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		ModelMapper modelMapper = new ModelMapper();

		UsersEntity user = userRepository.findByEmail(userDto.getEmail());

		if (user != null)
			throw new RuntimeException("User Alrady Exists !");
		
		
		
		
//	for (int i = 0; i < userDto.getFacture().size(); i++) {
//			
//			FactureDto factureDto=userDto.getFacture().get(i);
//			factureDto.setUser(userDto);
//			factureDto.setFactureId(util.generateStringId(32));
//			userDto.getFacture().set(i, factureDto);
//			
//		}

		user = modelMapper.map(userDto, UsersEntity.class);
		
	
		

		user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

		user.setUserId(util.generateStringId(32));

		userDto = modelMapper.map(userRepository.save(user), UserDto.class);

		return userDto;

	}

	@Override
	public void deleteUser(String id) {

		UsersEntity user = userRepository.findByUserId(id);

		if (user == null)
			throw new RuntimeException("User Alrady Exists !");

		userRepository.delete(user);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UsersEntity UsersEntity = userRepository.findByEmail(email);

		if (UsersEntity == null)
			throw new UsernameNotFoundException(email);

		return new User(UsersEntity.getEmail(), UsersEntity.getEncryptedPassword(), new ArrayList<>());
	}

	@Override
	public UserDto getUser(String email) {

		UsersEntity UsersEntity = userRepository.findByEmail(email);

		if (UsersEntity == null)
			throw new UsernameNotFoundException(email);

		ModelMapper modelMapper = new ModelMapper();

		UserDto userDto = modelMapper.map(UsersEntity, UserDto.class);

		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers(int page, int limit) {
		if (page > 0)
			page = page - 1;

		

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<UsersEntity> userPage;

//		if (search.isEmpty()) {
			userPage = userRepository.findAll(pageableRequest);
//		} else {
//
//			userPage = userRepository.findAllUserByCriteria(pageableRequest, search, status);
//		}

		List<UsersEntity> users = userPage.getContent();
		
		Type listType = new TypeToken<List<UserDto>>() {}.getType();
		List<UserDto> usersDto = new ModelMapper().map(users, listType);

		

		return usersDto;
	}

}
