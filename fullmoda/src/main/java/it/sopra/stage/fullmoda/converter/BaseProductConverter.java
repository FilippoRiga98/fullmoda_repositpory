package it.sopra.stage.fullmoda.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.ColorVariantProductData;
import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.entities.BaseProduct;
import it.sopra.stage.fullmoda.entities.ColorVariantProduct;

@Component
public class BaseProductConverter {

	@Autowired
	private ColorVariantProductConverter colorVariantConverter;
	
	public ProductData convert(BaseProduct product) {
		List<ColorVariantProduct> colorVariants = product.getColorVariants();
		List<ColorVariantProductData> colorVariantDataList = new ArrayList<>();
		for(ColorVariantProduct colorVariant : colorVariants) {
			ColorVariantProductData colorVariantData = colorVariantConverter.convert(colorVariant);
			colorVariantDataList.add(colorVariantData);
		}
		
		return new ProductData(product.getCode(), product.getDescription(), colorVariantDataList);
	}

	

	
}
