package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.CartEntry;

public interface CartEntryRepository extends CrudRepository<CartEntry, Long> {

}
