package it.sopra.stage.fullmoda;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionManager;
import org.springframework.session.web.http.HttpSessionStrategy;

import it.sopra.stage.fullmoda.listeners.DefaultSpringSessionStrategy;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AuthenticationProvider defaultAuthenticationProvider;
	
	 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.authenticationProvider(defaultAuthenticationProvider)
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder()); 
	}
	
	@Override
   protected void configure(HttpSecurity http) throws Exception {
       http
         .authorizeRequests()
         	.antMatchers("/my-account*", "/checkout*").authenticated()
         	.antMatchers("/**").permitAll()
         .and().formLogin()
         	.loginPage("/login")
         		.usernameParameter("email")
      			.passwordParameter("password")
   			.loginProcessingUrl("/performlogin")
				.defaultSuccessUrl("/products")
					.successHandler(savedRequestAwareAuthenticationSuccessHandler())
				.failureUrl("/login?error=true")
         .and().logout()
         	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
         	.invalidateHttpSession(true)
         	.deleteCookies("JSESSIONID")
         	.clearAuthentication(true)
         	.logoutSuccessUrl("/login?logout=true");
       
       	http
         .rememberMe()
         	.key("uniqueAndSecret")
         	.rememberMeCookieName("myRemember").tokenValiditySeconds(24 * 60 * 60)
         	.userDetailsService(userDetailsService)
         	.tokenRepository(persistentTokenRepository());
         
         http.csrf();
         
         http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
         	.sessionFixation().migrateSession();
         
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
  
  @Bean
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
  
  @Bean
  public HttpSessionStrategy httpSessionStrategy(){
	  return new DefaultSpringSessionStrategy();
  }
  
  @Bean
  public HttpSessionManager htppSessionManager() {
	  return new CookieHttpSessionStrategy();
  }
 
}
