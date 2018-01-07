package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.Color;

public interface ColorRepository extends CrudRepository<Color, String>{

	Color findByCode(String code);
}
