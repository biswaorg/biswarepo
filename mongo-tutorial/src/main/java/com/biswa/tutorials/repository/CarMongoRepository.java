package com.biswa.tutorials.repository;

import org.springframework.data.repository.CrudRepository;

import com.biswa.tutorials.model.Car;

public interface CarMongoRepository extends CrudRepository<Car, String>{}