package com.eventHandlingMechanism.handlers;

import com.eventHandling.customEventHandingMechanism.Event;
import com.eventHandling.customEventHandingMechanism.IHandler;
import com.eventHandling.customEventHandingMechanism.EventHandlingTest.CallBack;
import com.eventHandlingMechanism.dataModels.LoginModel;

public class LoginHandler implements IHandler {

	public void handle(Event event) {
		LoginModel dataModel = (LoginModel) event.getDataModel();
		CallBack callback = (CallBack) event.getCallback();
		callback.process(dataModel.getUserName() + " :: "
				+ dataModel.getPassword());
	}

}
