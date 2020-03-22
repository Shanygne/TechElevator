package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import com.techelevator.projects.model.Project;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {   /////////////////////////////
		ArrayList<Employee> employees = new ArrayList<>(); 
		String sqlGetAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
										  "FROM Employee ";							
	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
	while(results.next()) {
		Employee theEmployee = mapRowToEmployee(results);
		employees.add(theEmployee);
	}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlSearchEmployeesByName = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date from Employee WHERE first_name like '%" + firstNameSearch + "%' and last_name like '%" + lastNameSearch + "%'"; // GET BACK TO THIS
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByName);
		while(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {  ///////////////////
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlGetEmployeesByDepartmentId = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM employee where department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByDepartmentId, id);
		
		while(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}

	@Override												/////// correct the sql and i think were good
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> employees = new ArrayList<>();
		Date date = new Date();
		String sqlGetEmployeesWithoutProjects = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM Employee left join project_employee on project_employee.employee_id = employee.employee_id where employee.employee_id is ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesWithoutProjects);
		
		while(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {  //////////////////////////
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlSearchEmployeesByName = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM Employee where employee_id in (select employee_id from project_employee where project_id = ?)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByName, projectId);
		
		while(results.next()) {
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {      ////// 
		String sqlChangeEmployeeDepartment = "UPDATE Employee set department_id = ? where employee_id = ?";
		jdbcTemplate.update(sqlChangeEmployeeDepartment, departmentId, employeeId);
	}
	
	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee theEmployee;
		theEmployee = new Employee();
		
		theEmployee.setId(results.getLong("employee_id"));
		theEmployee.setDepartmentId(results.getLong("department_id"));
		theEmployee.setFirstName(results.getString("first_name"));
		theEmployee.setLastName(results.getString("last_name"));
		theEmployee.setBirthDay(results.getDate("birth_date").toLocalDate());
		theEmployee.setGender(results.getString ("gender").charAt(0));
		theEmployee.setHireDate(results.getDate("hire_date").toLocalDate());
		return theEmployee;
	}

}
