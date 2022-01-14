package io.javabrains.springsecurityfacebooklogin.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRole {
	STUDENT(new HashSet<ApplicationUserPermission>()),
	ADMIN(new HashSet<ApplicationUserPermission>(
			Arrays.asList(
					ApplicationUserPermission.COURSE_READ, 
					ApplicationUserPermission.COURSE_WRITE,
					ApplicationUserPermission.STUDENT_READ,
					ApplicationUserPermission.STUDENT_WRITE)
			)),
	ADMINTRAINEE(new HashSet<ApplicationUserPermission>(
					Arrays.asList(ApplicationUserPermission.COURSE_READ,
					ApplicationUserPermission.STUDENT_READ)
			));
 
	private final Set<ApplicationUserPermission> permissions;

	ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return this.permissions;
	}
	
	public Set<SimpleGrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> authorities = this.permissions.stream()
				.map( permission -> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
		
		authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		
		return authorities;
	}
	
	public String getAuthoritiesStringRepresentation() {
		String  authorities = "";
		authorities = this.permissions
				.stream()
				.map( p-> p.getPermission())
				.reduce((p1, p2) -> p1.concat(";" + p2)).orElse("");
		
		authorities += ";" + "ROLE_" + this.name();
		
		return authorities;
	}
}
