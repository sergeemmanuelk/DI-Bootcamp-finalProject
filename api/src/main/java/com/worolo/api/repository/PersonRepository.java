package com.worolo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worolo.api.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
