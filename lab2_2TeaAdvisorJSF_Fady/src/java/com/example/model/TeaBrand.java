/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author fadyyounan
 */
public class TeaBrand {
    String name;
    String description;
    String picture;
    
    public TeaBrand(String name, String description, String picture) {
        this.name = name;
        this.description = description;
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
