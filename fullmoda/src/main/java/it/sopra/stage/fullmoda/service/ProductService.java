package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.entities.BaseProduct;
import it.sopra.stage.fullmoda.entities.ColorVariantProduct;
import it.sopra.stage.fullmoda.entities.SizeVariantProduct;

public interface ProductService {

	Iterable<BaseProduct> getProductList();
	
	BaseProduct findProduct(String code);
	
	Iterable<SizeVariantProduct> findSizeVariantProductList(String colorVariantCode);
	
	Iterable<ColorVariantProduct> findColorVariantProductList(String productCode);
}
