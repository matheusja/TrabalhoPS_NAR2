package processadordemacros;

import java.util.ArrayList;
import java.util.Scanner;

public class Macro {

    public final String nome;
    public final String expansao;
    public final int parametros;
    
    /* Os nomes dos parâmetros são irrelevantes*/
    public static final String MACRO_RELATIVE_DECLARATION = "_RELATIVE";
    private static int expasions = 0;

    public Macro(String nome, String expansao) {
        this(nome, expansao, new ArrayList<String>());
    }

    public Macro(String nome, String expansao, ArrayList<String> parametros) {
        this.nome = nome;
        this.parametros = parametros.size();
        String novaExpansao = ""; // Talvez seja o caso de usar um charSequence
        for (int i = 0; i < expansao.length();) { // Algoritmo O( |maior|*|menor|), aqui serve
            try {
                if (expansao.substring(i, i + MACRO_RELATIVE_DECLARATION.length()).equals(MACRO_RELATIVE_DECLARATION)) {
                    novaExpansao += "&"; // "endereco"
                    i += MACRO_RELATIVE_DECLARATION.length();
                    continue;
                }
            } catch (java.lang.StringIndexOutOfBoundsException se) {
            };
            int j = 0;
            for (; j < parametros.size(); j++) {
                String s = parametros.get(j);
                try {
                    if (expansao.substring(i, i + s.length()).equals(s) && isValidCharacter(expansao.charAt(i + s.length()))) {
                        novaExpansao += "$" + j;
                        i += s.length();
                        break;
                    }
                } catch (java.lang.StringIndexOutOfBoundsException se) {
                };
            }
            if (j == parametros.size()) {
                novaExpansao += expansao.charAt(i);
                i++;
            }
        }
        this.expansao = novaExpansao;
    }

    public String expandir(ArrayList<String> param) throws Exception {
        if (param.size() < parametros) {
            throw new Exception("Esperava pelo menos " + parametros + " parametros, encontrei apenas" + param.size() + "\n");
        }
        String result = "";
        for (int i = 0; i < expansao.length();) {
            char c = expansao.charAt(i);
            switch (c) {
                case '&':
                    result += '&' + expasions;
                    i++;
                    break;
                case '$':
                    i++;
                    int t = 0;
                    c = expansao.charAt(i);
                    for (; i < expansao.length() && isDigit(expansao.charAt(i)); i++) {
                        t *= 10;
                        t += c - '0'; // Converter para inteiro
                    }
                    result += param.get(t);
                    break;
                default:
                    result += c;
                    i++;
                    break;
            }
        }
        expasions++;
        return result;
    }
    public static boolean isValidCharacter(char c) {
        return isWhiteSpace(c) || c == ')';
    }
    public static boolean isWhiteSpace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '#';
    }

    public static boolean isDigit(char c) {
        return (c >= '0') && (c <= '9');
    }

    public boolean equals(Macro m) {
        return this.nome.equals(m.nome) && this.expansao.equals(m.expansao) && (this.parametros == m.parametros);
    }
}
