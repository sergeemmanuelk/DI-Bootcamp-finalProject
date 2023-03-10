package com.worolo.api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "municipalities")
public class Municipality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private int phoneNumber;
	
	private String address;
	
	@OneToMany(mappedBy = "municipality")
	private List<HealthCenter> healthCenter;
	
	@OneToMany(mappedBy = "municipality")
	private List<Certificate> certificate;
}
