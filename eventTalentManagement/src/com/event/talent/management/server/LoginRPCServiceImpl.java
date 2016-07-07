package com.event.talent.management.server;

import com.event.talent.management.client.interfaces.LoginRPCService;
import com.event.talent.management.service.interfaces.ILoginService;
import com.event.talent.management.service.interfaces.impl.LoginServiceImpl;
import com.event.talent.management.shared.model.UserModel;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LoginRPCServiceImpl extends BaseServlet implements LoginRPCService {

	private ILoginService loginService;

	public String login(UserModel user) throws IllegalArgumentException {
		String storeUserInSession = null;
		loginService = (LoginServiceImpl) getBeanFactoryInstance().getBean(
				"loginService");
		boolean validateCredentials = loginService.validate(user);
		if (validateCredentials) {
			storeUserInSession = storeUserInSession(user);
		}
		return storeUserInSession;
	}

}
