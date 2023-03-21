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

import com.worolo.api.model.Citizen;
import com.worolo.api.service.CitizenService;

@RestController
@RequestMapping("/api/citoyen")
public class CitizenController {
	@Autowired
	private CitizenService citizenService;
	
	@GetMapping
	public List<Citizen> getAllCitizen() {
		return citizenService.getAllCitizen();
	}
	
	@GetMapping("/{id}")
	public Citizen getCitizenById(@PathVariable Long id) {
		return citizenService.getCitizenById(id);
	}
	
	@PostMapping
	public Citizen createCitizen(@RequestBody Citizen citizen) {
		return citizenService.createCitizen(citizen);
	}
	
	@PutMapping("/{id}")
	public Citizen updateCitizen(@PathVariable Long id, @RequestBody Citizen updatedCitizen) {
		return citizenService.updateCitizen(id, updatedCitizen);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCitizen(@PathVariable Long id) {
		return citizenService.deleteCitizen(id);
	}
}