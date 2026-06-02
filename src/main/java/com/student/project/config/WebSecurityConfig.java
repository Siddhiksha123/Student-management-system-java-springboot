// package com.student.project.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.Customizer;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class WebSecurityConfig {

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
// throws Exception {
// httpSecurity
// .authorizeHttpRequests(auth -> auth
// // Allow Swagger UI and API Docs to be public
// .requestMatchers("/v3/api-docs/**", "/swagger-ui/**",
// "/swagger-ui.html").permitAll()
// // We are permitting all GET requests to /students to be public
// .requestMatchers(HttpMethod.GET, "/students/**").permitAll()
// // Any other request (POST, PUT, DELETE, etc.) must be authenticated
// .anyRequest().authenticated()
// )
// .formLogin(Customizer.withDefaults())
// .httpBasic(Customizer.withDefaults()); // Also enable basic auth for tools
// like Postman

// // Note: For POST/PUT/DELETE to work correctly without a frontend,
// // you might need to disable CSRF. I am leaving it enabled by default as a
// best practice,
// // but if you get 403 Forbidden on POST requests in Postman, you would add:
// // .csrf(csrf -> csrf.disable())

// return httpSecurity.build();
// }
// }
