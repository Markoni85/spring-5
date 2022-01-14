package io.javabrains.springsecurityfacebooklogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javabrains.springsecurityfacebooklogin.model.Users;

public interface UserDetailsRepository extends JpaRepository<Users, Long> {

	public Optional<Users> findByUserName(String username);
}
