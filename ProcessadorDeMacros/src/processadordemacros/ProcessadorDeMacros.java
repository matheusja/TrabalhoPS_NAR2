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
public class ProcessadorDeMacros 
{
    
    String readCode(String program)
    {
        CharSequence programArray = (CharSequence)program;
        String programExpanded = "";
        char currentChar;
        StringBuilder buildProgram = new StringBuilder(program.length());
        
        int i = 0;
        
        while(i < programArray.length())
        {
            currentChar = programArray.charAt(i);
            if(currentChar == 'M')
            {   //encontrando definiçao da macro
                if(programArray.charAt(i+1) == 'A' && programArray.charAt(i+2) == 'C'
                && programArray.charAt(i+3) == 'R' && programArray.charAt(i+4) == 'O')
                {
                    i += 6;
                    
                    i = iterateWhiteSpaces(programArray, i);
                        
                    String macroName = Character.toString(programArray.charAt(i));
                    
                    while(programArray.charAt(++i) != ' ')
                    {
                        macroName += Character.toString(programArray.charAt(i));
                    }
                    
                    i = iterateWhiteSpaces(programArray, i);
                      
                    if(programArray.charAt(i) != '(' )
                    {
                        programExpanded = "Error";
                        return programExpanded;
                    }
                    
                    ArrayList<String> listOfParameters = new ArrayList<String>();
                    
                    while(programArray.charAt(i) != ')' )
                    {
                        i = iterateWhiteSpaces(programArray, i);
                        
                        String buildParameter = "";
                        
                        if(programArray.charAt(i) == ')')
                        {
                            break;
                        }
                        else
                        {
                            while(programArray.charAt(i) != ',' && programArray.charAt(i) != ' ')
                            {
                                buildParameter += programArray.charAt(i);
                                i++;
                            }
                            
                            listOfParameters.add(buildParameter);
                        }
                    }
                    
                    
                    while(i <= programArray.length())
                    {
                        iterateWhiteSpaces(programArray, i);
                        
                        String possibleParam = iterateMacroStrings(programArray, i);
                        
                        i += possibleParam.length();
                        
                        for(String str: listOfParameters)
                        {
                            if(str.equals(possibleParam))
                            {
                                int numOfParam = 1 + listOfParameters.indexOf(possibleParam);
                                break;
                            }
                        }
                        
                        
                    }
                    
                    
                    
                    
                }
            }
        }
        
        
        
        return programExpanded;
    }
    
    int iterateWhiteSpaces(CharSequence cs, int index)
    {
        while(cs.charAt(index) == ' ')
        {
            index++;
        }
        return index;
    }
    
    String iterateMacroStrings(CharSequence programArray, int currentIndex)
    {
        String buildString = "";
        
        while(programArray.charAt(currentIndex) != ',' && programArray.charAt(currentIndex) != ' ')
        {
            buildString += programArray.charAt(currentIndex);
            currentIndex++;
        }
        
        return buildString; 
    }
    
    
    
    int iterateMacroStringsIndex(CharSequence programArray, int currentIndex)
    {
        
        while(programArray.charAt(currentIndex) != ',' && programArray.charAt(currentIndex) != ' ')
        {
            currentIndex++;
        }
        
        return currentIndex; 
    }
    
    

    public static void main(String[] args) 
    {
        
    }
    
}
