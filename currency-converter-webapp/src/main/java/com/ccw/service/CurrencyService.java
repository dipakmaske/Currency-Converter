package com.ccw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccw.dao.CurrencyDao;
import com.ccw.pojos.Currency;

@Service
@Transactional
public class CurrencyService {
	@Autowired
	CurrencyDao cDao;

	public CurrencyService() {
		System.out.println("ctor " + getClass().getName());
	}

	public void convertHistory(Currency c) {
		cDao.save(c);
	}

}
