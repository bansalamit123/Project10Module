package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_Position")
public class PositionDTO extends BaseDTO {

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "REQUIRED_EXPERIENCE")
	private Double requiredExperience;

	@Column(name = "OPENING_DATE")
	private Date openingDate;

	@Column(name = "CONDITION_NAME", length = 20)
	private String conditionName = null;

	@Column(name = "CONDITION_ID")
	private Long conditionId;

	@Column(name = "ORG_NAME", length = 50)
	private String orgName;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getRequiredExperience() {
		return requiredExperience;
	}

	public void setRequiredExperience(Double requiredExperience) {
		this.requiredExperience = requiredExperience;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public Long getConditionId() {
		return conditionId;
	}

	public void setConditionId(Long conditionId) {
		this.conditionId = conditionId;
	}

	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("designation", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}

}
