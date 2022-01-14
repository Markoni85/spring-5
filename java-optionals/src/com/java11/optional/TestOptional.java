package com.java11.optional;

import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
		Users user = new Users("Marko M", "mako@agency.com", 34);
		Optional<Users> optUser = Optional.ofNullable(user);
		optUser.ifPresent( u -> stampaj(user));
		
		Users users1 = new Users("Zika", "zika@email.com", 49);
		
		Users result = Optional.ofNullable(users1).orElse(createNewUser());
		Users result1 = Optional.ofNullable(users1).orElseGet( () -> createNewUser());
		
	}
	
	private static void stampaj(Users u) {
		System.out.println(u.fullName);
	}
	
	private static Users createNewUser() {
		System.out.println("Creating New User");
	    return new Users("JAmes B", "extra@gmail.com", 50);
	}
}

