package it.sopra.stage.fullmoda.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.BaseProduct;

public interface BaseProductRepository extends CrudRepository<BaseProduct, String> {
	
	BaseProduct findByCode(String code);
	List<BaseProduct> findByOnlineDateAfterAndOfflineDateBefore(Date onlineDate, Date offlineDate);
	
}
