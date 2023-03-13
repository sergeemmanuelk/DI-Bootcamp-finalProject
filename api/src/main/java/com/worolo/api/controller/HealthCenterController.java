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

import com.worolo.api.model.HealthCenter;
import com.worolo.api.service.HealthCenterService;

@RestController
@RequestMapping("/api/healthcenter")
public class HealthCenterController {
	@Autowired
	private HealthCenterService hcService;
	
	@GetMapping
	public List<HealthCenter> getAllHealthCenter() {
		return hcService.getAllHealthCenter();
	}
	
	@GetMapping("/{id}")
	public HealthCenter getHealthCenterById(@PathVariable Long id) {
		return hcService.getHealthCenterById(id);
	}
	
	@PostMapping
	public HealthCenter createHealthCenter(@RequestBody HealthCenter healthCenter) {
		return hcService.createHealthCenter(healthCenter);
	}
	
	@PutMapping("/{id}")
	public HealthCenter updateHealthCenter(@PathVariable Long id, @RequestBody HealthCenter updatedHealthCenter) {
		return hcService.updateHealthCenter(id, updatedHealthCenter);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteHealthCenter(@PathVariable Long id) {
		return hcService.deleteHealthCenter(id);
	}
}
