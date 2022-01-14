package io.javabrains.springsecurityfacebooklogin.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.javabrains.springsecurityfacebooklogin.model.ApplicationUser;
import io.javabrains.springsecurityfacebooklogin.model.Users;
/**
 * 
 * @author mmarinkovic
 *
 */
@Service
public class ApplicationUserService implements UserDetailsService {

	private final ApplicationUserDao applicationUserDao;
	
	@Autowired
	public ApplicationUserService(@Qualifier("jpa") ApplicationUserDao applicationUserDao) {
		this.applicationUserDao = applicationUserDao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<Users> users = applicationUserDao.selectApplicationUserByUsername(username);
		 
		users.orElseThrow( () -> new UsernameNotFoundException(String.format("Username %s not found", username)));
		
		return users.map(ApplicationUser::new).get();
	}

}
