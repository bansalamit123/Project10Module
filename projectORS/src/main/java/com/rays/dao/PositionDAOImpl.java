package com.rays.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;


import com.rays.dto.PositionDTO;

@Repository
public class PositionDAOImpl extends BaseDAOImpl<PositionDTO> implements PositionDAOInt {

	@Override
	public Class<PositionDTO> getDTOClass() {
		return PositionDTO.class;
	}

	

	@Override
	protected List<Predicate> getWhereClause(PositionDTO dto, CriteriaBuilder builder,
			Root<PositionDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		

		if (!isEmptyString(dto.getDesignation())) {
			whereCondition.add(builder.equal(qRoot.get("designation"), dto.getDesignation()));
		}

		if (!isZeroNumber(dto.getRequiredExperience())) {
			whereCondition.add(builder.equal(qRoot.get("requiredExperience"), dto.getRequiredExperience()));
		}

		if (isNotNull(dto.getOpeningDate())) {
			// Assuming "dateOfPurchase" field is of type java.util.Date or java.sql.Date
			Date searchDate = dto.getOpeningDate();

			// Define start and end dates for the search day
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(searchDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0); // Start of the day
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date startDate = calendar.getTime();

			calendar.set(Calendar.HOUR_OF_DAY, 23); // End of the day
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			Date endDate = calendar.getTime();

			// Create predicate for date range
			Predicate datePredicate = builder.between(qRoot.get("openingDate"), startDate, endDate);
			whereCondition.add(datePredicate);
		}

		if (!isZeroNumber(dto.getConditionId())) {
			whereCondition.add(builder.equal(qRoot.get("conditionId"), dto.getConditionId()));
		}

		if (!isEmptyString(dto.getConditionName())) {
			whereCondition.add(builder.like(qRoot.get("conditionName"), dto.getConditionName() + "%"));
		}

		return whereCondition;
	}

}