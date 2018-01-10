package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.entities.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
