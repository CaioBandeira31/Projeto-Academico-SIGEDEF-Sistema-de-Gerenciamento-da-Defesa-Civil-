package edu.sistema.sigedef.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
public class WebSecurityConfig {
  
  @Bean 
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {

      return http.authorizeHttpRequests((authorize) -> {
        authorize.requestMatchers("/tel/**", "/css/**", "/imagens/**", "/js/**").permitAll();
        authorize.requestMatchers("/login", "/css/**", "/imagens/**").permitAll();
        // authorize.requestMatchers("/dashboard", "/css/**", "/imagens/**" ,"/js/**").
        authorize.anyRequest().authenticated();
      })
      .formLogin(form -> form.loginPage("/login").permitAll())
      .build();
  } 

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
