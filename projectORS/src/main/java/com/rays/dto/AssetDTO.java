package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_Asset")
public class AssetDTO extends BaseDTO {

	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNumber;

	@Column(name = "COVERAGE_AMOUNT")
	private Long coverageAmount;

	@Column(name = "ACQUISITION_DATE")
	private Date acquisitionDate;

	@Column(name = "PAINTCOLOR_NAME", length = 20)
	private String paintColorName = null;

	@Column(name = "PAINTCOLOR_ID")
	private Long paintColorId;

	@Column(name = "ORG_NAME", length = 50)
	private String orgName;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Long getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Long coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public String getPaintColorName() {
		return paintColorName;
	}

	public void setPaintColorName(String paintColorName) {
		this.paintColorName = paintColorName;
	}

	public Long getPaintColorId() {
		return paintColorId;
	}

	public void setPaintColorId(Long paintColorId) {
		this.paintColorId = paintColorId;
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
		map.put("coverageAmount", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}

}
