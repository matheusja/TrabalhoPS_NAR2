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

    
    static final String TESTE = 
 /*           "MUA  dividendo \n" +
"DELF divisor   \n" +
"MNOF divisor   \n" +
"ODUF dividendo \n" +*/
"PZAF    \n" +
"AUM  resto     \n" +
"dividendo: CONST 20\n" +
"divisor: CONST 10\n" +
"resto: SPACE 1";
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        CodigoMontado mnt = Montador.montar(TESTE);
        String str = mnt.toString();
        System.out.print(mnt.toString() + "\n\n\n");
        ArrayList<CodigoMontado> mn = new ArrayList<>();
        mn.add(mnt);
        mnt = Ligador.ligar(mn);
        System.out.print(mnt.toString() + "\n\n\n");
        
        
    }
    
}
