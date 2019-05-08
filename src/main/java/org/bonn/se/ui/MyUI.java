package org.bonn.se.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import org.bonn.se.gui.views.LoginView;
import org.bonn.se.gui.views.MainView;
import org.bonn.se.services.util.Views;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
//@Widgetset("org.bonn.se.meinehotelapp.ui.MyAppWidgetset")
@Theme("mytheme")
//@Title("My hotel")
public class MyUI extends UI {
    
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        Navigator navi = new Navigator(this, this);
        
        navi.addView(Views.MAIN, MainView.class);
        navi.addView(Views.LOGIN, LoginView.class);
        
        UI.getCurrent().getNavigator().navigateTo(Views.LOGIN);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
