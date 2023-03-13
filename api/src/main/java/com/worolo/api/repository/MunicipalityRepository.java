package com.worolo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worolo.api.model.Municipality;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {

}
