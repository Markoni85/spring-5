package io.javabrains.springsecurityfacebooklogin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.javabrains.springsecurityfacebooklogin.model.Users;
import io.javabrains.springsecurityfacebooklogin.repository.UserDetailsRepository;
import io.javabrains.springsecurityfacebooklogin.security.ApplicationUserRole;

@SpringBootApplication
public class SpringsecurityFacebookLoginApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityFacebookLoginApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			List<Users> appUsers = new ArrayList<Users>(Arrays.asList(
					new Users("admin", passwordEncoder.encode("lozinka1"), true,
							ApplicationUserRole.ADMIN.getAuthoritiesStringRepresentation()),
					new Users("student", passwordEncoder.encode("lozinka1"), true,
							ApplicationUserRole.STUDENT.getAuthoritiesStringRepresentation()),
					new Users("trainee", passwordEncoder.encode("lozinka1"), true,
							ApplicationUserRole.ADMINTRAINEE.getAuthoritiesStringRepresentation())));

			userDetailsRepository.saveAll(appUsers);
			userDetailsRepository.flush();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
