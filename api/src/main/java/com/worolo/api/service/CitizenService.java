package com.worolo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worolo.api.model.Citizen;
import com.worolo.api.repository.CitizenRepository;

@Service
public class CitizenService {
	@Autowired
	private CitizenRepository citizenRepository;
	
	public List<Citizen> getAllCitizen() {
		return citizenRepository.findAll();
	}
	
	public Citizen getCitizenById(Long id) {
		return citizenRepository.findById(id).orElse(null);
	}
	
	public Citizen createCitizen(Citizen citizen) {
		return citizenRepository.save(citizen);
	}
	
	public Citizen updateCitizen(Long id, Citizen updatedCitizen) {
		Citizen existingCitizen = citizenRepository.findById(id).orElse(null);
        if (existingCitizen != null) {
        	existingCitizen.setGender(updatedCitizen.getGender());
        	existingCitizen.setFirstName(updatedCitizen.getFirstName());
        	existingCitizen.setLastName(updatedCitizen.getLastName());
        	existingCitizen.setEmail(updatedCitizen.getEmail());
        	existingCitizen.setPassword(updatedCitizen.getPassword());
        	existingCitizen.setBirthdate(updatedCitizen.getBirthdate());
        	existingCitizen.setPhoneNumber(updatedCitizen.getPhoneNumber());
        	existingCitizen.setAddress(updatedCitizen.getAddress());
            
            return citizenRepository.save(existingCitizen);
        }
        return null;
	}
	
	public boolean deleteCitizen(Long id) {
		Citizen existingCitizen = citizenRepository.findById(id).orElse(null);
        if (existingCitizen != null) {
        	citizenRepository.delete(existingCitizen);
            return true;
        }
        return false;
	}
}