package com.emas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emas.viewmodel.ClaimViewModel;
import com.emas.viewmodel.HospitalViewModel;
import com.emas.viewmodel.PersonalInfoViewModel;

@Controller
@RequestMapping( value = "/" )
public class HomeController {

	public final String INDEX_VIEW = "index";
	public final String HOSPITAL_VIEW = "hospital";
	public final String CLAIM_VIEW = "claims";
	
	public final String HOSPITAL_VM_CREATE = "hospital_create";
	public final String CLAIM_VM_CREATE = "claim_create";
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public ModelAndView index() {
		
		return new ModelAndView( INDEX_VIEW ); 
	}
	
	@RequestMapping( value = "/hospital", method = RequestMethod.GET )
	public ModelAndView registerHospital() {
		
		HospitalViewModel vm = new HospitalViewModel();
		ModelAndView modelAndView = new ModelAndView( HOSPITAL_VIEW );
		modelAndView.addObject( HOSPITAL_VM_CREATE, vm );
		return modelAndView;
	}
	
	@RequestMapping( value = "/hospital", method = RequestMethod.POST )
	public ModelAndView registerHospital( @ModelAttribute( HOSPITAL_VM_CREATE ) HospitalViewModel vm ) {
		
		
		return new ModelAndView( HOSPITAL_VIEW );
	}
	
	@RequestMapping( value = "/claim", method = RequestMethod.GET )
	public ModelAndView registerClaim( @ModelAttribute( CLAIM_VM_CREATE ) ClaimViewModel vm, HttpServletRequest request ) {
		
		List<PersonalInfoViewModel> personalInfoList = new ArrayList<PersonalInfoViewModel>();
		
		PersonalInfoViewModel personalInfoVM = new PersonalInfoViewModel( "test", "test", "", "", true );
//		PersonalInfoViewModel personalInfoVM1 = new PersonalInfoViewModel( "test1", "test1", "", "", true );
//		PersonalInfoViewModel personalInfoVM2 = new PersonalInfoViewModel( "test2", "test2", "", "", true );
		personalInfoList.add( personalInfoVM );
//		personalInfoList.add( personalInfoVM1 );
//		personalInfoList.add( personalInfoVM2 );
		vm.setPersonalInfoList( personalInfoList );
		vm.setAdmissionId( "testing ...." );
		vm.setMemberName( "testing member ..." );
		
		ModelAndView modelAndView = new ModelAndView( CLAIM_VIEW );
		modelAndView.addObject( CLAIM_VM_CREATE, vm );
		modelAndView.addObject( "personalInfo", vm.getPersonalInfoList() );
		return modelAndView;
	}
	
	/*@RequestMapping( value="/claim/getChildRow", method = RequestMethod.GET )
	public ModelAndView getChildRow( @RequestParam("index") String index ) {
		
		PersonalInfoViewModel personalInfoVM = new PersonalInfoViewModel();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "/partial/personal_info.jsp" );
		return modelAndView;
	}*/
	
}
