package com.ccw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccw.dao.HistoryDao;
import com.ccw.pojos.History;

@Transactional
@Service
public class HistoryService {
	@Autowired
	HistoryDao hDao;

	public HistoryService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addHistory(History h) {
		hDao.save(h);
	}
	
	public List<History> fetchAllHistory(){
		return hDao.findAll();
	}
}
