package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.AnalysisTypeDTO;

public interface AnalysisTypeServiceInt extends BaseServiceInt<AnalysisTypeDTO> {

	/**
	 * Finds Role by name.
	 * 
	 * @param name
	 * @return
	 */
	public AnalysisTypeDTO findByName(String name, UserContext userContext);

}
