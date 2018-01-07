package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.SizeVariantProduct;

public interface SizeVariantProductRepository extends CrudRepository<SizeVariantProduct, String>{

	public Iterable<SizeVariantProduct> findByColorVariantProductCode(String code);
}
