package it.sopra.stage.fullmoda.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.ColorVariantProduct;

public interface ColorVariantProductRepository extends CrudRepository<ColorVariantProduct, String>{

	public List<ColorVariantProduct> findByBaseproductCode(String code);
}
