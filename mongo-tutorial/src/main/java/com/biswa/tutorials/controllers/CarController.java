package com.biswa.tutorials.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biswa.tutorials.model.Car;
import com.biswa.tutorials.repository.CarMongoRepository;
import com.biswa.tutorials.repository.CarSearchRepository;

@Controller
public class CarController {

	@Autowired
	CarMongoRepository carRepository;
	
	@Autowired
	CarSearchRepository carSearchRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("carList", carRepository.findAll());
		return "home";
	}
	
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String addCar(@ModelAttribute Car car) {
		carRepository.save(car);
		return "redirect:home";
	}
	
	@RequestMapping(value = "/search")
	public String searchWithAnyString(Model model, @RequestParam String search) {
		model.addAttribute("carList", carSearchRepository.searchCars(search));
		model.addAttribute("search", search);
		return "home";
	}
	
	@RequestMapping(value = "/searchBrand")
	public String search(Model model, @RequestParam String brand) {
		model.addAttribute("carList", carSearchRepository.searchCarWithMake(brand));
		model.addAttribute("brand", brand);
		return "home";
	}
	
	@RequestMapping(value = "/searchLessThanYear")
	public String search(Model model, @RequestParam int year) {
		model.addAttribute("carList", carSearchRepository.searchCarWithMake(year));
		model.addAttribute("year", year);
		return "home";
	}
	
}
