/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class ProcessadorMacros {

    private boolean comentario; // Estou dentro de um comentario?
    private ArrayList<Macro> macros;
    private ArrayList<Macro> macros_proibidos; // macros é um array list compartilhado em todos os níveis
    // Esse é o array list de macros que foram chamados nos níveis superiores
    private String resultado;
    private String string;
    private int index;

    public static final String MACRO_DECLARATION = "MACRO";
    public static final String MACRO_END_DECLARATION = "END_MACRO";

    private ProcessadorMacros() {
        this(new ArrayList<Macro>(), new ArrayList<Macro>());
    }

    private ProcessadorMacros(ArrayList<Macro> macros, ArrayList<Macro> macros_proibidos) {
        this.macros = macros;
        this.macros_proibidos = macros_proibidos;
        this.comentario = false;
        this.resultado = "";
        this.index = 0;
    }

    private String processarInterno(String string) throws Exception {
        this.string = string;
        while (index < string.length()) {
            if (stringStartsWith(MACRO_DECLARATION) && (index + MACRO_DECLARATION.length() >= string.length() || devoIgnorar(string.charAt(index + MACRO_DECLARATION.length())))) { // Declaracao
                index += MACRO_DECLARATION.length();
                try {
                    ignorarEspacos(false);
                    String word = nextWord();
                    if (word.equals("")) {
                        throw new Exception("Erro: a palavra nao pode ser vazia");
                    }
                    ignorarEspacos(false);
                    ArrayList<String> parametros = getParametros();
                    String macro_body = "";
                    int n_defs = 1; // Conta quantos MACRO - END_MACROS existem no codigo
                    while (n_defs > 0) {
                        if (stringStartsWith(MACRO_END_DECLARATION)) {
                            index += MACRO_END_DECLARATION.length();
                            n_defs--;
                            if (n_defs > 0) {
                                macro_body += MACRO_END_DECLARATION;
                            }
                        } else if (stringStartsWith(MACRO_DECLARATION)) {
                            index += MACRO_DECLARATION.length();
                            macro_body += MACRO_DECLARATION;
                            n_defs++;
                        } else {
                            macro_body += string.charAt(index);
                            index++;
                        }
                    }
                    int i = 0;
                    Macro m = new Macro(word, macro_body, parametros);
                    for (; i < macros.size(); i++) {
                        if (macros.get(i).nome.equals(word)) {
                            Macro old_macro = macros.get(i);
                            macros_proibidos.remove(old_macro);
                            macros.set(i, m);
                            break;
                        }
                    }
                    if (i == macros.size()) {
                        macros.add(m);
                    }
                } catch (StringIndexOutOfBoundsException ae) {
                    throw new Exception("Final de arquivo inesperado");
                }
                continue;
            }
            int i;
            for (i = 0; i < macros.size(); i++) {
                Macro m = macros.get(i);
                if (stringStartsWith(m.nome)) { // Expansao(recursivo)
                    for (Macro mn : macros_proibidos) { // Verificar se o macro pode ser usado
                        if (m.equals(mn)) {
                            throw new Exception("Erro: recursao infina de macros");
                        }
                    }
                    index += m.nome.length();
                    ArrayList<String> param = getParametros();
                    String expansao = m.expandir(param);

                    macros_proibidos.add(m);
                    // Esse macro(que vai ser expandido) não pode ser encontrado dentro da propria expansao
                    ProcessadorMacros pm = new ProcessadorMacros(macros, macros_proibidos);
                    this.resultado += pm.processarInterno(expansao); // Recursivo
                    macros_proibidos.remove(m); // Ineficiente: sempre remove o ultimo elemento(isso vira tipo uma pilha) assim o arrayList tem que percorrer todo o array, se for o caso, mudamos o codigo para
                    //macros_proibidos.trimToSize(macros_proibidos.size() - 1);// Talvez seja melhor
                    break;
                }
            }
            if (i == macros.size()) {
                this.resultado += this.string.charAt(index);
                index++;
            }
            ignorarEspacos(true);
        }
        return resultado;
    }

    private void ignorarEspacos(boolean replicar) {
        try {
            char c = string.charAt(index);
            while (devoIgnorar(c)) {
                if (replicar) {
                    resultado += c;
                }
                index++;
                if (index >= string.length()) {
                    break;
                }
                c = string.charAt(index);
            }
        } catch (java.lang.StringIndexOutOfBoundsException se) {
        };
    }

    private boolean devoIgnorar(char c) {
        if (comentario) {
            if (c == '\n') {
                comentario = false;
            }
            return true;
        }
        if (c == '#') {
            comentario = true;
        }
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    private boolean expect(char c) {
        try {
            return string.charAt(index) == c;
        } catch (java.lang.StringIndexOutOfBoundsException se) {};
        return false;
    }

    private String nextWord() {
        String word = "";
        while (index < string.length() && isWordCharacter(string.charAt(index))) {
            word += string.charAt(index);
            index++;
        }
        return word;
    }

    private ArrayList<String> getParametros() throws Exception {
        ArrayList<String> parametros = new ArrayList<>();
        if (expect('(')) {
            index++;
            ignorarEspacos(false);
            while (!expect(')')) {
                String word = nextWord();
                if ("".equals(word)) { // Palavra vazia(provavelmente caractere invalido)
                    throw new Exception("Erro: caractere invalido detectado");
                }
                parametros.add(word);
                ignorarEspacos(false);
                if (expect(',')) { // Virgula é opcional, e podem haver espacos antes e depois da virgula
                    index++;
                }
                ignorarEspacos(false);
            }
            index++; // Achamos ')'
            ignorarEspacos(false);
        }
        return parametros;
    }

    private static boolean isWordCharacter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == '_');
    }

    @SuppressWarnings("empty-statement")
    private boolean stringStartsWith(String b) {
        try {
            return string.substring(index, index + b.length()).equals(b);
        } catch (java.lang.StringIndexOutOfBoundsException se) {};
        return false;
    }

    public static String processar(String s) throws Exception { // Esse é o método a ser usado 
        ProcessadorMacros processadorMacros = new ProcessadorMacros(); // Java in a nutshell;
        return processadorMacros.processarInterno(s);
    }
}
