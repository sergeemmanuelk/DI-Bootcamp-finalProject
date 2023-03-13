package com.worolo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worolo.api.model.Municipality;
import com.worolo.api.repository.MunicipalityRepository;

@Service
public class MunicipalityService {
	@Autowired
	private MunicipalityRepository municipalityRepository;
	
	public List<Municipality> getAllMunicipality() {
		return municipalityRepository.findAll();
	}
	
	public Municipality getMunicipalityById(Long id) {
		return municipalityRepository.findById(id).orElse(null);
	}
	
	public Municipality createMunicipality(Municipality municipality) {
		return municipalityRepository.save(municipality);
	}
	
	public Municipality updateMunicipality(Long id, Municipality updatedMunicipality) {
		Municipality existingMunicipality = municipalityRepository.findById(id).orElse(null);
        if (existingMunicipality != null) {
        	existingMunicipality.setName(updatedMunicipality.getName());
        	existingMunicipality.setPhoneNumber(updatedMunicipality.getPhoneNumber());
        	existingMunicipality.setAddress(updatedMunicipality.getAddress());
        	existingMunicipality.setEmail(updatedMunicipality.getEmail());
            
            return municipalityRepository.save(existingMunicipality);
        }
        return null;
	}
	
	public boolean deleteMunicipality(Long id) {
		Municipality existingMunicipality = municipalityRepository.findById(id).orElse(null);
        if (existingMunicipality != null) {
        	municipalityRepository.delete(existingMunicipality);
            return true;
        }
        return false;
	}
}
