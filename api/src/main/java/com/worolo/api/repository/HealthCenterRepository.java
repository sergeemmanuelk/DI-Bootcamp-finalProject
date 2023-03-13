package com.worolo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worolo.api.model.HealthCenter;

@Repository
public interface HealthCenterRepository extends JpaRepository<HealthCenter, Long> {

}
