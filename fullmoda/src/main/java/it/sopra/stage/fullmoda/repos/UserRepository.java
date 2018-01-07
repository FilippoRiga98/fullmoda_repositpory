package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByEmail(String email);
}
