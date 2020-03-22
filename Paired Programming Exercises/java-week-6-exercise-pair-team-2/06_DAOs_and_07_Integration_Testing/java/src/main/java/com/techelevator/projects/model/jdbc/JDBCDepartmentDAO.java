package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import com.techelevator.projects.model.Project;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	
	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		ArrayList<Department> departments = new ArrayList<>();
		String sqlGetAllDepartments = "SELECT * FROM Department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);
		
		while(results.next()) {
			Department theDepartment = mapRowToDepartment(results);
			departments.add(theDepartment);
		}
		return departments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> departments = new ArrayList<>();
		String sqlSearchDepartmentsByName = "SELECT department_id, name FROM Department where name like  '%" + nameSearch + "%'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchDepartmentsByName);
		
		while(results.next()) {
			Department theDepartment = mapRowToDepartment(results);
			departments.add(theDepartment);
		}
		return departments;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlInsertDepartment = "Update Department set name = ? where department_id = ?";
	
		jdbcTemplate.update(sqlInsertDepartment, updatedDepartment.getName(), updatedDepartment.getId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlCreateDepartment = "INSERT INTO Department(department_id, name)" + "VALUES(?, ?)";
		
		newDepartment.setId(getUpdatedDepartmentId());
		jdbcTemplate.update(sqlCreateDepartment, newDepartment.getId(), newDepartment.getName());
		
		//jdbcTemplate.update(sqlCreateDepartment, newDepartment.getName());
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		//Department theDepartment = null;
		String sqlGetDepartmentById = "SELECT department_id, name from Department WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDepartmentById, id);
		Department theDepartment = mapRowToDepartment(results);
		
//		if(results.next()) {
//			theDepartment = mapRowToDepartment(results);
//		}
		return theDepartment;
	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department theDepartment;
		theDepartment = new Department();
		
		theDepartment.setId(results.getLong("department_id"));
		theDepartment.setName(results.getString("name"));
		return theDepartment;
	}
	
	private Long getUpdatedDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for new department");
		}
	}

}
