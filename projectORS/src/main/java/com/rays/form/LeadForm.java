package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.LeadDTO;
import com.rays.validation.ValidAlphabetic;
import com.rays.validation.ValidAlphabetic1;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidDouble;
import com.rays.validation.ValidLong;

public class LeadForm extends BaseForm {

	// @Pattern(regexp = "^[A-Za-z]+([ '-][A-Za-z]+)*$", message = "Name contains
	// alphabets only")
//	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
//	@Size(max = 20, message = "this field is 20 characters only")
//	@NotEmpty(message = "Please enter name")
	// @ValidAlphabetic
	// private Long LeadId;
@Size(max=20, message="enter 20 charactor only")
@ValidAlphabetic1
	@NotEmpty(message = "Please enter contactName")
	// @Pattern(regexp = "^[A-Z0-9]{1,10}$", message = "Registration number must be
	// alphanumeric and up to 10 characters.")
	// @Pattern(regexp = "^[A-Za-z ]+$", message = "Designation must contain only
	// letters and spaces.")
	// @Pattern( regexp = "^-?([1-8]?\\d(\\.\\d{1,6})?|90(\\.0{1,6})?)$", message =
	// "Invalid latitude. Must be between -90 and 90")
	private String contactName;

	@NotEmpty(message = "Please enter mobile")
	// @Pattern( regexp =
	// "^-?(1[0-7]\\d|[1-9]\\d|0)(\\.\\d{1,6})?$|^180(\\.0{1,6})?$",message =
	// "Invalid longitude. Must be between -180 and 180")
	// @Pattern(regexp = "^[0-9]{1,15}$", message = "Coverage amount must be a
	// numeric value and up to 15 digits long.")
	// @Pattern(regexp = "^\\d{1,2}(\\.\\d{1,2})?$", message = "Required experience
	// must be a numeric value with up to 2 integer and 2 decimal places.")
	// @Pattern(regexp = "^[A-Z0-9]{1,10}$", message = "Registration number must be
	// alphanumeric and up to 10 characters.")
	@Pattern(regexp = "(^$|^[6-9]\\d{9}$)", message = "Invalid input for mobileNo")
	private String mobile;

	@NotNull(message = "Please enter date")
	@ValidDate(message = "Invalid date format or value")
	private String date;

	private String statusName;

	@NotEmpty(message = "Please enter statusId")
	@ValidLong(message = "Invalid input for status id", allowEmpty = true)
	@Min(value = 1, message = "statusId should be greater than 0")
	private String statusId;

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	@Override
	public BaseDTO getDto() {
		LeadDTO dto = initDTO(new LeadDTO());

		dto.setContactName(contactName);;
		if (date != null && !date.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(date);
				dto.setDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}

		

		if (mobile != null && !mobile.isEmpty()) {
			dto.setMobile(Long.parseLong(mobile));
		}

		if (statusId != null && !statusId.isEmpty()) {
			dto.setStatusId(Long.valueOf(statusId));
		}

		dto.setStatusName(statusName);

		return dto;
	}
}