package com.ccw.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ccw.pojos.Currency;

@Repository
public interface CurrencyDao extends CrudRepository<Currency, Integer> {

	
}
