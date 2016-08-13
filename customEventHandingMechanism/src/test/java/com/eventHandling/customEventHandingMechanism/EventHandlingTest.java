package com.eventHandling.customEventHandingMechanism;

import junit.framework.TestCase;

import com.eventHandlingMechanism.dataModels.LoginModel;
import com.eventHandlingMechanism.dataModels.UserModel;
import com.eventHandlingMechanism.handlers.LoginHandler;
import com.eventHandlingMechanism.handlers.UserHandler;

public class EventHandlingTest extends TestCase {
	public interface CallBack {
		void process(String printInput);
	}

	CallBack callback = new CallBack() {
		public void process(String printInput) {
			System.out.println(printInput);
		}
	};
	public void testUser() {
		UserHandler handler = new UserHandler();
		UserModel dataModel = new UserModel();
		dataModel.setName("Karan");
		dataModel.setLanguage("English");
		Event<CallBack, UserModel> userEvent = new Event<CallBack, UserModel>(
				callback, dataModel);
		Registry.register(userEvent, handler);
		Registry.fireEvent(userEvent);
	}
	public void testLogin() {
		LoginHandler loginHandker = new LoginHandler();
		LoginModel loginModel = new LoginModel();
		loginModel.setUserName("karan.krishan");
		loginModel.setPassword("password");
		Event<CallBack, LoginModel> loginEvent = new Event<CallBack, LoginModel>(
				callback, loginModel);
		Registry.register(loginEvent, loginHandker);
		Registry.fireEvent(loginEvent);
	}
}
