package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AssetDAOInt;
import com.rays.dto.AssetDTO;

@Service
@Transactional
public class AssetServiceImpl extends BaseServiceImpl<AssetDTO, AssetDAOInt>
		implements AssetServiceInt {

	@Autowired
	AssetDAOInt AssetDAO;

}
