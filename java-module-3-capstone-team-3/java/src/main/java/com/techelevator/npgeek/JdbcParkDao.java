package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao {

	private JdbcTemplate jdbcTemplate;						//define a jdbc object

	public JdbcParkDao(DataSource dataSource) {				//instantiate a datasource through JdbcParkDao using jdbcTemplate
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> listAllParks() {
		List<Park> listOfParks = new ArrayList<>();										//define a list of parks to store query results
		String SqlParkList = "SELECT * " + 	//assign SQL query to a String variable
							 "FROM park " + 
							 "ORDER BY parkname";

		SqlRowSet parkList = jdbcTemplate.queryForRowSet(SqlParkList);		// define SqlRowSet object to store results of
																			// query 
		while (parkList.next()) {					//loop through parkList while it has another line
			Park thePark = mapRowToPark(parkList);	//instantiate new Park object, add attributes from SqlRowSet object to new Park object
			listOfParks.add(thePark);				//add each Park object to listOfParks		

		}

		return listOfParks;
	}

	@Override
	public Park getParkByCode(String parkcode) {                          
		Park userPark = new Park();										//instantiate a new Park object
		String SqlUserPark = "SELECT * " +								//define a String to hold SQL query
							 "FROM park " +
							 "WHERE parkcode = ?";
		SqlRowSet parkUser = jdbcTemplate.queryForRowSet(SqlUserPark, 	//define an SqlRowSet object to store results of query
														 parkcode);		//by passing it through JdbcTemplate object using 
																		//queryForRowSet method and passing through the SQL
																		//statement and parkcode attribute
		while (parkUser.next()) {				//while parkUser has a next line
			userPark = mapRowToPark(parkUser);	//map row to to new Park object instantiated above
		}
		
		return userPark;
	}

	private Park mapRowToPark(SqlRowSet parkList) {			//method used ONLY within this DAO to map and SQL row to a Park object

		Park aPark = new Park();							

		aPark.setParkCode(parkList.getString("parkcode"));	//setting attributes of Park object using data from database column names
		aPark.setParkName(parkList.getString("parkname"));
		aPark.setState(parkList.getString("state"));
		aPark.setParkDescription(parkList.getString("parkdescription"));
		aPark.setClimate(parkList.getString("climate"));
		aPark.setInpirationalQuote(parkList.getString("inspirationalquote"));
		aPark.setQuoteResource(parkList.getString("inspirationalquotesource"));
		aPark.setAcreage(parkList.getInt("acreage"));
		aPark.setElevationInFeet(parkList.getInt("elevationinfeet"));
		aPark.setMilesOfTrail(parkList.getDouble("milesoftrail"));
		aPark.setNumberOfCampsites(parkList.getInt("numberofcampsites"));
		aPark.setYearFounded(parkList.getInt("yearfounded"));
		aPark.setAnnualVisitorCount(parkList.getInt("annualvisitorcount"));
		aPark.setEntryFee(parkList.getInt("entryfee"));
		aPark.setNumberOfAnimals(parkList.getInt("numberofanimalspecies"));
		return aPark;

	}


}
