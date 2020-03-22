package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.city.City;
import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class JDBCDepartmentDAOTest {

	private static final String TEST_DEPARTMENT_NAME = "Fake Department Name";

	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	@Before
	public void setup() {
		String sqlInsertDepartment = "INSERT INTO department (name) VALUES(?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertDepartment, TEST_DEPARTMENT_NAME);
		dao = new JDBCDepartmentDAO(dataSource);
	}
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_return_all_departments() {
		List<Department> results = dao.getAllDepartments();
		
		assertNotNull(results);
		assertEquals(5, results.size());
			}
	
	@Test
	public void test_search_department_by_name() {
		List<Department> results = dao.searchDepartmentsByName(TEST_DEPARTMENT_NAME);
		
		assertNotNull(results);
		assertEquals(1, results.size());	
	}
	
	@Test
	public void test_save_department() {
		Department theDepartment = new Department();     						  // making new department object
		theDepartment.setName("New Name");										  // change it to new name
		Department testDepartment = dao.createDepartment(theDepartment);		  // the object dao
		testDepartment.setName("Other New Name");								  // 
		dao.saveDepartment(testDepartment);
		Department saveDepartment = dao.getDepartmentById(testDepartment.getId());
		
		assertEquals(testDepartment.getName(), saveDepartment.getName());
	}
	
	@Test
	public void test_create_department() {
		Department theDepartment = new Department();
		Department result = dao.createDepartment(theDepartment);
		result.setName("Kyle");
		assertEquals("Kyle", result.getId()); // YES, WE KNOW THIS IS WRONG
	}
	
	@Test
	public void test_get_department_by_ID() {
	
		
		Department results = dao.getDepartmentById(1L);
		
		assertNotNull(results);
		assertEquals(TEST_DEPARTMENT_NAME, results.getId());
		
	}
	
	private Department getDepartment(String name) {
		Department theDepartment = new Department();
		theDepartment.setName(name);
		return theDepartment;
	}
	
	private void assertDepartmentsAreEqual(Department expected, Department actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
	}

}
