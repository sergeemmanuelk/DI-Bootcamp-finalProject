package com.worolo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worolo.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
