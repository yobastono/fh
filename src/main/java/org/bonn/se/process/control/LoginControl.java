package org.bonn.se.process.control;

import org.bonn.se.process.control.exceptions.NoSuchUserOrPassword;
import org.bonn.se.services.util.Views;

import com.vaadin.ui.UI;

public class LoginControl {

	
	public static void checkAuthentication(String login, String password) throws NoSuchUserOrPassword{
		
		//DB-Zugriff
		
		// Der Benutzer ist vorhandenden:
		
//        UI.getCurrent().getNavigator().navigateTo(Views.MAIN);
        
        // Fehlerfall
        throw new NoSuchUserOrPassword();

		
	}
}
