package com.event.talent.management.client;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;

public class EventTalentManagement implements EntryPoint {

	private TextField<String> password = new TextField<String>();
	private TextField<String> userInput = new TextField<String>();
	private Window w = new Window();

	@Override
	public void onModuleLoad() {
		FlexTable panel = new FlexTable();
		Label userNamelabel = new Label("Username");
		Label passwordlabel = new Label("Password");
		userInput.setEmptyText("Username");
		password.setPassword(Boolean.TRUE);
		password.setEmptyText("Password");

		w.setClosable(Boolean.FALSE);
		w.setMinimizable(Boolean.FALSE);
		w.setMaximizable(Boolean.FALSE);
		w.setSize(250, 150);
		w.setLayout(new FitLayout());

		panel.setWidget(0, 0, userNamelabel);
		panel.setWidget(0, 1, userInput);
		panel.setWidget(1, 0, passwordlabel);
		panel.setWidget(1, 1, password);

		// panel.add(password);
		Button reset = new Button("Reset");
		reset.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				userInput.reset();
				password.reset();
			}
		});
		Button login = new Button("Login");
		login.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				if (validateCredentials()) {
					RootPanel.get().remove(w);
					new Layout().load();
				} else {
					promptMessage();
				}
			}
		});
		userInput.addKeyListener(addListner());
		password.addKeyListener(addListner());
		panel.setWidget(2, 0, reset);
		panel.setWidget(2, 1, login);
		w.add(panel);
		RootPanel.get().add(w);
		w.center();
	}

	private KeyListener addListner() {
		return new KeyListener() {
			@Override
			public void componentKeyPress(ComponentEvent event) {
				if (event.getKeyCode() == 13) {
					if (validateCredentials()) {
						RootPanel.get().remove(w);
						new Layout().load();
					} else {
						promptMessage();
					}
				}
			}
		};
	}

	private void promptMessage() {
		Dialog d = new Dialog();
		d.setHeadingText("Alert");
		d.addText("Invalid username/password");
		d.setBodyStyle("fontWeight:bold;padding:12px;");
		d.setSize(150, 100);
		d.setHideOnButtonClick(true);
		d.setButtons(Dialog.OK);
		d.show();
	}

	private boolean validateCredentials() {
		return null != userInput.getValue()
				&& "user".equalsIgnoreCase(userInput.getValue())
				&& null != password.getValue()
				&& "pass".equalsIgnoreCase(password.getValue());

	}
}
