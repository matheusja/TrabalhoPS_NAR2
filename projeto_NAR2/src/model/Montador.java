/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author andrezdc
 */
public class Montador 
{
    
    public static final String SPACE_DECL = "SPACE";
    public static final String CONST_DECL = "CONST";
    
    
    final private String code;
    private int index;
    HashMap<String, Integer> instructions;
    HashMap<String, Integer> flags;
    HashMap<String, Integer> registers;
    
    final private CodigoMontado codigoMontado;
    
    
    public Montador(String code) {
        this.code = code;
        this.index = 0;
        codigoMontado = new CodigoMontado();
        instructions = loadInstructions();//new HashMap<String, Integer>();
        flags = loadFlags();
        registers = loadRegistersIndexes();
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
        // Levantar erro para label vazio   
        // <nada>:
        String lastToken = null;
        int pc = 0;
        while(index < code.length())
        {
            String currentToken = nextToken();
            Integer instruction = instructions.get(currentToken);
            if (instruction != null) {
                // Eh uma instrucao
                // Os proximos tokens sao os argumentos
                
                // Incrementar PC
                pc++;
            } else if (SPACE_DECL.equals(currentToken)) {
                // Proximo token é o número de espaços a serem reservados
                // Observe que esse valor não é uma instrução
                int space_size = Integer.parseInt(nextToken());
                // Observe também que aqui o pc pode aumentar N, sendo N o tamanho reservado
                pc += space_size;
            } else if (CONST_DECL.equals(currentToken)) {
                // Proximo token é o valor que esse espaço vai ocupar
                // Observe que esse valor não é um
                pc += 1;
            } else if (currentToken.equals(":")) {
                //pc--;
                if (lastToken == null) {
                    throw new Exception("Simbolo sem nome");
                }
                if (codigoMontado.tabelaDeSimbolos.containsKey(lastToken)) {
                    throw new Exception("Simbolo duplamente definido");
                } else {
                    codigoMontado.tabelaDeSimbolos.put(lastToken, pc);
                }
            } else {
                lastToken = currentToken;
            }
        }
        
    }
    
    private String nextToken() {
        ignorarEspacos();
        if (index >= code.length()) {
            return ""; // essencialmente EOF
        }
        String str = "";
        char c = code.charAt(index);
        if (c == ':') {
            return ":";
        }
        while (index < code.length() && !ignoravel(c)) {
            if (c == ':') {
                return str;
            }
            str += c;
            index++;
            c = code.charAt(index);
        }
        
        return str; 
    }
    
    private void ignorarEspacos() {
        char c = code.charAt(index);
        while (index < code.length() && ignoravel(c)) {
            index++;
            if (c == '#') {
                // Comment
                while(index < code.length() && c != '\n') {
                    index++;
                } 
            }
        }
    }
    
    private boolean ignoravel(char c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '#';
    }
    
    
    private void passo2() throws Exception {
        // Levantar erro para simbolo n/ definido que nao eh externo
        
        
        String lastToken = null;
        int pc = 0;
        
        int instructionInt;
                
        while(index < code.length())
        {
            String currentToken = nextToken();
            
            
            if(instructions.get(currentToken) != null)
            {
                Instruction inst = new Instruction();
                inst.setOpBin(instructions.get(currentToken));
                currentToken = nextToken();
                if ( flags.get( currentToken ) != null )
                {
                    inst.setFlagBin(flags.get(currentToken));
                    currentToken = nextToken();
                }
                else
                {
                    inst.setFlagBin(0);
                }
                if (inst.getFlagP()) // Flag P requer um registrador
                {
                    if (registers.get(currentToken) != null)
                    {
                        inst.setInBin(registers.get(currentToken));
                    }
                    else
                    {
                        throw new Exception("Erro: Esperava um registrador\n");
                    }
                }
                currentToken = nextToken();
                if (inst.getFlagN()) {
                    String token = nextToken();
                    try {
                        inst.setParBin(Integer.parseInt(token));
                    } catch(NumberFormatException //<editor-fold defaultstate="collapsed" desc="comment">
                            nfe
//</editor-fold>
) {
                        throw new Exception("Numero invalido " + token);
                    }
                } else {
                    if (codigoMontado.tabelaDeSimbolos.containsKey(currentToken)) {
                        inst.setParBin(codigoMontado.tabelaDeSimbolos.get(currentToken));
                    } else  {
                        if (!codigoMontado.tabelaDeUsos.containsKey(currentToken)) {
                            codigoMontado.tabelaDeUsos.put(currentToken, new ArrayList<>() );
                        }
                        codigoMontado.tabelaDeUsos.get(currentToken).add(codigoMontado.codigo.size());
                        inst.setParBin(0);
                    }
                    codigoMontado.codigo.add(Translate.binToDecSigned(inst.getInstructionString()));
                    // Eh imediato se:
                    //1. eh um valor imediato(dã)
                    //2. eh um valor que eh somado a PC
                    codigoMontado.relativo.add(!inst.getFlagN() && !inst.getFlagR());
                }
            }
            else if (SPACE_DECL.equals(currentToken))
            {
                int N;
                String token = nextToken();
                try {
                    N = Integer.parseInt(token);
                }
                catch(NumberFormatException e) {
                    throw new Exception("Numero invalido " + token);
                }
                for(int i = 0; i < N; i++) {
                    codigoMontado.codigo.add(0);
                }
            }
            else if (CONST_DECL.equals(currentToken)) 
            {
                codigoMontado.codigo.add(Integer.parseInt(nextToken()));
            }
        }
        
        
    }
    
    public static CodigoMontado montar(String code) throws Exception {
        Montador mn = new Montador(code);
        return mn.montarInterno();
    }
    
    
    private HashMap loadInstructions()
    {
        HashMap<String, Integer> inst = new HashMap<>();
        
        int i = 0;
        
        inst.put("ZAR",i++);
        inst.put("MUA",i++);
        inst.put("AUM",i++);
        inst.put("PIR",i++);
        inst.put("SABF",i++);
        inst.put("ODUF",i++);
        inst.put("MNOF",i++);
        inst.put("DELF",i++);
        inst.put("PZAF",i++);
        inst.put("SAB",i++);
        inst.put("ODU",i++);
        inst.put("MNO",i++);
        inst.put("DEL",i++);
        inst.put("PZA",i++);
        inst.put("KON",i++);
        inst.put("DIS",i++);
        inst.put("NEG",i++);
        inst.put("POL",i++);
        inst.put("POD",i++);
        inst.put("NES",i++);
        inst.put("BES",i++);
        inst.put("NUS",i++);
                                
                
        return inst;
    }
    
    private HashMap loadFlags()
    {
        HashMap<String, Integer> flags = new HashMap<>();
        int i = 1;
        
        flags.put( "N", i++ );
        flags.put( "I", i++ );
        flags.put( "IN", i++ );
        flags.put( "R", i++ );
        flags.put( "RN", i++ );
        flags.put( "RI", i++ );
        flags.put( "RIN", i++ );
        flags.put( "P", i++ );
        flags.put( "PN", i++ );
        flags.put( "PI", i++ );
        flags.put( "PIN", i++ );
        flags.put( "PR", i++ );
        flags.put( "PRN", i++ );
        flags.put( "PRI", i++ );
        flags.put( "PRIN", i++ );
        return flags;
    }
    
    private HashMap loadRegistersIndexes()
    {
        HashMap< String, Integer > regsIndex = new HashMap<>();
        
        for( int i = 0; i < 16; i++ )
        {
            regsIndex.put( "X"+i, i);
        }
        return regsIndex;
    }    
}
