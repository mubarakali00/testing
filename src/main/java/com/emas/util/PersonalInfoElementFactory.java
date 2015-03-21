package com.emas.util;

import org.springframework.util.AutoPopulatingList.ElementFactory;
import org.springframework.util.AutoPopulatingList.ElementInstantiationException;

import com.emas.viewmodel.PersonalInfoViewModel;

public class PersonalInfoElementFactory implements ElementFactory<PersonalInfoViewModel> {

	@Override
	public PersonalInfoViewModel createElement(int index) throws ElementInstantiationException {
		
		PersonalInfoViewModel vm = new PersonalInfoViewModel();
		vm.setAge("");
		vm.setFatherName("");
		vm.setName("");
		vm.setRemarks("");
		return vm;
	}

}
