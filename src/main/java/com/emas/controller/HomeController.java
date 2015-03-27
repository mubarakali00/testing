package com.emas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emas.util.PersonalInfoElementFactory;
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
	
	//[start] InitBinder function to set the auto grow of list as false.
	@InitBinder
	public void initBinder(WebDataBinder binder){
	    
		binder.setAutoGrowNestedPaths(false);
	}
	//[end]
	
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
	public ModelAndView registerClaim( @ModelAttribute( CLAIM_VM_CREATE ) ClaimViewModel vm ) {
				
		List<PersonalInfoViewModel> list = new AutoPopulatingList<PersonalInfoViewModel>( PersonalInfoViewModel.class );
		list.add( new PersonalInfoViewModel( "test 1", "", "", "" ) );
		list.add( new PersonalInfoViewModel( "test 2", "", "", "" ) );
		
		vm.setPersonalInfoList( list );
		vm.setAdmissionId( "testing ...." );
		vm.setMemberName( "testing member ..." );

		ModelAndView modelAndView = new ModelAndView( CLAIM_VIEW );
		return modelAndView;
	}
	
	@RequestMapping( value = "/claim", method = RequestMethod.POST )
	public ModelAndView registerClaimPOST( @ModelAttribute( CLAIM_VM_CREATE ) ClaimViewModel vm, BindingResult result ) {
				
		ModelAndView modelAndView = new ModelAndView( CLAIM_VIEW );
		return modelAndView;
	}
	
	@RequestMapping( value="/claim/getChildRow", method = RequestMethod.GET )
	public ModelAndView getChildRow( @RequestParam("index") int index, @ModelAttribute( CLAIM_VM_CREATE ) ClaimViewModel vm ) {
		
		vm.setPersonalInfoList( new AutoPopulatingList<PersonalInfoViewModel>( new PersonalInfoElementFactory() ) );
		ModelAndView modelAndView = new ModelAndView( "partial/personal_info" );
		modelAndView.addObject( CLAIM_VM_CREATE, vm );
		modelAndView.addObject( "index", index );
		
		return modelAndView;
	}
	
}
