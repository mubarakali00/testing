package com.emas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emas.viewmodel.HospitalViewModel;

@Controller
@RequestMapping( value = "/" )
public class HomeController {

	public final String INDEX_VIEW = "index";
	public final String HOSPITAL_VIEW = "hospital";
	
	public final String VIEWMODEL_CREATE = "hospital_create";
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public ModelAndView index() {
		
		return new ModelAndView( INDEX_VIEW ); 
	}
	
	@RequestMapping( value = "/hospital", method = RequestMethod.GET )
	public ModelAndView registerHospital() {
		
		HospitalViewModel vm = new HospitalViewModel();
		ModelAndView modelAndView = new ModelAndView( HOSPITAL_VIEW );
		modelAndView.addObject( VIEWMODEL_CREATE, vm );
		return modelAndView;
	}
	
	@RequestMapping( value = "/hospital", method = RequestMethod.POST )
	public ModelAndView registerHospital( @ModelAttribute( VIEWMODEL_CREATE ) HospitalViewModel vm ) {
		
		
		return new ModelAndView( HOSPITAL_VIEW );
	}
}
