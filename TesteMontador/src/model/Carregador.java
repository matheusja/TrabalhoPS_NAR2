
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Carregador {

    public static void carregar(Maquina m, String code) {
        String[] l = code.split("\n");
        ArrayList<Integer> mem = m.getMem();
        for (int i = 0; i < l.length; i++) {
            mem.add(Translate.binToDecSigned(l[i]));
            System.out.println(mem.get(i));
        }
    }
}
