/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se.process.control;

import java.util.ArrayList;
import java.util.List;
import org.bonn.se.model.objects.dto.Hotel;

/**
 *
 * @author yobastono
 */
public class HotelSearch {
    // fur css siehe ende video 3
    
    Hotel hotel1 = new Hotel("Hotel Maier", 1, "Köln", "Ein sauberes Hotel");
    Hotel hotel2 = new Hotel("Hotel Gallia", 2, "Milano", "Ein wunderbares Hotel");
    Hotel hotel3 = new Hotel("Hotel unastella", 3, "Milano", "Ein dreckiges Hotel");
    
    private HotelSearch() {
        
    }
    
    public static HotelSearch search = null;
    
    public static HotelSearch getInstance() {
        if (search == null) {
            search = new HotelSearch();
        }
        return search;
    }
    
    public List<Hotel> getHotelByOrt(String ort) {
        // for database later
        ArrayList<Hotel> liste = new ArrayList<>();
        
        if (ort.equals("Köln")) liste.add(hotel1);
        if (ort.equals("Milano")) {
           liste.add(hotel2);           
           liste.add(hotel3);
        }
                      
        return liste;
    }
    
}
