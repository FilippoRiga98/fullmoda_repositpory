package it.sopra.stage.fullmoda.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.model.Size;
import it.sopra.stage.fullmoda.model.SizeVariantProduct;

@Component
public class SizeVariantProductConverter {

	@Autowired
	private SizeConverter sizeConverter;
	
	public SizeVariantProductData convert(SizeVariantProduct product) {

		String code = product.getCode();
		Size size = product.getSize();
		return new SizeVariantProductData(code, sizeConverter.convert(size));

	}
	
	public SizeVariantProduct convert(SizeVariantProductData source) {
		SizeVariantProduct target = new SizeVariantProduct();
		target.setCode(source.getCode());
		target.setSize(sizeConverter.convert(source.getSize()));
		return target;
	}
	

}
