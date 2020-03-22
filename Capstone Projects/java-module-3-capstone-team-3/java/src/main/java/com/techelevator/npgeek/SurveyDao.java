package com.techelevator.npgeek;

import java.util.List;

public interface SurveyDao {

	public List<Survey>  listParksOnSurveyCount();
	
	public Survey createNewSurvey(Survey aSurvey);
	
}
