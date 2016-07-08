package com.event.talent.management.service.interfaces;

import com.event.talent.management.shared.model.UserModel;

public interface ILoginService {
	
	boolean validate(UserModel user);
}
