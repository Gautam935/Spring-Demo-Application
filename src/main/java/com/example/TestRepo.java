package com.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TestRepo extends CrudRepository<Details, Long>{

	public Details save(Details product);
	public Details findProductDetailsByProductName(String pName);
	public List<Details> findAll();
}
