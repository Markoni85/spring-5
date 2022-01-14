package io.javabrains.springsecurityfacebooklogin.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.javabrains.springsecurityfacebooklogin.model.Users;
import io.javabrains.springsecurityfacebooklogin.repository.UserDetailsRepository;

@Repository("jpa")
public class JpaApplicationUserDao implements ApplicationUserDao{

	@Autowired 
	private UserDetailsRepository detailsRepository; 
	
	@Override
	public Optional<Users> selectApplicationUserByUsername(String username) {
		// TODO Auto-generated method stub
		Optional<Users> users = detailsRepository.findByUserName(username);
		return users;
	}
}
