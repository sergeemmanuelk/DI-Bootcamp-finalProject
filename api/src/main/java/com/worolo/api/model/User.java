package com.worolo.api.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private char gender;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name") 
	private String lastName;
	   
	private String email;
	   
	private String password;
	   
	private int phoneNumber;
	   
	private String address;
	
	@OneToMany(mappedBy = "user")
	private List<Certificate> certificate;
}
