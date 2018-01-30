package it.sopra.stage.fullmoda;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserDetailsService userDetailsService;

	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);  
	}
	
	@Override
   protected void configure(HttpSecurity http) throws Exception {
       http
         .authorizeRequests()
         .antMatchers("/my-account*").authenticated()
         .antMatchers("/**").permitAll()
         .and()
         .formLogin()
         .loginPage("/login")
         .loginProcessingUrl("/performlogin")
         .usernameParameter("email")
         .passwordParameter("password")
         .defaultSuccessUrl("/products", true)
         .failureUrl("/login?error=true")
         .and()
         .logout()
         .invalidateHttpSession(true)
         .clearAuthentication(true)
         .logoutSuccessUrl("/login?logout=true")
         .and()
         .rememberMe()
         .key("remember-me").tokenValiditySeconds(86400)
         .and()
         .csrf().disable();
   }	
}
