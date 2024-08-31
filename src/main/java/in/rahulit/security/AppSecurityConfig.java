package in.rahulit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/contact", "/swaggerui.html").permitAll()
				.anyRequest().authenticated()
				)
		.httpBasic(withDefaults())
		.formLogin(withDefaults());
		return http.build();
	}

	
	@Bean
	public InMemoryUserDetailsManager inMemoryUsers() {
		
		PasswordEncoder encoder = passwordEncoder();
		
		UserDetails user1 = User.withUsername("shahbaj")
								.password(encoder.encode("shahbaj"))
								.authorities("ADMIN")
								.build();
		
		UserDetails user2 = User.withUsername("Rahul")
								.password(encoder.encode("Rahul"))
								.authorities("USER")
								.build();
		
		return new InMemoryUserDetailsManager(user1, user2);
		
	}
	

}
