/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author mathe
 */
public class Ligador {
    final private ArrayList<CodigoMontado> codigos;
    final private CodigoMontado codigoLinkado;
    private int offset;
    private Ligador(ArrayList<CodigoMontado> codigos) {
        this.codigos = codigos;
        codigoLinkado = new CodigoMontado();
        offset = 0;
    }
    
    private void passo1() throws Exception { // Montar tabelas gerais de simbolo
        for (CodigoMontado cod : codigos) {
            for (String simbolo : cod.tabelaDeSimbolos.keySet()) {
                if (codigoLinkado.tabelaDeSimbolos.containsKey(simbolo)) {
                    throw new Exception("Erro: simbolo duplamente definido " + simbolo);
                }
            }
            cod.tabelaDeSimbolos.keySet().forEach((simbolo) -> { // Colocar os endereços corrigidos
                codigoLinkado.tabelaDeSimbolos.put(simbolo, cod.tabelaDeSimbolos.get(simbolo) + offset);
            });
            cod.tabelaDeUsos.keySet().forEach(new ConsumerImpl(cod));
            offset += cod.codigo.size();
        }
    }
    
    private void passo2() throws Exception { //
        offset = 0;
        codigos.forEach((cod) -> {
            for(int i = 0; i < cod.codigo.size(); i++) {
                if (cod.relativo.get(i)) {
                    Integer value = cod.codigo.get(i);
                    value = correctVal(value, offset, cod.ehInstrucao.get(i));
                    codigoLinkado.codigo.set(i, value);
                }
            }
        });
        for (String simbolo : codigoLinkado.tabelaDeUsos.keySet()) {
            if (!codigoLinkado.tabelaDeSimbolos.containsKey(simbolo)) {
                throw new Exception("Erro: simbolo nao definido " + simbolo);
            }
            Integer changeVal = codigoLinkado.tabelaDeSimbolos.get(simbolo);
            codigoLinkado.tabelaDeUsos.get(simbolo).forEach((n) -> {
                Integer value = codigoLinkado.codigo.get(n);
                value = correctVal(value, changeVal, codigoLinkado.ehInstrucao.get(n));
                codigoLinkado.codigo.set(n, value);
            });
        }
    }
    
    public static CodigoMontado Ligar(ArrayList<CodigoMontado> codigos) throws Exception {
        Ligador l = new Ligador(codigos);
        l.passo1();
        l.passo2();
        return l.codigoLinkado;
    }

    private static Integer correctVal(Integer value, int offset, Boolean isInstruction) {
        if (isInstruction) {
            Instruction s = Translate.decToStruct(value);
            s.setParBin(s.getPaDec() + offset);
            value = Translate.binToDecSigned(s.getInstructionString());
        } else {
            value += offset;
        }
        return value;
    }

    private class ConsumerImpl implements Consumer<String> { // Culpe o netbeans

        private final CodigoMontado cod;

        public ConsumerImpl(CodigoMontado cod) {
            this.cod = cod;
        }

        @Override
        public void accept(String simbolo) {
            ArrayList<Integer> arrList = cod.tabelaDeUsos.get(simbolo);
            for (int i = 0; i < arrList.size(); i++) {
                arrList.set(i, arrList.get(i) + offset);
            }
            codigoLinkado.tabelaDeUsos.put(simbolo, arrList);
        }
    }
}
