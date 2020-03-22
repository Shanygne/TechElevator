package com.techelevator.ssg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.calculator.AlienAgeCalculator;

@Controller
public class AlienAgeController {

	@RequestMapping("/alienAgeInput")
	public String displayAlienAgeInput() {
		
		return "alienAgeInput"; // name of jsp
	}
	
	@RequestMapping("/alienAgeOutput")
	public String displayAlienAgeOutput(@RequestParam double earthAge, @RequestParam String planetChoice, ModelMap modelHolder) {
		AlienAgeCalculator calculator = new AlienAgeCalculator(earthAge, planetChoice);
		modelHolder.put("convert", calculator);
		return "alienAgeOutput"; // name of jsp
	}
}
