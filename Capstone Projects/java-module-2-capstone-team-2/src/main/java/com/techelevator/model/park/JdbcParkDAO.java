package com.techelevator.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllAvailableParks() {
		List<Park> park = new ArrayList<Park>();
		String sqlGetAllAvailableParks = "SELECT * from park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllAvailableParks);
		
		while(results.next()) {
			Park thePark = mapRowToPark(results);
			park.add(thePark);
		}
		return park;
	}
	
	@Override
	public Park getParkById(Long parkId) {
		String sqlShowParkInformationById = "SELECT * from park WHERE park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlShowParkInformationById, parkId);
		Park thePark = mapRowToPark(results);
		return thePark;
	}
	
	private Park mapRowToPark(SqlRowSet results) {
		Park thePark;
		thePark = new Park();
		
			thePark.setParkId(results.getLong("park_id"));
			thePark.setName(results.getString("name"));
			thePark.setLocation(results.getString("location"));
			thePark.setEstablishDate(results.getDate("establish_date").toLocalDate());
			thePark.setArea(results.getInt("area"));
			thePark.setVisitors(results.getInt("visitors"));
			thePark.setDescription(results.getString("description"));
		
		return thePark;
	}
}
