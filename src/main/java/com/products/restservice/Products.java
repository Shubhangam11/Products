package com.products.restservice;

import java.sql.Timestamp;
import java.text.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.minidev.json.JSONArray;


@Entity
public class Products {



	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "tags")
	private JSONArray tags;
	
	@Column(name = "category")
	private String category;
	

	@CreatedDate
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm'Z'")
	 private Date created_at;

	@PrePersist
	
	private void PrePersist() {
		
		if (this.created_at ==null) this.created_at = new Date();
	}
	
	
	
	public Products() {
	}
	
	public Products(String name, String description, String brand, String category,JSONArray tags) {//, JSONArray tags
		super();
		this.name = name;
		this.description = description;
		this.brand = brand;
		//this.tags = tags;
		this.category = category;
		this.tags = tags;

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return this.id;
	}


	/*
	public void setTime() {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); 
		df.setTimeZone(tz);
		this.created_at = df.format(new Date());
		
	}*/

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public JSONArray getTags() {
		return tags;
	}

	public void setTags(JSONArray tags) {
		this.tags = tags;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
}
