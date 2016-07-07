package com.event.talent.management.client.interfaces;

import com.event.talent.management.shared.model.UserModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface LoginRPCServiceAsync {
	void login(UserModel user, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
