/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testemontador;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author mathe
 */
public class TesteMontador {

    
    static final String TESTE1 = 
"PZAF    \n" +
"AUM  resto     \n";
    static final String TESTE2 =
"resto: SPACE 1";
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ArrayList<CodigoMontado> mnt = new ArrayList<>();
        CodigoMontado result = Montador.montar(TESTE1);
        mnt.add(result);
        result = Montador.montar(TESTE2);
        mnt.add(result);
        result = Ligador.ligar(mnt);
        System.out.print(result.toString() + "\n\n");
    }
    
}
