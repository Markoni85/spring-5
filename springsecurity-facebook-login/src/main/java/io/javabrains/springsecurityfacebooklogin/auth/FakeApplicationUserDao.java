package io.javabrains.springsecurityfacebooklogin.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import io.javabrains.springsecurityfacebooklogin.model.Users;
import io.javabrains.springsecurityfacebooklogin.security.ApplicationUserRole;

@Repository("fake")
public class FakeApplicationUserDao implements ApplicationUserDao {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public FakeApplicationUserDao(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<Users> selectApplicationUserByUsername(String username) {
		return getApplicationUsers().stream().filter(applicationUser -> applicationUser.getUserName().equals(username))
				.findFirst();
	}

	public List<Users> getApplicationUsers() {
		List<Users> appUsers = new ArrayList<Users>(Arrays.asList(
				new Users("admin", passwordEncoder.encode("lozinka1"), true,
						ApplicationUserRole.ADMIN.getAuthoritiesStringRepresentation()),
				new Users("student", passwordEncoder.encode("lozinka1"), true,
						ApplicationUserRole.STUDENT.getAuthoritiesStringRepresentation()),
				new Users("trainee", passwordEncoder.encode("lozinka1"), true,
						ApplicationUserRole.ADMINTRAINEE.getAuthoritiesStringRepresentation())));

		return appUsers;
	}
}
