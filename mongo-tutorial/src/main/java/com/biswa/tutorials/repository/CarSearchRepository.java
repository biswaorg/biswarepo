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
	
	public Collection<Car> searchCars(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
						.orOperator(Criteria.where("description").regex(text, "i"), 
									Criteria.where("make").regex(text, "i"), 
									Criteria.where("model").regex(text, "i"))
						), Car.class);
	}
	
	
	//Get all car name starting with Maruti
	/*public Collection<Car> searchCarWithMake(){
		return mongoTemplate.find(new Query(Criteria.where("make").is("Maruti")),Car.class);
		//return mongoTemplate.find(Query.query(new Criteria().elemMatch(Criteria.where("make").is("Maruti"))), Car.class);
		
	}
	*/
	
	public Collection<Car> searchCarWithMake(){
		return mongoTemplate.find(new Query(Criteria.where("year").lt(2016)),Car.class);
		//return mongoTemplate.find(Query.query(new Criteria().elemMatch(Criteria.where("make").is("Maruti"))), Car.class);
		
	}
	
	/*


	List<CustomerPOJO> savedCustomer = mongoOperation.find(
			"customerDetails",
			new Query(Criteria.where("age").lte(21)),
			CustomerPOJO.class);
	System.out.println("Minor Customers : " + savedCustomer);
	

	
	//Customers greater than 21 years
	
	List<CustomerPOJO> savedCustomer2 = mongoOperation.find(
			"customerDetails",
			new Query(Criteria.where("age").gte(21)),
			CustomerPOJO.class);
	System.out.println("Major Customers : " + savedCustomer2);
	*/
}
