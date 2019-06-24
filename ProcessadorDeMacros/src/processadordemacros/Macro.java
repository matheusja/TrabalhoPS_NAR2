/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processadordemacros;

import java.util.ArrayList;

/**
 *
 * @author andrezdc
 */
public class Macro {
    String name;
    ArrayList<String> listOfParameters = new ArrayList<String>();
    
    public Macro(String name, ArrayList listOfParameters){
        this.name = name;
        this.listOfParameters = listOfParameters;
    }

    String getName(){
        return name;
    }
    
    ArrayList getParameters(){
        return listOfParameters;
    }
}
