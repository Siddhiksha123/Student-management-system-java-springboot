package com.student.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        // Allow Swagger UI and API Docs to be public
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**",
                                "/swagger-ui.html")
                        .permitAll()
                        // We are permitting all GET requests to /students to be public
                        .requestMatchers(HttpMethod.GET, "/students/**").permitAll()
                        // Any other request (POST, PUT, DELETE, etc.) must be authenticated
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults()); // Also enable basic auth for tools like Postman

        // Note: For POST/PUT/DELETE to work correctly without a frontend,
        // you might need to disable CSRF. I am leaving it enabled by default as a best
        // practice,
        // but if you get 403 Forbidden on POST requests in Postman, you would add:
        // .csrf(csrf -> csrf.disable())

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User.withUsername("admin")
                .password(passwordEncoder.encode("pass"))
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("patient")
                .password(passwordEncoder.encode("pass"))
                .roles("PATIENT")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
