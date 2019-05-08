/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se.model.objects.dto;

/**
 *
 * @author yobastono
 */
public class Hotel implements java.io.Serializable {
    
    private String name;
    private Integer id;
    private String ort;
    private String description;
    
    public Hotel(String name, Integer id, String ort, String description) {
        this.name = name;
        this.id = id;
        this.ort = ort;
        this.description = description;
    }
    
    public Hotel() {
        
    }
     
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    } 

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    } 
    public String getOrt() {
        return this.ort;
    }
    
    public void setOrt(String ort) {
        this.ort = ort;
    }     
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    } 
}
