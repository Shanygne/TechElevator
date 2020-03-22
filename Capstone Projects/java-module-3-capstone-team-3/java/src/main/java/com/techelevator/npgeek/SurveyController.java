package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController {

	@Autowired
	SurveyDao aSurvey;
	@Autowired
	ParkDao aPark;
	@Autowired
	private AuthProvider auth;

	@RequestMapping(path = "/surveyPage", method = RequestMethod.GET)
	public String getSurveyPage(Model modelHolder) throws UnauthorizedException {
		if (!auth.isLoggedIn()) {
			throw new UnauthorizedException();
		}
		if (!modelHolder.containsAttribute("Survey")) {
			modelHolder.addAttribute("Survey", new Survey());
		}

		List<Park> allParkNames = new ArrayList<>();
		allParkNames = aPark.listAllParks();
		modelHolder.addAttribute("theNames", allParkNames);
		
		return "SurveyPage";
	}

	@RequestMapping(path = "/surveyPage", method = RequestMethod.POST)
	public String saveNewSurvey(@Valid @ModelAttribute("Survey") Survey theSurvey) {

		aSurvey.createNewSurvey(theSurvey);

		return "redirect:/favoriteParks";
	}

	@RequestMapping(path = "/favoriteParks", method = RequestMethod.GET)
	public String viewFavoriteParks(ModelMap parkSurveys) throws UnauthorizedException {
		if (!auth.isLoggedIn()) {
			throw new UnauthorizedException();
		}
		
		List<Survey> allSurveys = new ArrayList<>();
		allSurveys = aSurvey.listParksOnSurveyCount();
		parkSurveys.put("theSurveys", allSurveys);

		return "FavoriteParks";

	}

}
