package com.coska.lab.restaurantpos.api.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "category")
public class Category {
	
	@Id
	@Column(name = "categoryId", unique = true)
	private Long categoryId;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	@NotBlank
	private String name;	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean needToCook;
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getNeedToCook() {
		return needToCook;
	}

	public void setNeedToCook(Boolean needToCook) {
		this.needToCook = needToCook;
	}

	
}
