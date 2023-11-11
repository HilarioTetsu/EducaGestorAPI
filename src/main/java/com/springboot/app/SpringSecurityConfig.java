package com.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.app.auth.filter.JWTAuthenticationFilter;
import com.springboot.app.models.services.JpaUserDetailsService;

@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig {


	
    @Autowired
    private JpaUserDetailsService userDetailService;
  
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;
	
    
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Autowired
    public void userDetailsService(AuthenticationManagerBuilder build) throws Exception {
       build.userDetailsService(userDetailService)
       .passwordEncoder(passwordEncoder());
    }
    
	 @Bean
	    public static BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 
     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	 
         http
         .authorizeHttpRequests((authz) -> {
             try {
                 authz.
                 requestMatchers("/", "/css/**", "/js/**", "/images/**", "/educagestor/v1/**","/locale","/login").permitAll()
                     .anyRequest().authenticated()
                     .and()
                     .addFilterBefore(new JWTAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                     .csrf().disable()
                     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

             } catch (Exception e) {
                     e.printStackTrace();
             }
         });
    	 
/*       http.authorizeHttpRequests()
             .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/educagestor/v1/**","/locale","/login").permitAll()
             .anyRequest().authenticated()
             .and()
             .addFilter(new JWTAuthenticationFilter(authenticationManager()))
             .csrf().disable()
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
       
       return http.build();
    }
	
}
