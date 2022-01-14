package io.javabrains.springsecurityfacebooklogin.auth;

import java.util.Optional;

import io.javabrains.springsecurityfacebooklogin.model.Users;
/**
 * 
 * @author mmarinkovic
 *
 */
public interface ApplicationUserDao {
	public Optional<Users> selectApplicationUserByUsername(String username);
}
