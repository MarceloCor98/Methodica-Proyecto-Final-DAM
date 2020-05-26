package com.methodica.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/registrProfesor","/nuevoCurso","/eliminarCurso/**","/editarCurso/**").hasRole("ADMIN")
			.antMatchers("/nuevoTema/**","/editarTema/**","/eliminarTema/**",
					"/nuevoApartado/**,/editarApartado/**","/eliminarApartado/**",
					"/nuevoFichero/**","/eliminarFichero/**")
			.hasAnyRole("ADMIN","PROFESOR")
			.antMatchers("/curso/**","/apartado/**","/descargarFichero/**").hasAnyRole("ADMIN","ALUMNO","PROFESOR")
			.antMatchers("/","/login","/registro","/addAdmin","/addAdmin/submit").permitAll()
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/inicio", true)
			.and().
			logout().logoutSuccessUrl("/login");
    }
}
