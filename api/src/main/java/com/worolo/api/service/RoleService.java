package com.worolo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worolo.api.model.Role;
import com.worolo.api.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}
	
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).orElse(null);
	}
	
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Role updateRole(Long id, Role updatedRole) {
		Role existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole != null) {
        	existingRole.setName(updatedRole.getName());
            
            return roleRepository.save(existingRole);
        }
        return null;
	}
	
	public boolean deleteRole(Long id) {
		Role existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole != null) {
            roleRepository.delete(existingRole);
            return true;
        }
        return false;
	}
}
