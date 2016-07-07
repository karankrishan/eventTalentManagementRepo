package com.event.talent.management.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.event.talent.management.shared.model.UserModel;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class BaseServlet extends RemoteServiceServlet {

	private AutowireCapableBeanFactory autowireCapableBeanFactory;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servletContext = config.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();
		this.autowireCapableBeanFactory = autowireCapableBeanFactory;

	}

	private static final long serialVersionUID = 1L;

	protected String storeUserInSession(UserModel user) {
		HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
		HttpSession session = httpServletRequest.getSession(true);
		session.setAttribute("user", user);
		return session.getId();
	}

	protected void deleteUserFromSession() {
		HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
		HttpSession session = httpServletRequest.getSession();
		session.removeAttribute("user");
	}

	protected AutowireCapableBeanFactory getBeanFactoryInstance() {
		return autowireCapableBeanFactory;
	}
}
