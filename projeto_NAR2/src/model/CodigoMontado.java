/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author andrezdc
 */
public class CodigoMontado {
    public ArrayList<Integer> codigo;
    public ArrayList<Boolean> relativo;
    public ArrayList<Boolean> ehInstrucao;
    public HashMap<String, Integer> tabelaDeSimbolos;
    public HashMap<String, ArrayList<Integer>> tabelaDeUsos;
    
    public CodigoMontado() {
        codigo   = new ArrayList<>();
        relativo = new ArrayList<>();
        ehInstrucao = new ArrayList<>();
        tabelaDeSimbolos = new HashMap<>();
        tabelaDeUsos = new HashMap<>();
    }
    
    @Override
    public String toString() {
        String result = "";
        result = codigo.stream().map((cod) -> Translate.decTobin32(cod) + "\n").reduce(result, String::concat);
        return result;
    }
}
