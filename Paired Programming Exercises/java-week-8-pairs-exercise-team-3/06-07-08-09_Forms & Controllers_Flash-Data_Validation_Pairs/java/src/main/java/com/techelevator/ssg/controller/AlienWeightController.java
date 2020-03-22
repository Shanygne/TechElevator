package com.techelevator.ssg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.calculator.AlienWeightCalculator;

@Controller
public class AlienWeightController {
	
	@RequestMapping("/alienWeightInput") 
		public String showWeightInputPage() {
			return "alienWeightInput";
		}
	
	@RequestMapping("/AlienWeightResult") 
	public String showWeightResultPage(@RequestParam double earthWeight, @RequestParam String planetChoice, ModelMap modelHolder) {
		AlienWeightCalculator calculator = new AlienWeightCalculator(earthWeight, planetChoice);
		modelHolder.put("convert", calculator);
		return "AlienWeightResult";
	}
	
	

}
