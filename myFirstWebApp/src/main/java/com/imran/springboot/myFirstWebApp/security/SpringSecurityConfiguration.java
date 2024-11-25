package com.imran.springboot.myFirstWebApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails userdetails1 = createNewUser("Imran", "12345");
        UserDetails userdetails2 = createNewUser("Imran1", "12346");
        return new InMemoryUserDetailsManager(userdetails1,userdetails2);
    }

    
    private UserDetails createNewUser(String username, String password) {
        PasswordEncoder encoder = passwordEncoder();  
        String encodedPassword = encoder.encode(password); 

        UserDetails userdetails = User
                .builder()
                .username(username)
                .password(encodedPassword)  // Use the encoded password
                .roles( "USER", "ADMIN")
                .build();
        
        return userdetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated()
        );
        http.formLogin(withDefaults());
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }
}
