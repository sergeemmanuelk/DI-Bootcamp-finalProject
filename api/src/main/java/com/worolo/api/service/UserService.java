package com.worolo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worolo.api.model.User;
import com.worolo.api.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(Long id, User updatedUser) {
		User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
        	existingUser.setGender(updatedUser.getGender());
        	existingUser.setFirstName(updatedUser.getFirstName());
        	existingUser.setLastName(updatedUser.getLastName());
        	existingUser.setEmail(updatedUser.getEmail());
        	existingUser.setPassword(updatedUser.getPassword());
        	existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        	existingUser.setAddress(updatedUser.getAddress());
            
            return userRepository.save(existingUser);
        }
        return null;
	}
	
	public boolean deleteUser(Long id) {
		User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        }
        return false;
	}
}
