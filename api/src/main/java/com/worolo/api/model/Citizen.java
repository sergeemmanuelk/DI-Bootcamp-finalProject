package com.worolo.api.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "citizens")
public class Citizen extends Person{
	
	@Column(nullable = false)
	private char gender;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false) 
	private String lastName;
	
	@Column(nullable = false)
	private Date birthdate;
	
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;
	
	@OneToMany(mappedBy = "citizen")
	private List<Document> document;
	

	public Citizen() {
		super();
	}

	public Citizen(char gender, String firstName, String lastName, Date birthdate, Date createdAt, Date updatedAt,
			List<Document> document) {
		super();
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.document = document;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}
	
	@Override
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
