package com.worolo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worolo.api.model.Role;
import com.worolo.api.repository.RoleRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
    public Role save(Role role) {
        if(role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        return roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        if(role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        Role existingRole = findById(id);
        existingRole.setName(role.getName());
        return roleRepository.save(existingRole);
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isEmpty()) {
            throw new EntityNotFoundException("Role with id " + id + " not found");
        }
        return optionalRole.get();
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Role existingRole = findById(id);
        roleRepository.delete(existingRole);
    }
}
