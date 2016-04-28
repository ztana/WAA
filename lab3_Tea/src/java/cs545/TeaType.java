/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs545;

import java.util.*;

/**
 *
 * @author 984881
 */

public class TeaType {
    private String name;
    private List<Tea> teas;
    
    

    public TeaType(String name) {
        this.name = name;
        teas = new ArrayList<Tea>();
    }
    
    public void addTea(Tea t)
    {
        teas.add(t);
    }

    public String getName() {
        return name;
    }

    public List<Tea> getTeas() {
        return teas;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
