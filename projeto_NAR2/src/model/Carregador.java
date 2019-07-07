
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Carregador {

    public static void carregar(Maquina m, String filename) throws IOException {
        List<String> l = readFile(filename);
        ArrayList<Integer> mem = m.getMem();
        for (int i = 0; i < l.size(); i++) {
            mem.add(Translate.binToDecSigned(l.get(i)));
            System.out.println(mem.get(i));
        }
    }

    private static List readFile(String filename) throws IOException {
        File directory = new File(filename);
        List<String> allLines = Files.readAllLines(Paths.get(directory.getPath()));
        return allLines;
    }

}
