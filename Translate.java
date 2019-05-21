/*
Classe recebe uma string com o local onde o arquivo fonte esta
para começar a execução
Retorna um vetor de inteiros convertidos para dec

 */
package tanslate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Translate {
    //String onde vai ser armazenada o arquivo
    private String str="";
    //tamanho de linhas do arquivo
    private int tm=0;
    //vetor de sub Strings Geradas para tradução
    private String subStrins[];
    //Arquivo carregado
    private BufferedReader br;
    //vator de inteiros
    private int decString[];
    
 
    //construtor onde recebe o arquivo a
    public Translate( String local){
        String line;
        //abre o arquivo
        try{
              br = new BufferedReader(new FileReader(local));
             while(br.ready()) {
                line = br.readLine();
                //concatena as linhas
                str= str+line+'\n';
                tm++;


             }
             br.close();
        }catch(IOException ioe){
             ioe.printStackTrace();
        }
    }
    //converte de binario para (inteiro)
    public int binTodec(String bin ) {
        int val=0;
        for(int i=31;i>-1;i--) {
            if(bin.charAt(i) == '1') {
                dec += 1;
            }
            val *= 2;
       }
       return val;
    }
    //gera as subs string
    void    setSubStrings( ) {
        subStrins=new String[tm];
        int x=0; 
        for(int i=0;i<tm;i++){
            subStrins[i]="";
        }
        for(int j =0;j<str.length();j++){
            subStrins[x]+= str.charAt(j);
            if(str.charAt(j)=='\n'){
                x++;
            }
         }
       for(int i=0;i<tm;i++){

       }
   } 
    //retorna os valores em dec
    public int[] convertReturn() {
        decString= new int [tm];
        for(int i=0;i<tm;i++) {
            decString[i]= binTodec(subStrins[i]);
        }
        return decString;
    }
}

