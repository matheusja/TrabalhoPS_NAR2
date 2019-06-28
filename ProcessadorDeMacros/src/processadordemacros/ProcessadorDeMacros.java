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
        StringBuilder buildMacro = new StringBuilder(200);
        ArrayList<Macro> macros = new ArrayList<Macro>();
        
        int i = 0;
        
        while(i < programArray.length())
        {
            i = ignoreComments(programArray, i);
            currentChar = programArray.charAt(i);
            
            //encontrando definiçao da macro
            if(currentChar == 'M')
            {   
                if(programArray.charAt(i+1) == 'A' && programArray.charAt(i+2) == 'C'
                && programArray.charAt(i+3) == 'R' && programArray.charAt(i+4) == 'O')
                {
                    i += 5;
                    i = ignoreComments(programArray, i);
                    i = iterateWhiteSpaces(programArray, i);
                    i = ignoreComments(programArray, i);
                    
                    //Definindo nome da macro
                    String macroName = Character.toString(programArray.charAt(i));
                    
                    while(programArray.charAt(++i) != ' ' && programArray.charAt(++i) != '(')
                    {
                        macroName += Character.toString(programArray.charAt(i));
                    }
                    
                    //encontrando os parametros da macro
                    i = iterateWhiteSpaces(programArray, i);
                    i = ignoreComments(programArray, i);
                    
                    if(programArray.charAt(i) != '(' )
                    {
                        programExpanded = "Error";
                        return programExpanded;
                    }
                    
                    ArrayList<String> listOfParameters = new ArrayList<String>();
                    
                    while(programArray.charAt(i) != ')' )
                    {
                        i = iterateWhiteSpaces(programArray, i);
                        i = ignoreComments(programArray, i);
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
                                i = ignoreComments(programArray, i);
                            }
                            
                            listOfParameters.add(buildParameter);
                        }
                    }
                    
                    
                    //Adicionando macro à lista de macros
                    Macro macro = new Macro(macroName, listOfParameters);
                    //macros.add(macro);
                    
                    
                    //Achar o fim da macro
                    while(((programArray.charAt(i)) != 'E') && ((programArray.charAt(i+1)) != 'N') && ((programArray.charAt(i+2)) != 'D') && ((programArray.charAt(i+3)) != '_') && ((programArray.charAt(i+4)) != 'M') && ((programArray.charAt(i+5)) != 'A') && ((programArray.charAt(i+6)) != 'C') && ((programArray.charAt(i+7)) != 'R') && ((programArray.charAt(i+8)) != 'O'))
                    {
                        i = iterateWhiteSpaces(programArray, i);
                        i = ignoreComments(programArray, i);
                        String possibleParam = iterateMacroStrings(programArray, i);
                        
                        
          
                        
                        i += possibleParam.length();
                        i = ignoreComments(programArray, i);
                        i = iterateWhiteSpaces(programArray, i);
                        
                        int numParam = 99999;
                        boolean foundParam = false;
                        
                        for(String str: listOfParameters)
                        {
                            if(str.equals(possibleParam))
                            {
                                numParam = listOfParameters.indexOf(possibleParam);
                                foundParam = true;
                                break;
                            }
                        }
                        
                        if(foundParam)
                        {
                            buildProgram.append("$"+ numParam +" ");
                            buildMacro.append("$"+ numParam +" ");
                        }
                        else 
                        {
                            buildProgram.append(possibleParam + " ");
                            buildMacro.append(possibleParam +" ");
                        }
                            
                        
                        
                        
                    }
                    
                    //Passando o codigo da macro para dentro da classe
                    macro.setCode(buildMacro.toString());
                    macros.add(macro);
                    
                    
                }
            }
            
            else
            {
                String possibleMacroCall = "";
                
                i = ignoreComments(programArray, i);
                i = iterateWhiteSpaces(programArray, i);
                i = ignoreComments(programArray, i);
                
                possibleMacroCall = iterateMacroStrings(programArray, i);
                
                i += possibleMacroCall.length();
                
                char possibleParenthesis = programArray.charAt(i+1);
                i++;
                
                if(possibleParenthesis == '(')
                {
                    
                    if( programArray.charAt(i+1) == ')' )
                    {
                        for(Macro macrozinha : macros)
                        {
                            if(possibleMacroCall.equals(macrozinha.getName())){
                                buildProgram.append(macrozinha.getCode());
                            }
                        }
                    }
                    else
                    {
                        for(Macro macrozinha : macros)
                        {
                            if(possibleMacroCall.equals(macrozinha.getName()))
                            {
                                String macroName = macrozinha.getCode();
                            }
                        }
                        
                        ArrayList< String > realParameters = new ArrayList<String>();
                        
                        i++;
                        
                        String parameter;
                        
                        while( programArray.charAt(i) != ')' )
                        {
                            parameter = iterateMacroStrings(programArray, i);
                            realParameters.add(  );
                        }
                    
                    }
                    
                    i += 2;
                    
                    String currentParam = iterateMacroStrings(programArray, i);
                    
                    
                }
                else
                {
                    buildProgram.append(possibleMacroCall + " ");
                }
                i = ignoreComments(programArray, i);
                i = iterateWhiteSpaces(programArray, i);
                i = ignoreComments(programArray, i);
                
                
            }
        }
        
        
        
        return programExpanded;
    }
    
    int iterateWhiteSpaces(CharSequence cs, int index)
    {
        while(cs.charAt(index) == ' ' || cs.charAt(index) == '\n')
        {
            index++;
        }
        return index;
    }
    
    String iterateMacroStrings(CharSequence programArray, int currentIndex)
    {
        String buildString = "";
        
        while(programArray.charAt(currentIndex) != ',' && programArray.charAt(currentIndex) != ' '
                && programArray.charAt(currentIndex) != '\n')
        {
            buildString += programArray.charAt(currentIndex);
            currentIndex++;
        }
        
        return buildString; 
    }
    
    
    int ignoreComments(CharSequence programArray, int currentIndex){
        
        if(currentIndex == '#'){
            currentIndex++;
            while(currentIndex != '#'){
                currentIndex++;
            }
            
        }
        return currentIndex;
    }

    public static void main(String[] args) 
    {
        
    }
    
}
