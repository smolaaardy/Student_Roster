package com.smolaardy.studentroster.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="contact_infos")
public class ContactInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String address;	
	private String city;	
	private String state;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime createdAt;
    
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDateTime updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
    
	public ContactInfo() {
		
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
		
	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
	    	
}