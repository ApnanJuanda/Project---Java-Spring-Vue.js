package com.example.crudCustomer.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Document(collection = "customers")
public class Customer {
	
	@Id
	public ObjectId _id;
	
	@Size(max = 100)
	private String nama;
	
	@Size(max = 50)
	private String jabatan;
	
	@Size(max = 10)
	private String gender;
	
	public Customer() {
		
	}
	
	public Customer(ObjectId _id, String nama, String jabatan, String gender) {
		this._id = _id; 
		this.nama = nama;
		this.jabatan = jabatan;
		this.gender = gender;
	}

	//bjectId needs to be converted to string
	public String get_id() { 
		return _id.toHexString(); 
	}
	
	public void set_id(ObjectId _id) {
		this._id = _id; 
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [nama=" + nama + ", jabatan=" + jabatan + ", gender=" + gender + "]";
	}

}
