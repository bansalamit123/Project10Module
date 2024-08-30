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
import com.rays.dto.AssetDTO;
import com.rays.validation.ValidAlphabetic;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidDouble;
import com.rays.validation.ValidLong;

public class AssetForm extends BaseForm {

	//@Pattern(regexp = "^[A-Za-z]+([ '-][A-Za-z]+)*$", message = "Name contains alphabets only")
//	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
//	@Size(max = 20, message = "this field is 20 characters only")
//	@NotEmpty(message = "Please enter name")
	//@ValidAlphabetic
	//private Long assetId;

	@NotEmpty(message = "Please enter registrationNumber")
	@Pattern(regexp = "^[A-Z0-9]{1,10}$", message = "Registration number must be alphanumeric and up to 10 characters.")
	// @Pattern( regexp = "^-?([1-8]?\\d(\\.\\d{1,6})?|90(\\.0{1,6})?)$", message = "Invalid latitude. Must be between -90 and 90")
	private String registrationNumber;

	@NotEmpty(message = "Please enter coverageAmount")
	//@Pattern( regexp = "^-?(1[0-7]\\d|[1-9]\\d|0)(\\.\\d{1,6})?$|^180(\\.0{1,6})?$",message = "Invalid longitude. Must be between -180 and 180")
	@Pattern(regexp = "^[0-9]{1,15}$", message = "Coverage amount must be a numeric value and up to 15 digits long.")
	//@Pattern(regexp = "^[A-Z0-9]{1,10}$", message = "Registration number must be alphanumeric and up to 10 characters.")
	private String coverageAmount;

	@NotNull(message = "Please enter AcquisitionDate")
	@ValidDate(message = "Invalid date format or value")
	private String acquisitionDate;

	private String paintColorName;

	 @NotEmpty(message = "Please enter paintColor")
	@ValidLong(message = "Invalid input for paintColor id", allowEmpty = true)
	@Min(value = 1, message = "paintColorId should be greater than 0")
	private String paintColorId;


		public String getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	public String getCoverageAmount() {
		return coverageAmount;
	}


	public void setCoverageAmount(String coverageAmount) {
		this.coverageAmount = coverageAmount;
	}


	public String getAcquisitionDate() {
		return acquisitionDate;
	}


	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}


	public String getPaintColorName() {
		return paintColorName;
	}


	public void setPaintColorName(String paintColorName) {
		this.paintColorName = paintColorName;
	}


	public String getPaintColorId() {
		return paintColorId;
	}


	public void setPaintColorId(String paintColorId) {
		this.paintColorId = paintColorId;
	}


		@Override
	public BaseDTO getDto() {
		AssetDTO dto = initDTO(new AssetDTO());

		dto.setRegistrationNumber(registrationNumber);
		if (acquisitionDate != null && !acquisitionDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(acquisitionDate);
				dto.setAcquisitionDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}

		/*
		 * if (latitude != null && !latitude.isEmpty()) {
		 * dto.setLatitude(Double.parseDouble(latitude)); }
		 */

		if (coverageAmount != null && !coverageAmount.isEmpty()) {
			dto.setCoverageAmount(Long.parseLong(coverageAmount));
		}

		if (paintColorId!= null && !paintColorId.isEmpty()) {
			dto.setPaintColorId(Long.valueOf(paintColorId));
		}	

		dto.setPaintColorName(paintColorName);

		return dto;
	}
}