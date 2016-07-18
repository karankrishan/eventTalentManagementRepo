package com.event.talent.management.stepDefs;

import junit.framework.Assert;

import com.event.talent.management.service.interfaces.ILoginService;
import com.event.talent.management.service.interfaces.impl.LoginServiceImpl;
import com.event.talent.management.shared.model.UserModel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	ILoginService loginService;
	Boolean validate;

	@Given("^I have chosen to log in.$")
	public void I_have_chosen_to_log_in() throws Throwable {
		loginService = new LoginServiceImpl();
	}

	@When("^I login with details.$")
	public void I_login_with_details() throws Throwable {
		UserModel model = new UserModel();
		model.setUsername("Karan");
		model.setPassword("pass");
		validate = loginService.validate(model);

	}

	@Then("^The service should validate the credentials.$")
	public void The_service_should_validate_the_credentials() throws Throwable {
		Assert.assertEquals(Boolean.TRUE, validate);
	}

}
