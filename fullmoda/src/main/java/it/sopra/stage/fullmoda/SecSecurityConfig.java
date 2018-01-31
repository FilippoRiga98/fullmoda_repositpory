package it.sopra.stage.fullmoda;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private DataSource dataSource;

	 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
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
         .usernameParameter("email")
         .passwordParameter("password")
         .loginProcessingUrl("/performlogin")
         .defaultSuccessUrl("/products")
         .successHandler(savedRequestAwareAuthenticationSuccessHandler())
         .failureUrl("/login?error=true")
         .and()
         .logout()
         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
         .invalidateHttpSession(true)
         .deleteCookies("JSESSIONID")
         .clearAuthentication(true)
         .logoutSuccessUrl("/login?logout=true")
         .and()
         .rememberMe()
         .key("uniqueAndSecret").rememberMeCookieName("myRemember").tokenValiditySeconds(24 * 60 * 60).userDetailsService(userDetailsService)
         .tokenRepository(persistentTokenRepository())
         .and().csrf();
   }	
	
  @Bean
  public PersistentTokenRepository persistentTokenRepository() {
      JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
      repo.setDataSource(dataSource);
      return repo;
  }
  
  @Bean
	public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {

      SavedRequestAwareAuthenticationSuccessHandler auth = new SavedRequestAwareAuthenticationSuccessHandler();
		auth.setTargetUrlParameter("targetUrl");
		return auth;
	}

}
