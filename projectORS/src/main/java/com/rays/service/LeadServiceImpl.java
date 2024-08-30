package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.LeadDAOInt;
import com.rays.dto.LeadDTO;

@Service
@Transactional
public class LeadServiceImpl extends BaseServiceImpl<LeadDTO, LeadDAOInt>
		implements LeadServiceInt {

	@Autowired
	LeadDAOInt LeadDAO;

}
