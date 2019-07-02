/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processadordemacros;

import java.util.ArrayList;
import java.util.Scanner;

public class Macro {
	public final String nome;
	public final String expansao;
	public final int parametros; /* Os nomes dos parâmetros são irrelevantes*/
	public static final String MACRO_RELATIVE_DECLARATION = "_RELATIVE";
	private static int expasions = 0;
	public Macro(String nome, String expansao) {
		this(nome, expansao, new ArrayList<String>());
	}
	public Macro(String nome, String expansao, ArrayList<String> parametros) {
		this.nome = nome;
		this.parametros = parametros.size();
		String novaExpansao = ""; // Talvez seja o caso de usar um charSequence
		for (int i = 0; i < expansao.length(); i++) { // Algoritmo O( |maior|*|menor|), aqui serve
			for (int j = 0; j < parametros.size(); j++) {
				String s = parametros.get(j);
				if (expansao.substring(i, i + s.length()).equals(s) && isWhiteSpace(expansao.charAt(i + s.length()))) {
					novaExpansao += "$" + j;
					i += s.length();
					break;
				}
			}
			novaExpansao += expansao.charAt(i);
		}
		this.expansao = novaExpansao;
	}
	public String expandir(ArrayList<String> param) throws Exception {
		if (param.size() < parametros) {
			throw new Exception("Esperava pelo menos " + parametros + " parametros, encontrei apenas" + param.size() + "\n");
		}
		String result = "";
		for(int i = 0; i < expansao.length(); i++) {
			char c = expansao.charAt(i);
			if (c == '$') {
				i++;
				int t = 0;
				c = expansao.charAt(i);
				for (;i < expansao.length() && isDigit(expansao.charAt(i)); i++) {
					t *= 10;
					t += c - '0'; // Converter para inteiro
				}
				result += param.get(t);
			} else {
				result += c;
			}
		}
		expasions++;
		return result;
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
