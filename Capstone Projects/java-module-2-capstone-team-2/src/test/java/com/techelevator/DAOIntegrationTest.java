package com.techelevator;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.campground.JdbcCampgroundDAO;
import com.techelevator.model.park.JdbcParkDAO;
import com.techelevator.model.park.Park;
import com.techelevator.model.reservation.JdbcReservationDAO;
import com.techelevator.model.reservation.Reservation;

public class DAOIntegrationTest {
	
	private JdbcParkDAO parkDao;
	private JdbcCampgroundDAO campgroundDao;
	private JdbcReservationDAO reservationDao;
	
	private static final String TEST_PARK_NAME = "Test Park Name";
	private static final String TEST_CAMPGROUND_NAME = "Test Campground Name";
	private static final String TEST_RESERVATION_NAME = "Test Reservation Name";

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* Before for Park, Campground, Site, Reservation */
	@Before
	public void setup() {
		String sqlInsertPark = "INSERT INTO park (name, location, establish_date, area, visitors, description) VALUES (?, 'Maine', '1919-02-26', 47389, 2563129, 'Here is a description of the park.')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertPark, TEST_PARK_NAME);
		
		String sqlInsertCampground = "INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (1, ?, 01, 12, 35.00)";
		jdbcTemplate.update(sqlInsertCampground, TEST_CAMPGROUND_NAME);
		
		String sqlInsertReservation = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) VALUES (1, ?, '2020-02-18', '2020-02-22', '2020-02-20')";
		jdbcTemplate.update(sqlInsertReservation, TEST_RESERVATION_NAME);
		
		campgroundDao = new JdbcCampgroundDAO(dataSource);
		parkDao = new JdbcParkDAO(dataSource);
		reservationDao = new JdbcReservationDAO(dataSource);
	}


	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/* This method provides access to the DataSource for subclasses so that
	 * they can instantiate a DAO for testing */
	protected DataSource getDataSource() {
		return dataSource;
	}
	
	/************************TESTING FOR JDBCPARKDAO METHODS************************/
	@Test
	public void test_return_all_available_parks() {
		List<Park> results = parkDao.getAllAvailableParks();  // Arrange/Act
																
		assertNotNull(results);                        
		assertTrue(results.size()>0);					// Assert
	}
	
	// ask for all available parks, assert there is more than one, grab that id, get a campground for that park id. doesnt matter which one

	@Test
	public void test_get_park_by_id() {
		Park results = parkDao.getParkById(1L);
		
		assertNotNull(results);
	}
	
	/************************TESTING FOR JDBCCAMPGROUNDDAO METHOD************************/
//	@Test
//	public void test_campgrounds_returned_by_id() {
//		List<Campground> campgrounds = campgroundDao.getCampgroundsByParkId(1L);
//		
//		assertNotNull(campgrounds);
//		assertEquals(1, campgrounds.size());
//
//	}
	
	/************************TESTING FOR JDBCRESERVATIONDAO METHOD************************/
//	@Test
//	public void test_create_reservation() {
//		Reservation theReservation = new Reservation();
//		Reservation results = reservationDao.createReservation(theReservation);
//		results.setName("Kyle");
//		
//		assertNotNull(results);
//	}
}
