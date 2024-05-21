package com.Grupo2.ConversorTemp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConversorController{
	
	public double celsius(String medida2, double temp){
		 if (medida2.equals("kelvin")) {
			 return temp + 273.15;
		 }else if(medida2.equals("fahr")){
			 return temp * 1.8 + 32;
		 }else{
			 return temp;
		 }
	}
	
	public double kelvin(String medida2, double temp){
		 if (medida2.equals("celsius")) {
			 return temp - 273.15;
		 }else if(medida2.equals("fahr")){
			 return 1.8*(temp - 273)+32;
		 }else{
			 return temp;
		 }
	}
	
	public double fahr(String medida2, double temp){
		 if (medida2.equals("celsius")) {
			 return (temp - 32)/1.8;
		 }else if(medida2.equals("kelvin")){
			 return ((temp - 32)/ 1.8)+273;
		 }else{
			 return temp;
		 }
	}
	
	@GetMapping("/")
	public ModelAndView conversor() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("conversor");
		return modelAndView;
	}
	
	@PostMapping("/conversor")
	public String conversor(@RequestParam ("temp") double temp,
			@RequestParam ("medida1") String medida1,
			@RequestParam ("medida2") String medida2,
			Model model){
		double result = 0;
		
		switch(medida1){
		case "celsius":
			result = celsius(medida2, temp);
			break;
		case "kelvin":
			result = kelvin(medida2, temp);
			break;
		case "fahr":
			result = fahr(medida2, temp);
			break;		
		}
			model.addAttribute("result", result);
			return "conversor";
		}
	
}	

