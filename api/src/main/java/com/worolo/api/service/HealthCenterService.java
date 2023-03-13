package com.worolo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worolo.api.model.HealthCenter;
import com.worolo.api.repository.HealthCenterRepository;

@Service
public class HealthCenterService {
	@Autowired
	private HealthCenterRepository hcRepository;
	
	public List<HealthCenter> getAllHealthCenter() {
		return hcRepository.findAll();
	}
	
	public HealthCenter getHealthCenterById(Long id) {
		return hcRepository.findById(id).orElse(null);
	}
	
	public HealthCenter createHealthCenter(HealthCenter healthCenter) {
		return hcRepository.save(healthCenter);
	}
	
	public HealthCenter updateHealthCenter(Long id, HealthCenter updatedHealthCenter) {
		HealthCenter existingHealthCenter = hcRepository.findById(id).orElse(null);
        if (existingHealthCenter != null) {
        	existingHealthCenter.setName(updatedHealthCenter.getName());
        	existingHealthCenter.setPhoneNumber(updatedHealthCenter.getPhoneNumber());
        	existingHealthCenter.setAddress(updatedHealthCenter.getAddress());
        	existingHealthCenter.setEmail(updatedHealthCenter.getEmail());
            
            return hcRepository.save(existingHealthCenter);
        }
        return null;
	}
	
	public boolean deleteHealthCenter(Long id) {
		HealthCenter existingHealthCenter = hcRepository.findById(id).orElse(null);
        if (existingHealthCenter != null) {
        	hcRepository.delete(existingHealthCenter);
            return true;
        }
        return false;
	}
}
