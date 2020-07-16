package com.example.demo.app.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@GetMapping("/form")
	public String form(SurveyForm surveyForm, 
			Model model) {
		model.addAttribute("title", "テスト表示。");
		return "survey/form";
	}
	



}
