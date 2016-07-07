package com.event.talent.management.client.interfaces;

import com.event.talent.management.shared.model.UserModel;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface LoginRPCService extends RemoteService {
	String login(UserModel user) throws IllegalArgumentException;
}
