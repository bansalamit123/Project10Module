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
import com.rays.dto.PositionDTO;
import com.rays.validation.ValidAlphabetic;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidDouble;
import com.rays.validation.ValidLong;

public class PositionForm extends BaseForm {

	//@Pattern(regexp = "^[A-Za-z]+([ '-][A-Za-z]+)*$", message = "Name contains alphabets only")
//	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
//	@Size(max = 20, message = "this field is 20 characters only")
//	@NotEmpty(message = "Please enter name")
	//@ValidAlphabetic
	//private Long PositionId;

	@NotEmpty(message = "Please enter designation")
	//@Pattern(regexp = "^[A-Z0-9]{1,10}$", message = "Registration number must be alphanumeric and up to 10 characters.")
	 @Pattern(regexp = "^[A-Za-z ]+$", message = "Designation must contain only letters and spaces.")
	// @Pattern( regexp = "^-?([1-8]?\\d(\\.\\d{1,6})?|90(\\.0{1,6})?)$", message = "Invalid latitude. Must be between -90 and 90")
	private String designation;

	@NotEmpty(message = "Please enter requiredExperience")
	//@Pattern( regexp = "^-?(1[0-7]\\d|[1-9]\\d|0)(\\.\\d{1,6})?$|^180(\\.0{1,6})?$",message = "Invalid longitude. Must be between -180 and 180")
	//@Pattern(regexp = "^[0-9]{1,15}$", message = "Coverage amount must be a numeric value and up to 15 digits long.")
	 @Pattern(regexp = "^\\d{1,2}(\\.\\d{1,2})?$", message = "Required experience must be a numeric value with up to 2 integer and 2 decimal places.")
	//@Pattern(regexp = "^[A-Z0-9]{1,10}$", message = "Registration number must be alphanumeric and up to 10 characters.")
	private String requiredExperience;

	@NotNull(message = "Please enter openingDate")
	@ValidDate(message = "Invalid date format or value")
	private String openingDate;

	private String conditionName;

	 @NotEmpty(message = "Please enter conditionId")
	@ValidLong(message = "Invalid input for condition id", allowEmpty = true)
	@Min(value = 1, message = "conditionId should be greater than 0")
	private String conditionId;


		public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getRequiredExperience() {
		return requiredExperience;
	}


	public void setRequiredExperience(String requiredExperience) {
		this.requiredExperience = requiredExperience;
	}


	public String getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}


	public String getConditionName() {
		return conditionName;
	}


	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}


	public String getConditionId() {
		return conditionId;
	}


	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}


		@Override
	public BaseDTO getDto() {
		PositionDTO dto = initDTO(new PositionDTO());

		dto.setDesignation(designation);
		if (openingDate != null && !openingDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(openingDate);
				dto.setOpeningDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}

		/*
		 * if (latitude != null && !latitude.isEmpty()) {
		 * dto.setLatitude(Double.parseDouble(latitude)); }
		 */

		if (requiredExperience != null && !requiredExperience.isEmpty()) {
			dto.setRequiredExperience(Double.parseDouble(requiredExperience));
		}

		if (conditionId!= null && !conditionId.isEmpty()) {
			dto.setConditionId(Long.valueOf(conditionId));
		}	

		dto.setConditionName(conditionName);

		return dto;
	}
}