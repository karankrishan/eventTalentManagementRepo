package com.event.talent.management.stepDefs;

import junit.framework.Assert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.event.talent.management.service.interfaces.ILoginService;
import com.event.talent.management.service.interfaces.impl.LoginServiceImpl;
import com.event.talent.management.shared.model.UserModel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {

	private ApplicationContext applicationContext;
	ILoginService loginService;
	Boolean validate;

	public LoginStepDef() {
		applicationContext = new ClassPathXmlApplicationContext("Beans.xml");

	}

	@Given("^I have chosen to log in.$")
	public void I_have_chosen_to_log_in() throws Throwable {
		loginService = (LoginServiceImpl) applicationContext
				.getBean("loginService");
	}

	@When("^I login with details. \"([^\"]*)\" as username and \"([^\"]*)\" as password.$")
	public void I_login_with_details_as_username_and_as_password(
			String userName, String pass) throws Throwable {
		UserModel model = new UserModel();
		model.setUsername(userName);
		model.setPassword(pass);
		validate = loginService.validate(model);

	}

	@Then("^The service should validate the credentials.$")
	public void The_service_should_validate_the_credentials() throws Throwable {
		Assert.assertEquals(Boolean.TRUE, validate);
	}

}
