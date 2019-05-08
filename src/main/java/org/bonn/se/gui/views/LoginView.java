/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se.gui.views;

import org.bonn.se.process.control.LoginControl;
import org.bonn.se.process.control.exceptions.NoSuchUserOrPassword;
import org.bonn.se.services.util.Views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author yobastono
 */
public class LoginView extends VerticalLayout implements View {

    public void setUp() {
    	
    	this.setSizeFull();

    	Label welcomeLabel = new Label("Bitte ins System einloggen:");
    	
    	final TextField userLogin = new TextField();
    	userLogin.setCaption("UserID");
    	
    	final PasswordField passwordField = new PasswordField();
    	passwordField.setCaption("Passwort eingeben:");
    	
    	VerticalLayout layout = new VerticalLayout();
    	layout.addComponent(userLogin);
    	layout.addComponent(passwordField);
    	
    	Label emptyLabel = new Label("&nbsp", ContentMode.HTML);
        layout.addComponent(emptyLabel);
        
        Panel panel = new Panel("Bitte Login-Daten angeben:");
        panel.addStyleName("login");
        layout.addComponent(panel);
        
        
        this.addComponent(panel);
        this.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
        
        panel.setContent(layout);
        
        Button buttonLogin = new Button("Login", FontAwesome.SEARCH);
        layout.addComponent(buttonLogin);
        layout.setComponentAlignment(buttonLogin, Alignment.MIDDLE_CENTER);
        
        // setting size of panel equal to textfields
        panel.setSizeUndefined();
        
        buttonLogin.addClickListener(e -> {
        	String login = userLogin.getValue();
        	String password = passwordField.getValue();
        	
        	try {
				LoginControl.checkAuthentication(login, password);
			} catch (NoSuchUserOrPassword e1) {
				Notification.show("Fehler", "Login oder Passwort falsch", Notification.Type.ERROR_MESSAGE);
				userLogin.setValue("");
				passwordField.setValue("");
			}
        });
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
    
    
    
}
