package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {       ////////////////////
		ArrayList<Project> projects = new ArrayList<>();
		
		String sqlGetAllActiveProjects = "SELECT project_id, name, from_date, to_date " +
										  "FROM Project " +
										  "WHERE from_date is not null AND(to_date is null or to_date > ?)";
		
	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllActiveProjects, LocalDate.now());
	while(results.next()) {
		Project theProject = mapRowToProject(results);
		projects.add(theProject);
	}
		return projects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {   //////////////add project_employee
		String sqlRemoveEmployeeFromProject = "DELETE FROM project_employee " + 
											  "where project_id = ? AND employee_id = ?";
		
		jdbcTemplate.update(sqlRemoveEmployeeFromProject, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {     ////////////////////////////
		String sqlAddEmployeeToProject = "INSERT INTO project_employee (project_id, employee_id) "
										+ "VALUES (?, ?)";
		this.jdbcTemplate.update(sqlAddEmployeeToProject, projectId, employeeId);
	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project theProject;
		theProject = new Project();
		
		theProject.setId(results.getLong("project_id"));
		theProject.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			theProject.setStartDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null)
		theProject.setEndDate(results.getDate("to_date").toLocalDate());

		return theProject;
	}


}
