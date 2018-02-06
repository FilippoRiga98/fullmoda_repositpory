package it.sopra.stage.fullmoda.service;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.sopra.stage.fullmoda.dao.UserRepository;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.model.User;

@Service("userDetailsService")
public class DefaultUserDetailsService implements UserDetailsService,UserService {
 
	private static final Logger LOG = Logger.getLogger(DefaultUserDetailsService.class);
	
   @Autowired
   private UserRepository userRepository;
    
   @Override
   public UserDetails loadUserByUsername(String email) {
   	LOG.info("Searching for user with email: " + email);
      User user = userRepository.findByEmail(email);
      if (user == null) {
          throw new UsernameNotFoundException(email);
      }
      return user;
   }

	@Override
	public boolean save(User user)
	{
		try {
			userRepository.save(user);
		} 
		catch(DataIntegrityViolationException e) {
			LOG.error("Violation of data integrity: " + e.getMessage());
			return false;
		}
		catch(HibernateException ex) {
			LOG.error("Hibernate exception: " + ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	@Override
   public void updatePassword(String password, String email) {
       userRepository.updatePassword(password, email);
   }
	
	@Override
	public User validateUser(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	@Override
	public User validateUser(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User registerUser(User user) throws UserAlreadyRegistered{
		User savedUser = null;
		try {
			savedUser = userRepository.save(user);
			
		}catch(DataIntegrityViolationException e) {
			
			LOG.warn(String.format("User email %s already registered, exception: %s", user.getEmail(), e.getMessage()));
			throw new UserAlreadyRegistered(String.format("User email %s already registered", user.getEmail()));
		}
		return savedUser;
	}
   

}
