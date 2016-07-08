package com.event.talent.management.service.interfaces.impl;

import com.event.talent.management.service.interfaces.ILoginService;
import com.event.talent.management.shared.model.UserModel;

public class LoginServiceImpl implements ILoginService {

	public boolean validate(UserModel user) {
		return Boolean.TRUE;
	}

}
