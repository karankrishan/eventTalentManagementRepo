/**
 * 
 */
package com.eventHandlingMechanism.handlers;

import com.eventHandling.customEventHandingMechanism.Event;
import com.eventHandling.customEventHandingMechanism.EventHandlingTest.CallBack;
import com.eventHandling.customEventHandingMechanism.IHandler;
import com.eventHandlingMechanism.dataModels.UserModel;

/**
 * @author KARAN KRISHAN
 *
 */
public class UserHandler implements IHandler {

	public void handle(Event event) {
		UserModel userMdel = (UserModel) event.getDataModel();
		CallBack callback = (CallBack) event.getCallback();
		callback.process("Bonjour " + userMdel.getName());
	}

}
