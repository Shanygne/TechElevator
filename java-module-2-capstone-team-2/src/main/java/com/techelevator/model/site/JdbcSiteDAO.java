package com.techelevator.model.site;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class JdbcSiteDAO implements SiteDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Site> getAllAvailableSites(Long campgroundId, LocalDate fromDate, LocalDate toDate) {
		List<Site> siteList = new ArrayList<Site>();
		String sqlGetAllAvailableSitesForDesiredDate = 
				"Select * from site where campground_id = ? and site_id not in (select site_id where site_id in (select site_id from reservation where from_date <= ?)" +
			    " and site_id in (select site_id from reservation where to_date <= ? and to_date >= ?)" +
				" or" +
			    " site_id in (select site_id from reservation where from_date >= ? and from_date <= ?)" +
				" and site_id in (select site_id from reservation where to_date >= ?)" +
			    " or" +
			    " site_id in (select site_id from reservation where from_date >= ? and from_date <= ?)" +
			    " and site_id in (select site_id from reservation where to_date <= ? and to_date >= ?))" +
			    " limit 5;";	
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllAvailableSitesForDesiredDate, campgroundId, fromDate,
																							   toDate, fromDate, 
																							   fromDate, toDate, 
																							   toDate, 
																							   fromDate, toDate, 
																							   toDate, fromDate);

		while(results.next()) {
			Site theSite = mapRowToSite(results);
			siteList.add(theSite);
		}
		return siteList;
		
	}
	
	private Site mapRowToSite(SqlRowSet results) {
		Site theSite;
		theSite = new Site();
		
		theSite.setSiteId(results.getLong("site_id"));
		theSite.setCampgroundId(results.getInt("campground_id"));
		theSite.setSiteNumber(results.getInt("site_number"));
		theSite.setMaxOccupancy(results.getInt("max_occupancy"));
		theSite.setAccessible(results.getBoolean("accessible"));
		theSite.setMaxRvLength(results.getInt("max_rv_length"));
		theSite.setUtilities(results.getBoolean("utilities"));
			
		return theSite;
	}

}
