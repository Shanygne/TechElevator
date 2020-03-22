package com.techelevator.npgeek;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



@Component
public class JdbcSurveyDao implements SurveyDao{
	
	
	private JdbcTemplate jdbcTemplate;

	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Survey> listParksOnSurveyCount() {
		List<Survey> allSurveys = new ArrayList<>();
		
		String SqlGetAllSurveys = "SELECT survey_result.parkcode, parkname, COUNT(survey_result.parkcode) AS surveycount " +
								  "FROM survey_result " +
								  "INNER JOIN park " +
								  "ON survey_result.parkcode = park.parkcode " +
								  "GROUP BY survey_result.parkcode, park.parkcode " +
								  "ORDER BY surveycount DESC";
		
	
		
		SqlRowSet surveyList = jdbcTemplate.queryForRowSet(SqlGetAllSurveys);
		
		while (surveyList.next()) {
			Survey theSurvey = mapRowToSurvey(surveyList);
			allSurveys.add(theSurvey);
		}
		
		
		return allSurveys;
	}

	@Override
	public Survey createNewSurvey(Survey aSurvey) {
		int id = getNextSurveyId();
		Survey newSurvey = new Survey();
		
		String SqlNewSurvey = "INSERT INTO survey_result(surveyId, parkCode, emailAddress, state, activityLevel) " + 
							  "VALUES(?,?,?,?,?) ";
		
		jdbcTemplate.update(SqlNewSurvey, id, aSurvey.getParkcode(), aSurvey.getEmail(), aSurvey.getState(), aSurvey.getActivityLevel());
		
		aSurvey.setSurveyId(id);
		
		
		
		return newSurvey;
	}
	
//	@Override
//	public void save(Review review) {
//		Long id = getNextId();
//		String sqlInsertReview = "INSERT INTO reviews(review_id, username, rating, review_title, review_text, review_date) VALUES (?,?,?,?,?,?)";
//		jdbcTemplate.update(sqlInsertReview, id, review.getUsername(), review.getRating(), review.getTitle(),
//				review.getText(), LocalDateTime.now());
//		review.setId(id);
//	}
//	
	
	
	
	
	private int getNextSurveyId() {
		String sqlGetNextId =  "select nextval('seq_surveyid')";
		
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet(sqlGetNextId);
		
		int id = 0;
		
		if(nextIdResult.next()) {
			id = nextIdResult.getInt(1);
			return id;
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		} 
	}
	
	private Survey mapRowToSurvey(SqlRowSet surveyList) {
		Survey aSurvey = new Survey();
		
		//aSurvey.setSurveyId(getNextSurveyId());
		aSurvey.setParkName(surveyList.getString("parkname"));
		aSurvey.setParkcode(surveyList.getString("parkcode"));
		aSurvey.setSurveyCount(surveyList.getInt("surveycount"));
		//aSurvey.setEmail(surveyList.getString("emailaddress"));
		//aSurvey.setState(surveyList.getString("state"));
		//aSurvey.setActivityLevel(surveyList.getString("activitylevel"));
		
		return aSurvey;
	}
	
	

}
