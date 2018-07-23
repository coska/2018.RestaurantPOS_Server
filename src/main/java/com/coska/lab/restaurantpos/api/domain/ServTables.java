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
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "serv_table")
public class ServTables {
	@Id
	private Long  tableId;

	@NotBlank
	private String name;
	
	@NotNull
	private Boolean isTakeOut;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer seats;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean occupied;
	
	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public String getName() {
		return name;
	}

	public void setName(String tableName) {
		this.name = tableName;
	}

	public Boolean getIsTakeOut() {
		return isTakeOut;
	}

	public void setIsTakeOut(Boolean isTakeOut) {
		this.isTakeOut = isTakeOut;
	}
	

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Boolean getOccupied() {
		return occupied;
	}

	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

}
