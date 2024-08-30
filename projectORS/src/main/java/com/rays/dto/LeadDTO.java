package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_Lead")
public class LeadDTO extends BaseDTO {

	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "MOBILE")
	private Long mobile;

	@Column(name = "DATE")
	private Date date;

	@Column(name = "STATUS_NAME", length = 20)
	private String statusName = null;

	@Column(name = "STATUS_ID")
	private Long statusId;

	@Column(name = "ORG_NAME", length = 50)
	private String orgName;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
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
		map.put("contactName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}

}
