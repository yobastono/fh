/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se.gui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import org.bonn.se.model.objects.dto.Hotel;
import org.bonn.se.process.control.HotelSearch;
import org.bonn.se.ui.MyUI;

/**
 *
 * @author yobastono
 */
public class MainView extends VerticalLayout implements View {

    private int anzahlSuche = 0;
    private Hotel hotelSelected;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setUp();
    }

    public void setUp() {
        
        setMargin(true);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        // elements
        Button searchBtn = new Button("Suche", FontAwesome.SEARCH);
        final TextField textField = new TextField();
        Label labelText = new Label("Gebe Ort ein");
        // add components
        horizontalLayout.addComponent(searchBtn);
        horizontalLayout.addComponent(textField);
        //horizontalLayout.addComponent(new Label("&nbsp", ContentMode.HTML));
        horizontalLayout.addComponent(labelText);
        addComponent(horizontalLayout);
        // setComponents (alignment)
        horizontalLayout.setComponentAlignment(labelText, Alignment.MIDDLE_CENTER);
        setComponentAlignment(horizontalLayout, Alignment.TOP_CENTER);
        Grid<Hotel> grid = new Grid<>(Hotel.class);
        grid.setCaption("Treffer");
        grid.setId("id");
        grid.setSizeFull();
        Button bucheBtn = new Button("Buche");
        bucheBtn.addClickListener((Button.ClickEvent e) -> {
            if (hotelSelected == null) {
                return;
            } else {
                // öffne neues Fenster (mit selektierten Hotel und Buchung findet statt)
                System.out.println("Hotel selektiert: " + this.hotelSelected.getName());
            }
        });
        grid.addItemClickListener((Grid.ItemClick<Hotel> e) -> {
            System.out.println("Zeile selektiert: " + e.getItem().getId());
            hotelSelected = e.getItem();
        });
        searchBtn.addClickListener((Button.ClickEvent e) -> {
            String ort = textField.getValue();
            if (ort.equals("")) {
                Notification.show(null, "Bitte Ort eingeben", Notification.TYPE_HUMANIZED_MESSAGE);
            } else {
                addComponent(grid);
                List<Hotel> liste = HotelSearch.getInstance().getHotelByOrt(textField.getValue());
                this.anzahlSuche++;
                grid.setItems(liste);
                grid.setColumns("description", "id", "name", "ort");
                grid.setCaption("Treffer f\u00fcr " + ort + " (Anzahl der Suche: " + anzahlSuche + ")");
                addComponent(bucheBtn);
                setComponentAlignment(bucheBtn, Alignment.MIDDLE_CENTER);
            }
        });
   //     myUI.setContent(layout);
    }
    
    
    
}
