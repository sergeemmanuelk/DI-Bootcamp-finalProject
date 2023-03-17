package com.worolo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worolo.api.model.CityHall;
import com.worolo.api.service.CityHallService;

@RestController
@RequestMapping("/api/mairie")
public class CityHallController {
	@Autowired
	private CityHallService cityHallService;
	
	@GetMapping
	public List<CityHall> getAllCityHall() {
		return cityHallService.getAllCityHall();
	}
	
	@GetMapping("/{id}")
	public CityHall getCityHallById(@PathVariable Long id) {
		return cityHallService.getCityHallById(id);
	}
	
	@PostMapping
	public CityHall createCityHall(@RequestBody CityHall cityHall) {
		return cityHallService.createCityHall(cityHall);
	}
	
	@PutMapping("/{id}")
	public CityHall updateCityHall(@PathVariable Long id, @RequestBody CityHall updatedCityHall) {
		return cityHallService.updateCityHall(id, updatedCityHall);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCityHall(@PathVariable Long id) {
		return cityHallService.deleteCityHall(id);
	}
}
