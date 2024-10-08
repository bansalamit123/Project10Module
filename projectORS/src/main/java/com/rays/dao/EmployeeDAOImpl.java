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
import com.rays.dto.DepartmentDTO;
import com.rays.dto.EmployeeDTO;

@Repository
public class EmployeeDAOImpl extends BaseDAOImpl<EmployeeDTO> implements EmployeeDAOInt {

	@Override
	public Class<EmployeeDTO> getDTOClass() {
		return EmployeeDTO.class;
	}

	@Autowired
	DepartmentDAOInt departmentDao;

	@Override
	protected void populate(EmployeeDTO dto, UserContext userContext) {
		if (dto.getDepartmentId() != null && dto.getDepartmentId() > 0) {
			DepartmentDTO departmentDto = departmentDao.findByPK(dto.getDepartmentId(), userContext);
			dto.setDepartmentName(departmentDto.getName());
			System.out.println(dto.getDepartmentName() + "PriorityName-------");
		}

	}

	@Override
	protected List<Predicate> getWhereClause(EmployeeDTO dto, CriteriaBuilder builder, Root<EmployeeDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getName())) {
			// Use 'like' operator for partial matching
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getLastEmployerName())) {
			// Use 'like' operator for partial matching
			whereCondition.add(builder.like(qRoot.get("lastEmployerName"), dto.getLastEmployerName() + "%"));
		}

		if (isNotNull(dto.getDateOfJoining())) {
			// Assuming "dateOfPurchase" field is of type java.util.Date or java.sql.Date
			Date searchDate = dto.getDateOfJoining();

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
			Predicate datePredicate = builder.between(qRoot.get("dateOfJoining"), startDate, endDate);
			whereCondition.add(datePredicate);
		}

		if (!isZeroNumber(dto.getDepartmentId())) {
			whereCondition.add(builder.equal(qRoot.get("departmentId"), dto.getDepartmentId()));
		}

		if (!isEmptyString(dto.getDepartmentName())) {
			whereCondition.add(builder.like(qRoot.get("departmentName"), dto.getDepartmentName() + "%"));
		}

		return whereCondition;
	}
}