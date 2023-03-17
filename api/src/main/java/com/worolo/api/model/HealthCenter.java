package com.worolo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "health_centers")
public class HealthCenter extends Person {
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	private Municipality municipality;

	public HealthCenter() {
		super();
	}

	public HealthCenter(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
