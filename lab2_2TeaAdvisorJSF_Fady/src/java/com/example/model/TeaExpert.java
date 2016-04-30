/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fadyyounan
 */
public class TeaExpert {
    public List<String> getBrands(String color){
        List<String> brands = new ArrayList<String>();
        if(color.equals("amber")){
            brands.add(getTeaBrandByName("Ahmad Tea").getName());
            brands.add(getTeaBrandByName("Lipton").getName());
        }
        else{
            brands.add(getTeaBrandByName("Argo Tea").getName());
            brands.add(getTeaBrandByName("Barry's Tea").getName());
            brands.add(getTeaBrandByName("Kusmi Tea").getName());
        }
        return brands;
    }
    
    public TeaBrand getTeaBrandByName(String name){
        for(TeaBrand brand:getTeaBrands()){
            if(brand.getName().equals(name))
                return brand;
        }
        return null;
    }
    
    private List<TeaBrand> teaBrands = null;
    public List<TeaBrand> getTeaBrands(){
        if(teaBrands == null)//lazy loading
        {
            teaBrands = new ArrayList<TeaBrand>();
            teaBrands.add(new TeaBrand("Ahmad Tea", "Ahmad Tea of London is a company which produces tea.", "http://upload.wikimedia.org/wikipedia/commons/0/01/Earl_Grey_Ahmad_Tea.jpg"));
            teaBrands.add(new TeaBrand("Lipton", "Lipton is a brand of tea and was also a supermarket chain in Scotland before it was sold off to Argyll Foods, to allow the company to focus solely on tea.", "http://upload.wikimedia.org/wikipedia/en/1/11/Lipton.jpg"));
            teaBrands.add(new TeaBrand("Argo Tea", "Argo Tea is a chain of tea cafes that was founded in the Lincoln Park community area in Chicago, Illinois", "http://upload.wikimedia.org/wikipedia/commons/8/85/20110723_Argo_Tea_HQ.jpg"));
            teaBrands.add(new TeaBrand("Barry's Tea", "Barry's Tea is an Irish tea company founded in 1901 in Cork City.", "http://upload.wikimedia.org/wikipedia/en/5/5e/Barrystea.png"));
            teaBrands.add(new TeaBrand("Kusmi Tea", "Kusmi Tea (or Kusmi-Tea) is a brand of tea with headquarters in Paris, France.", "http://upload.wikimedia.org/wikipedia/commons/8/85/Kusmi_tea.jpg"));
        }
        return teaBrands;
    }
    
    private List<String> teaColors = null;
    public List<String> getTeaColors(){
        if(teaColors == null)//lazy loading
        {
            teaColors = new ArrayList<String>();
            teaColors.add("light");
            teaColors.add("amber");
            teaColors.add("brown");
            teaColors.add("dark");
        }
        return teaColors;
    }
}
