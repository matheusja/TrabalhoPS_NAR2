/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador;

import java.util.Scanner;

/**
 *
 * @author andrezdc
 */
public class Montador 
{
    
    String code;
    int index;
    
    CodigoMontado codigoMontado;
    
    public Montador(String code) {
        this.code = code;
        this.index = 0;
        codigoMontado = new CodigoMontado();
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
        while(index < code.length());
        {
            String currentToken = nextToken();
            if (currentToken.equals(":")) {
                if (lastToken == null) {
                    throw new Exception("Simbolo sem nome");
                }
                if (codigoMontado.tabelaDeSimbolos.containsKey(lastToken)) {
                    throw new Exception("Simbolo duplamente definido");
                } else {
                    codigoMontado.tabelaDeSimbolos.put(lastToken, pc);
                }
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
        
    }
    
    public static CodigoMontado montar(String code) throws Exception {
        Montador mn = new Montador(code);
        return mn.montarInterno();
    }
    
}
