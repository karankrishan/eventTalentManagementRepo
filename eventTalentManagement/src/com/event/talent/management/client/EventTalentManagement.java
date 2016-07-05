package com.event.talent.management.client;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class EventTalentManagement implements EntryPoint {

	@Override
	public void onModuleLoad() {
		final Window w = new Window();
		w.setClosable(Boolean.FALSE);
		w.setMinimizable(Boolean.FALSE);
		w.setMaximizable(Boolean.FALSE);
		w.setSize(250, 150);
		w.setLayout(new FitLayout());
		FlexTable panel = new FlexTable();
		Label userNamelabel = new Label("Username");
		final TextField<String> text = new TextField<String>();
		text.setEmptyText("Enter your full name");
		Label passwordlabel = new Label("Password");
		final TextField<String> password = new TextField<String>();
		password.setPassword(Boolean.TRUE);
		password.setEmptyText("Password");

		panel.setWidget(0, 0, userNamelabel);
		panel.setWidget(0, 1, text);
		panel.setWidget(1, 0, passwordlabel);
		panel.setWidget(1, 1, password);

		// panel.add(password);
		Button reset = new Button("Reset");
		reset.addClickListener(new ClickListener() {

			@Override
			public void onClick(Widget sender) {
				text.reset();
				password.reset();
			}
		});
		Button login = new Button("Login");
		login.addClickListener(new ClickListener() {

			@Override
			public void onClick(Widget sender) {
				RootPanel.get().remove(w);
				new Layout().load();
			}
		});
		panel.setWidget(2, 0, reset);
		panel.setWidget(2, 1, login);
		w.add(panel);
		RootPanel.get().add(w);
		w.center();
	}
}
