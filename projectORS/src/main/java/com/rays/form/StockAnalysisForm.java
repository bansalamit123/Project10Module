
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
import com.rays.dto.StockAnalysisDTO;
import com.rays.validation.ValidAlphabetic;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidDouble;
import com.rays.validation.ValidLong;

public class StockAnalysisForm extends BaseForm {

	@NotNull(message = "Please enter stockSymbol")
	//@Pattern(regexp = "^(?:1000|[1-9]\\d{0,2})$", message = "Quantity must be a number between 1 and 1000")
	private String stockSymbol;

	/*
	 * @NotNull(message = "Please enter Analysis Price") // @Pattern(regexp =
	 * "^(?:[1-9]|[1-9][0-9]|[1-4][0-9]{2}|1000000)$", message = //
	 * "currentValue must be a number between 1 and 1000000")
	 * // @ValidLong(message="Invalid currentValue value") // @Pattern(regexp =
	 * "^^\\d+(\\.\\d{1,2})?$", message = "Invalid price")
	 * 
	 * @ValidDouble private String AnalysisPrice;
	 */

	@NotNull(message = "Please enter Start Date")
	@ValidDate(message = "Invalid date format or value")
	private String startDate;
	
	@NotNull(message = "Please enter End Date")
	@ValidDate(message = "Invalid date format or value")
	private String endDate;

	// @NotEmpty(message = "Please enter StockAnalysis name")
	// @Size(max = 30, message = "StockAnalysis name must be up to 30 characters")
	// @Pattern(regexp = "^[A-Za-z0-9\\s\\-\\_]+$", message = "Invalid StockAnalysis
	// name")
	// private String StockAnalysisName;

	private String analysisType ;

	//@NotEmpty(message = "Please enter analysisTypeId")
	@ValidLong(message = "Invalid input for analysisType id", allowEmpty = true)
	@Min(value = 1, message = "analysisId should be greater than 0")
	private String analysisTypeId;

	
	public String getStockSymbol() {
		return stockSymbol;
	}


	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getAnalysisType() {
		return analysisType;
	}


	public void setAnalysisType(String analysisType) {
		this.analysisType = analysisType;
	}


	public String getAnalysisTypeId() {
		return analysisTypeId;
	}


	public void setAnalysisTypeId(String analysisTypeId) {
		this.analysisTypeId = analysisTypeId;
	}


	@Override
	public BaseDTO getDto() {
		StockAnalysisDTO dto = initDTO(new StockAnalysisDTO());

		/*
		 * if (AnalysisPrice != null && !AnalysisPrice.isEmpty()) {
		 * dto.setAnalysisPrice(Double.valueOf(AnalysisPrice)); // Convert String to
		 * Long }
		 * 
		 * if (quantity != null && !quantity.isEmpty()) {
		 * dto.setQuantity(Long.valueOf(quantity)); // Convert String to Long }
		 */
		if (startDate != null && !startDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(startDate);
				dto.setStartDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}
		if (endDate != null && !endDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(endDate);
				dto.setEndDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}

		if (analysisTypeId != null && !analysisTypeId.isEmpty()) {
			try {
				dto.setAnalysisTypeId(Long.valueOf(analysisTypeId)); // Convert String to Long
			} catch (NumberFormatException e) {
				// Handle conversion error if productId is not a valid Long
				e.printStackTrace();
			}
		}
		dto.setAnalysisType(analysisType);;
		dto.setStockSymbol(stockSymbol);

	

		return dto;
	}

}
