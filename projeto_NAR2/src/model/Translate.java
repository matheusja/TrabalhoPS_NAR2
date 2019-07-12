
package model;



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
    private Instruction stru[];
    //construtor onde recebe o arquivo a
    public Translate(String local) {
        str = local;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\n'||str.charAt(i) == ' ') {
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
   private void setSubStrings() {
        subStrins = new String[tm];

        int x = 0;
        for (int i = 0; i < tm; i++) {
            subStrins[i] = "";
        }

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '\n'||str.charAt(j) == ' ') {
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
 private   void serStruct(){
         stru=new Instruction[tm];
         for (int i = 0; i < tm; i++) {
            stru[i]=new Instruction(subStrins[i]);
        }
    }
    public Instruction[] getStruct(){
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
    //Retorna uma string em binario recebendo um inteiro
 public static String decTobin (int num){
     String bin="",aux="";
    
     int valor=num;
     int resto;
     int neg=0;
     int exit=0;
     if(valor<0){
         neg=1;
         valor=valor*(-1);
     }
     do{
         resto=valor%2;
         valor=valor/2;
         aux+=Integer.toString(resto);
         if(valor<2){
             exit=1;
         }
     }while(exit != 1);
     aux+=Integer.toString(valor);
     int tam=0;
     for(int i=0;i<33;i++){
         if((aux.length()+i)==32){
             tam=i;
         }
     }
          
      for(int i=0;i<tam-1;i++){
       
         aux+="0";
          if(neg==1){
             if(i==tam-2){
              bin+="1";
        }
    }else{
              if(i==tam-2){
              bin+="0";
        }   
          }
      }
     for(int i=aux.length()-1;i>-1;i--){
         bin+=aux.charAt(i);
     }
 
     return bin;
 }
 static String decTobin32(int cod) {
    String result = "";
    if (cod < 0) {
        result += "1";
        cod = - cod;
    } else {
        result += "0";
    }
    for(int i = 1 << 30; i != 0; i = i >> 1) {
        if ((cod & i) != 0) {
            result += "1";
        } else {
            result += "0";
        }
    }
    return result;
 }
 static String decTobinN(int cod, int N) {
    String result = "";
    for(int i = 1 << (N - 1); i != 0; i = i >> 1) {
        if ((cod & i) != 0) {
            result += "1";
        } else {
            result += "0";
        }
    }
    return result;
 }
 //Retorna uma instrução em  binario na forma de Instruction recebendo um inteiro
 public static Instruction decToStruct(int num){
     String bin;
     bin=Translate.decTobin32(num);
     Instruction stru= new Instruction (bin);
     return stru;
 }
}
