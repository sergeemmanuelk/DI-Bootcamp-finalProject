package com.worolo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worolo.api.model.Municipality;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {

}
