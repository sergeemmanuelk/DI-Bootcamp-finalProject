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
import com.worolo.api.model.Municipality;
import com.worolo.api.service.MunicipalityService;

@RestController
@RequestMapping("/api/municipality")
public class MunicipalityController {
	@Autowired
	private MunicipalityService municipalityService;
	
	@GetMapping
	public List<Municipality> getAllMunicipality() {
		return municipalityService.getAllMunicipality();
	}
	
	@GetMapping("/{id}")
	public Municipality getMunicipalityById(@PathVariable Long id) {
		return municipalityService.getMunicipalityById(id);
	}
	
	@PostMapping
	public Municipality createMunicipality(@RequestBody Municipality municipality) {
		return municipalityService.createMunicipality(municipality);
	}
	
	@PutMapping("/{id}")
	public Municipality updateMunicipality(@PathVariable Long id, @RequestBody Municipality updatedMunicipality) {
		return municipalityService.updateMunicipality(id, updatedMunicipality);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteMunicipality(@PathVariable Long id) {
		return municipalityService.deleteMunicipality(id);
	}
}
