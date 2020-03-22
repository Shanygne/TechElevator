package com.techelevator.model.campground;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcCampgroundDAO implements CampgroundDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Campground> getCampgroundsByParkId(Long id) {
		List<Campground> campgrounds = new ArrayList<Campground>();
		String sqlGetCampgroundsByParkId = "SELECT * from campground where park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCampgroundsByParkId, id);
		while (results.next()) {
			Campground theCampground = mapRowToCampground(results);
			campgrounds.add(theCampground);
		}
		return campgrounds;
	}

	// INTEGRATION TESTING NOT ATTEMPTED
	@Override
	public List<Campground> getAllCampGroundByDateAvailabiliy(Long campgroundId, LocalDate openFromMm,
			LocalDate openToMm) {
		List<Campground> campGroundList = new ArrayList<Campground>();
		String sqlGetAllCampGroundByDateAvailabiliy = "Select * from campground where campground_id = ? and openFromMm = ? and openToMm = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCampGroundByDateAvailabiliy, campgroundId, openFromMm, openToMm);
		
		while(results.next()) {
			Campground theCampground = mapRowToCampground(results);
			campGroundList.add(theCampground);
		}
		return campGroundList;
	}
	
	public Campground getACampground (Campground newCampground) {
		newCampground.getCampgroundId();
		newCampground.getParkId();
		newCampground.getName();
		newCampground.getOpenFromMm();
		newCampground.getOpenToMm();
		newCampground.getDailyFee();
		return newCampground;
	}
	
	public Campground getCampgroundByCampgroundId (Long id) {
		Campground aCampground = new Campground();
		String sqlGetCampgroundByCampgroundId = "Select * from campground where campground_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCampgroundByCampgroundId, id);
		while(results.next()) {
			aCampground = mapRowToCampground(results);
		}
		return aCampground;
	}

	private Campground mapRowToCampground(SqlRowSet results) {
		Campground theCampground;
		theCampground = new Campground();
		
		theCampground.setCampgroundId(results.getLong("campground_id"));
		theCampground.setParkId(results.getLong("park_id"));
		theCampground.setName(results.getString("name"));
		theCampground.setOpenFromMm(results.getString("open_from_mm"));
		theCampground.setOpenToMm(results.getString("open_to_mm"));
		theCampground.setDailyFee(results.getDouble("daily_fee"));

		return theCampground;
	}	
	
}
