package io.javabrains.springsecurityfacebooklogin.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUser implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationUser(
			String username,
			String password, 
			Collection<? extends GrantedAuthority> grantedAuthorities, 
			boolean isAccountNonExpired,
			boolean isAccountNonLocked, 
			boolean isCredentialsNonExpired
		) {
		this.grantedAuthorities = grantedAuthorities;
		this.password = password;
		this.username = username;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}
	
	public ApplicationUser(Users users) {
		this.password = users.getPassword();
		this.username = users.getUserName();
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = users.isActive();
		this.isCredentialsNonExpired = true;
		this.grantedAuthorities = Arrays.stream(users.getRoles().split(";"))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	private Collection<? extends GrantedAuthority> grantedAuthorities;
	private String password;
	private String username;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
