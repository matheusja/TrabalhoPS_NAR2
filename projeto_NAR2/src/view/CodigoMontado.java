/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author andrezdc
 */
class CodigoMontado {
    public ArrayList<Integer> codigo;
    public ArrayList<Boolean> relativo;
    public HashMap<String, Integer> tabelaDeSimbolos;
    public HashMap<String, ArrayList<Integer>> tabelaDeUsos;
    
    public CodigoMontado() {
        codigo   = new ArrayList<>();
        relativo = new ArrayList<>();
        tabelaDeSimbolos = new HashMap<>();
        tabelaDeUsos = new HashMap<>();
    }
}
