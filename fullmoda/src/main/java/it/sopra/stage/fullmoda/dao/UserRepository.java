package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.sopra.stage.fullmoda.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);
	
	@Modifying
    @Query("update User u set u.password = :password where u.email = :email")
    void updatePassword(@Param("password") String password, @Param("email") String email);
}
