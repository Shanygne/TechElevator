package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class JDBCProjectDAOTest {
	
	private static final String TEST_PROJECT_NAME = "Fake Project Name";

	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO dao; 
	private JDBCEmployeeDAO empDao;
	
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
		String sqlInsertProject = "INSERT INTO project (name, from_date, to_date) VALUES (?, '2014-10-01', '2020-12-31')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertProject, TEST_PROJECT_NAME);
		dao = new JDBCProjectDAO(dataSource);
		empDao = new JDBCEmployeeDAO(dataSource);
	}
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_return_all_active_projects() {
		List<Project> results = dao.getAllActiveProjects();
		
		assertNotNull(results);
		assertEquals(4, results.size());
			}
	
	@Test
	public void test_remove_employee_from_project() {
		int originalSize = empDao.getEmployeesByProjectId(3L).size();  // get active number
		dao.addEmployeeToProject(3L, 9L); // arrange for a known state   added one
		int newSize = empDao.getEmployeesByProjectId(3L).size();
		assertEquals(originalSize + 1, newSize);
		dao.removeEmployeeFromProject(3L, 9L);
		newSize = empDao.getEmployeesByProjectId(3L).size();
		assertEquals(originalSize, newSize);
	}
	
	@Test
	public void test_add_employee_to_project() {
		int originalSize = empDao.getEmployeesByProjectId(3L).size();  // get active number
		dao.addEmployeeToProject(3L, 9L); // arrange for a known state   added one
		int newSize = empDao.getEmployeesByProjectId(3L).size();
		assertEquals(originalSize + 1, newSize);
	}
	
//	private Project getProject(String name, LocalDate startDate, LocalDate endDate) {
//		Project theProject = new Project();
//		theProject.setName(name);
//		theProject.setStartDate(startDate);
//		theProject.setEndDate(endDate);
//		return theProject;
//	}
	
	private void assertProjectsAreEqual(Project expected, Project actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getStartDate(), actual.getStartDate());
		assertEquals(expected.getEndDate(), actual.getEndDate());
	}
	}
