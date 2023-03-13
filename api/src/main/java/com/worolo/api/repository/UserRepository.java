package com.worolo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worolo.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
