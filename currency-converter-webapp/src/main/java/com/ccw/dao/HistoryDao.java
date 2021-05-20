package com.ccw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ccw.pojos.History;
@Repository
public interface HistoryDao extends CrudRepository<History, Integer> {
	//@Query("Select h from History h")
	@Override
	List<History>findAll();

}
