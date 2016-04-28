package com.corejsf;

import java.io.Serializable;
import javax.inject.Named; 
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;

enum teaType{Type1,Type2,Type3};

@Named("teas") // or @ManagedBean
@RequestScoped
public class Planetarium implements Serializable {
  private String selectedPlanet;

  public String getSelectedPlanet() { return selectedPlanet; }
  
  
  
  private SelectItem[] teaItems = {
       new SelectItem(teaType.Type1,"T"),
       new SelectItem(teaType.Type2,"E"),
       new SelectItem(teaType.Type2,"A"),
  };

    public SelectItem[] getTeaItems() {
        return teaItems;
    }
  
  
  public String changePlanet(String newValue) {
     selectedPlanet = newValue;
     return selectedPlanet;
  }
}

class SelectItem
{
    private teaType t;
    private String name;

    public SelectItem(teaType t, String name) {
        this.t = t;
        this.name = name;
    }

    public teaType getT() {
        return t;
    }

    public String getName() {
        return name;
    }
    
}