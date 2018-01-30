package it.sopra.stage.fullmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.sopra.stage.fullmoda.dao.UserRepository;
import it.sopra.stage.fullmoda.model.User;

@Service("userDetailsService")
public class DefaultUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        
        return user;
    }
   

}
