package io.javabrains.springsecurityfacebooklogin.jwt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * 
 * @author mmarinkovic Class to verify credentials
 * 
 */
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		try {
			UsernameAndPasswordAuthRequest authRequest = new ObjectMapper().readValue(request.getInputStream(),
					UsernameAndPasswordAuthRequest.class);

			Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
					authRequest.getPassword());

			Authentication auth = authenticationManager.authenticate(authentication);
			return auth;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String secretKey = "markoni85markoni85markoni85markoni85markoni85markoni85markoni85markoni85markoni85markoni85markoni85markoni85";
		
		String jwtToken = Jwts.builder()
			.setSubject(authResult.getName())
			.claim("authorities", authResult.getAuthorities())
			.setIssuedAt(new Date())
			.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
			.signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
			.compact();
		
		
		response.addHeader("Authorization", "Bearer " + jwtToken);
	}
	
}
