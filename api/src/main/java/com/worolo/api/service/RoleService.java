package com.worolo.api.service;


import java.util.List;

import com.worolo.api.model.Role;

public interface RoleService {
	
	Role save(Role role);
    Role update(Long id, Role role);
    Role findById(Long id);
    List<Role> findAll();
    void delete(Long id);

}
