package com.techelevator.model.reservation;

import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcReservationDAO implements ReservationDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Reservation createReservation(Integer siteId, String name, LocalDate fromDate, LocalDate toDate) {
		String sqlCreateReservation = "INSERT INTO reservation (reservation_id, site_id, name, from_date, to_date, create_date)" + 
									  "VALUES(?, ?, ?, ?, ?, ?)";
		Long reservationId = getUpdatedReservationId();
		LocalDate createdDate = LocalDate.now();
		jdbcTemplate.update(sqlCreateReservation, reservationId, siteId, name, fromDate, toDate, createdDate);
		
		Reservation newReservation = new Reservation();
		newReservation.setSiteId(siteId); 
		newReservation.setName(name);
		newReservation.setFromDate(fromDate);
		newReservation.setToDate(toDate);
		newReservation.setCreateDate(createdDate);
		System.out.println("Your reservation ID is " + reservationId);
		return newReservation;
	
	}
	
	
	
	private Long getUpdatedReservationId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('reservation_reservation_id_seq')");
			if(nextIdResult.next()) {
				return nextIdResult.getLong(1);
			} else {
				throw new RuntimeException("Something went wrong while getting an id for new reservation");
			}
}
	
}
