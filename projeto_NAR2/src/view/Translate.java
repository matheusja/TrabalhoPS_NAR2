
/*
Classe recebe uma string com o local onde o arquivo fonte esta
para começar a execução
Retorna um vetor de inteiros convertidos para dec
Chama a classe struct
 */
package tanslate;



/**
 *
 * @author Pablo Sanches
 */
public class Translate {

    //String onde vai ser armazenada o arquivo
    private String str = "";
    //tamanho de linhas do arquivo
    private int tm = 1;
    //vetor de sub Strings Geradas para tradução
    private String subStrins[];
    //vator de inteiros
    private int decString[];
 //estruturas divididas
    private Struct stru[];
    //construtor onde recebe o arquivo a
    public Translate(String local) {
        str = local;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\n') {
                tm++;

            }

        }
            setSubStrings();
    }

    public static int binToDecUnsigned(String bin) {
        double dec = 0;
        int tam = 0;
        for (int i = bin.length() - 1; i > -1; i--) {

            if (bin.charAt(i) == '1') {
                dec = dec + (Math.pow(2, tam));
            }
            tam++;
        }

        return (int) dec;
    }

    //converte de binario para dec
    public static int binToDecSigned(String bin) {
        int unsigned = binToDecUnsigned(bin.substring(1));
        if (bin.charAt(0) == '1') {
            return -(int) unsigned;
        }
        return (int) unsigned;

    }

    //gera as subs string e as estruturas
    void setSubStrings() {
        subStrins = new String[tm];
       
        int x = 0;
        for (int i = 0; i < tm; i++) {
            subStrins[i] = "";
        }

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '\n') {
                x++;
            } else {
                subStrins[x] += str.charAt(j);
            }
        }
       
    }

    //retorna os valores em dec
    public int[] convertReturn() {
        
        decString = new int[tm];
        for (int i = 0; i < tm; i++) {
            decString[i] = binToDecSigned(subStrins[i]);
        }
        return decString;
    }
    void serStruct(){
         stru=new Struct[tm];
         for (int i = 0; i < tm; i++) {
            stru[i]=new Struct(subStrins[i]);
        }
    }
    public Struct[] getStruct(){
        serStruct();
        return stru;
    }
    
    //Retorna uma string ao inves de um vetor de inteiros
 public String retunrStringConv(){
     String convertString="";
      decString = new int[tm];
        for (int i = 0; i < tm; i++) {
            decString[i] = binToDecSigned(subStrins[i]);
        }
      for(int i=0;i<decString.length;i++){
            convertString+=decString[i];
            convertString+="\n";
        }
     return convertString;
 }
}
