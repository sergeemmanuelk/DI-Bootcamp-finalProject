package com.worolo.api.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long uniqueCode;
	
	@Column(name = "child_first_name")
	private String childFirstName;
	
	@Column(name = "child_last_name")
	private String childLastName;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mother_name")
	private String motherName;
	
	private Date birthDate;
	
	private Date time;
	
	private String attachment;
	
	private Date requestDate;
	
	@ManyToOne
	private Citizen user;
	
	@ManyToOne
	private CertificateType certificateType;
	
	@OneToOne(mappedBy = "document")
	private Payment payment;
	
	@ManyToOne
	private Municipality municipality;
}
