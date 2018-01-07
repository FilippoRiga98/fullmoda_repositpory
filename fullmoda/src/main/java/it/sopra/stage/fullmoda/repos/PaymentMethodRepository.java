package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.PaymentMethod;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, String> {

}
