package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.StockAnalysisDAOInt;
import com.rays.dto.StockAnalysisDTO;

@Service
@Transactional
public class StockAnalysisServiceImpl extends BaseServiceImpl<StockAnalysisDTO, StockAnalysisDAOInt> implements StockAnalysisServiceInt {

	@Autowired
	StockAnalysisDAOInt StockAnalysisDao;
}