/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author andrezdc
 */
public class Montador 
{
    
    String code;
    int index;
    HashMap<String, Integer> instructions;
    
    CodigoMontado codigoMontado;
    
    public Montador(String code) {
        this.code = code;
        this.index = 0;
        codigoMontado = new CodigoMontado();
        instructions = loadInstructions();//new HashMap<String, Integer>();
    }
    
    private CodigoMontado montarInterno() throws Exception {
        passo1();
        passo2();
        
        return codigoMontado;
    }
    private void passo1() throws Exception {
        // EXTERNAL <simb>
        // CONST <num>
        // SPACE <tamanho>
        // '<label>':
        // Levantar erro para simbolo definido 2x
        // Levantar erro para label vazio   
        // <nada>:
        String lastToken = null;
        int pc = 0;
        while(index < code.length())
        {
            String currentToken = nextToken();
            if (currentToken.equals(":")) {
                //pc--;
                if (lastToken == null) {
                    throw new Exception("Simbolo sem nome");
                }
                if (codigoMontado.tabelaDeSimbolos.containsKey(lastToken)) {
                    throw new Exception("Simbolo duplamente definido");
                } else {
                    codigoMontado.tabelaDeSimbolos.put(lastToken, pc);
                }
            }
            else
            {
                lastToken = currentToken;
                pc++;
            }
            
        }
        
    }
    
    private String nextToken() {
        ignorarEspacos();
        String str = "";
        char c = code.charAt(index);
        if (c == ':') {
            return ":";
        }
        while (index < code.length() && !ignoravel(c)) {
            if (c == ':') {
                return str;
            }
            str += c;
            index++;
            c = code.charAt(index);
        }
        
        return str; 
    }
    
    private void ignorarEspacos() {
        char c = code.charAt(index);
        while (index < code.length() && ignoravel(c)) {
            index++;
            if (c == '#') {
                // Comment
                while(index < code.length() && c != '\n') {
                    index++;
                } 
            }
        }
    }
    
    private boolean ignoravel(char c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '#';
    }
    
    
    private void passo2() throws Exception {
        // Levantar erro para simbolo n/ definido que nao eh externo
        
        
        String lastToken = null;
        int pc = 0;
        
        int instructionInt;
                
        while(index < code.length())
        {
            String currentToken = nextToken();
            
            
            if(instructions.get(currentToken) != null)
            {
                instructionInt = instructions.get(currentToken);
                codigoMontado.codigo.add(instructionInt);
            }
            if (currentToken.equals(":")) {
                //pc--;
                if (lastToken == null) {
                    throw new Exception("Simbolo sem nome");
                }
                if (codigoMontado.tabelaDeSimbolos.containsKey(lastToken)) {
                    throw new Exception("Simbolo duplamente definido");
                } else {
                    codigoMontado.tabelaDeSimbolos.put(lastToken, pc);
                }
            }
            else
            {
                //lastToken = currentToken;
                pc++;
            }
            
        }
        
        
    }
    
    public static CodigoMontado montar(String code) throws Exception {
        Montador mn = new Montador(code);
        return mn.montarInterno();
    }
    
    
    private HashMap loadInstructions()
    {
        HashMap<String, Integer> inst = new HashMap<String, Integer>();
        
        int i = 0;
        
        inst.put("ZAR",i++);
        inst.put("MUA",i++);
        inst.put("AUM",i++);
        inst.put("PIR",i++);
        inst.put("SABF",i++);
        inst.put("ODUF",i++);
        inst.put("MNOF",i++);
        inst.put("DELF",i++);
        inst.put("PZAF",i++);
        inst.put("SAB",i++);
        inst.put("ODU",i++);
        inst.put("MNO",i++);
        inst.put("DEL",i++);
        inst.put("PZA",i++);
        inst.put("KON",i++);
        inst.put("DIS",i++);
        inst.put("NEG",i++);
        inst.put("POL",i++);
        inst.put("POD",i++);
        inst.put("NES",i++);
        inst.put("BES",i++);
        inst.put("NUS",i++);
                                
                
        return inst;
    }
    
}
