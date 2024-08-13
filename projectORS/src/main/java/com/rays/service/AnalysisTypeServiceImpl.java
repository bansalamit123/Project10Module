package com.rays.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.AnalysisTypeDAOInt;
import com.rays.dto.AnalysisTypeDTO;

@Service
@Transactional
public class AnalysisTypeServiceImpl extends BaseServiceImpl<AnalysisTypeDTO, AnalysisTypeDAOInt> implements AnalysisTypeServiceInt {

	private static Logger log = LoggerFactory.getLogger(AnalysisTypeServiceImpl.class);

	@Transactional(readOnly = true)
	public AnalysisTypeDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("name", name, userContext);
	}
}
