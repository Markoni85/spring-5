package io.javabrains.springsecurityfacebooklogin.security;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import io.javabrains.springsecurityfacebooklogin.auth.ApplicationUserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends  WebSecurityConfigurerAdapter {
   
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicationUserService applicationUserService;
	
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
		http.csrf().disable().authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name())
			.antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(ApplicationUserPermission.STUDENT_WRITE.getPermission())
			.antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(ApplicationUserPermission.STUDENT_WRITE.getPermission())
			.antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(ApplicationUserPermission.STUDENT_WRITE.getPermission())
			.antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.ADMINTRAINEE.name())
			.anyRequest()
			.authenticated()
			.and()
			//.httpBasic()
			.formLogin()
				.defaultSuccessUrl("/students")
				.loginPage("/login").permitAll()
			.and()
			.rememberMe()
				.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
				.key("secured_word")// for MD5 
		    .and()
		    .logout()
		    	.logoutUrl("/logout")
		    	.logoutRequestMatcher(new AntPathRequestMatcher("/logout", HttpMethod.GET.name()))
		    	.clearAuthentication(true)
		    	.invalidateHttpSession(true)
		    	.deleteCookies("JSESSIONID", "remember-me")
		    	.logoutSuccessUrl("/login");
	}
	
	// 2) hard coded in memory authentication
	/**  @Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails adminDetails = User
				.builder()
				.username("admin")
				.password(passwordEncoder().encode("lozinka1"))
				//.roles(ApplicationUserRole.ADMIN.name())
				.authorities(ApplicationUserRole.ADMIN.getAuthorities())
				.build();

		UserDetails userDetails = User
				.builder()
				.username("student")
				.password(passwordEncoder().encode("lozinka1"))
				//.roles(ApplicationUserRole.STUDENT.name())
				.authorities(ApplicationUserRole.STUDENT.getAuthorities())
				.build();
		
		
		
		UserDetails traineeUser = User
				.builder()
				.username("trainee")
				.password(passwordEncoder().encode("lozinka1"))
				//.roles(ApplicationUserRole.ADMINTRAINEE.name())
				.authorities(ApplicationUserRole.ADMINTRAINEE.getAuthorities())
				.build();

		
		InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager(userDetails, adminDetails, traineeUser);
		
		return detailsManager;
	} */
	
	// 2) In order to provide user details from external DB like Reddis, Postgres,...
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(applicationUserService);
		
		return provider;
	}
	
    //@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }
}
