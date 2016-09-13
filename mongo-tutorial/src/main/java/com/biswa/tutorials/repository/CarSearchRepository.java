package com.biswa.tutorials.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.biswa.tutorials.model.Car;

@Repository
public class CarSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	// Get car information based on any string using regular expression
	public Collection<Car> searchCars(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
						.orOperator(Criteria.where("description").regex(text, "i"), 
									Criteria.where("make").regex(text, "i"), 
									Criteria.where("model").regex(text, "i"))
						), Car.class);
	}
	
	
	//Get all car name starting with Brand Name
	public Collection<Car> searchCarWithMake(String brand){
		return mongoTemplate.find(new Query(Criteria.where("make").is(brand)),Car.class);
		
	}
	
	// Get all car info less than the year of Manufacture
	public Collection<Car> searchCarWithMake(int year){
		return mongoTemplate.find(new Query(Criteria.where("year").lt(year)),Car.class);
		
	}
	
	
}
