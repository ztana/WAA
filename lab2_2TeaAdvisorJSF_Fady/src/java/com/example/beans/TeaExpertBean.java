/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import com.example.model.TeaBrand;
import com.example.model.TeaExpert;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author fadyyounan
 * Refactored 11052014kl to simplify getters and move application logic into action method
 */
@Named("expertBn")
@SessionScoped
public class TeaExpertBean implements Serializable {

    private TeaExpert teaExpert = new TeaExpert();

    private String color = null;

    private String brand = null;
    private SelectItem[] brands;  //contains recommended brands to display in the listBrands.xhtml page


    
    
    
    /**
     * @author kl
     * @since 11052014
     * @return navigation string
     * This is an action method that will determine the brands to display for the associated color.  
     * Save them so they can be displayed in the listBrands page
     * Prerequisite:  color should have been set
     * SIDEEFFECTS:  creates a list of SelectItem with recommended brands of tea and stores in the brandItems field
     */
    public String findBrands() {
        SelectItem[] brandItems = new SelectItem[teaExpert.getBrands(color).size()];
        int position = 0;
        for (String brand : teaExpert.getBrands(color)) {
            brandItems[position++] = new SelectItem(brand);
        }
        brands = brandItems;
        return "listBrands";

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    TeaExpert teaBrand = null;
    
    public TeaBrand getTeaBrand(){
        return teaExpert.getTeaBrandByName(brand);
    }
    
    public void resetTeaBrand(){
        teaBrand = null;
        brand = null;
    }
    
    public void resetColor(){
        color = null;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public SelectItem[] getBrands() {
//        SelectItem[] brands = new SelectItem[teaExpert.getBrands(color).size()];
//        int position = 0;
//        for(String brand:teaExpert.getBrands(color)){
//            brands[position++] = new SelectItem(brand);
//        }
        return brands;
    }
    
    public SelectItem[] getTeaColors(){
        SelectItem[] colors = new SelectItem[teaExpert.getTeaColors().size()];
        int position = 0;
        for(String color:teaExpert.getTeaColors()){
            colors[position++] = new SelectItem(color);
        }
        return colors;
    }
    
    public String go2list(){
        return "listBrands";
    }
    

}
