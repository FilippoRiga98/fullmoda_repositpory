package it.sopra.stage.fullmoda.facade;

import java.util.List;
import java.util.Optional;

import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.form.ProductForm;

public interface ProductFacade {

	List<ProductData> getProductList();
	
	ProductData findProduct(String code);
	
	List<ProductData> getProductList(String currency);
	
	ProductData findProduct(String code, String currency);

	Optional<SizeVariantProductData> searchSizeVariant(ProductData product, ProductForm productForm);
}
