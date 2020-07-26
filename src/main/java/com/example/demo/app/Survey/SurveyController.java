package com.example.demo.app.Survey;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@GetMapping("/form")
	public String form(SurveyForm surveyForm, 
			Model model) {
		model.addAttribute("title", "Survey Form");
		return "survey/form";
	}
	
	@PostMapping("/form")
	public String formGoBack(SurveyForm surveyForm, 
			Model model) {
		model.addAttribute("title", "Survey Form");
		return "survey/form";
	}
	
	@PostMapping("/confirm")
	public String Confirm(@Validated SurveyForm surveyForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "SurveyForm");
			return "survey/form";	
		}
		model.addAttribute("title", "SurveyForm_P2");
		return "survey/confirm";	
	}
	
	@PostMapping("/complete")
	public String Conplete(@Validated SurveyForm surveyForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("title", "SurveyForm_Re");
			return "survey/form";
		}
		redirectAttributes.addFlashAttribute("complete", "Thanks for your cooperation!");
		return "redirect:/survey/form";		
	}
	
	



}
