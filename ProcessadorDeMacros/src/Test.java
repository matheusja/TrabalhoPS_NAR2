/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matheus
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import processadordemacros.ProcessadorMacros;

public class Test {
    public static void main(String[] args) throws IOException, Exception {
        String total = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("teste.txt"));
            String line = reader.readLine();
            total += line;
            while ((line = reader.readLine()) != null)
            {
              total += "\n" + line;
            }
        } finally {
            reader.close();
        }
        total = ProcessadorMacros.processar(total);
        System.out.println(total);
    }
}
