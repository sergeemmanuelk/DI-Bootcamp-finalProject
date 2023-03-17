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

import com.worolo.api.model.Role;
import com.worolo.api.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public List<Role> getAllRole() {
		return roleService.getAllRole();
	}
	
	@GetMapping("/{id}")
	public Role getRoleById(@PathVariable Long id) {
		return roleService.getRoleById(id);
	}
	
	@PostMapping
	public Role createRole(@RequestBody Role role) {
		return roleService.createRole(role);
	}
	
	@PutMapping("/{id}")
	public Role updateRole(@PathVariable Long id, @RequestBody Role updatedRole) {
		return roleService.updateRole(id, updatedRole);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteRole(@PathVariable Long id) {
		return roleService.deleteRole(id);
	}
}
