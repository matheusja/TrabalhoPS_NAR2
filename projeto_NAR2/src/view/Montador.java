/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador;

/**
 *
 * @author andrezdc
 */
public class Montador 
{
    
    String code;
    CodigoMontado codigoMontado;
    public Montador(String code) {
        this.code = code;
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
        
        
    }
    private void passo2() throws Exception {
        // Levantar erro para simbolo n/ definido que nao eh externo
        
    }
    
    public static CodigoMontado montar(String code) throws Exception {
        Montador mn = new Montador(code);
        return mn.montarInterno();
    }
    
}
