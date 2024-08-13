package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AnalysisTypeDTO;

@Repository
public class AnalysisTypeDAOImpl extends BaseDAOImpl<AnalysisTypeDTO> implements AnalysisTypeDAOInt {

	@Override
	public Class<AnalysisTypeDTO> getDTOClass() {
		return AnalysisTypeDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(AnalysisTypeDTO dto, CriteriaBuilder builder, Root<AnalysisTypeDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		if (!isEmptyString(dto.getAnalysisTypeName())) {

			whereCondition.add(builder.like(qRoot.get("AnalysisTypeName"), dto.getAnalysisTypeName() + "%"));
		}

		if (!isEmptyString(dto.getDescription())) {

			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		return whereCondition;
	}

}