package com.worolo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worolo.api.model.CityHall;
import com.worolo.api.repository.CityHallRepository;

@Service
public class CityHallService {
	@Autowired
	private CityHallRepository cityHallRepository;
	
	public List<CityHall> getAllCityHall() {
		return cityHallRepository.findAll();
	}
	
	public CityHall getCityHallById(Long id) {
		return cityHallRepository.findById(id).orElse(null);
	}
	
	public CityHall createCityHall(CityHall cityHall) {
		return cityHallRepository.save(cityHall);
	}
	
	public CityHall updateCityHall(Long id, CityHall updatedCityHall) {
		CityHall existingCityHall = cityHallRepository.findById(id).orElse(null);
        if (existingCityHall != null) {
        	existingCityHall.setName(updatedCityHall.getName());
        	existingCityHall.setEmail(updatedCityHall.getEmail());
        	existingCityHall.setPassword(updatedCityHall.getPassword());
        	existingCityHall.setPhoneNumber(updatedCityHall.getPhoneNumber());
        	existingCityHall.setAddress(updatedCityHall.getAddress());
            
            return cityHallRepository.save(existingCityHall);
        }
        return null;
	}
	
	public boolean deleteCityHall(Long id) {
		CityHall existingCityHall = cityHallRepository.findById(id).orElse(null);
        if (existingCityHall != null) {
        	cityHallRepository.delete(existingCityHall);
            return true;
        }
        return false;
	}
}
