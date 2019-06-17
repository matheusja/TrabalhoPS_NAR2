/*
 Class Struct recebe do tradutor uma string com tamanho 32 bits
e as divide em opcode, indice, flags e parametros
 */
package view;

/**
 *
 * @author Pablo Sanches
 */
public class Struct {
    private int opcode;
    private String op="";
    private int indice;
    private String in="";
    private int flags;
    private String fla="";
    private int parametro;
    private String pa="";
    private String bin="";
           public  Struct(String local) {
               bin=local;
               setOpcode();
               setIndice();
               setFlag();
               setPar();
             
               
           }   
        private   void setOpcode(){
               
               for(int i=0;i<8;i++){
                   op+= bin.charAt(i);
               }
               opcode=Translate.binToDecUnsigned(op);
           }
          private  void setIndice(){
               
               for(int i=8;i<12;i++){
                   in+= bin.charAt(i);
               }
               indice=Translate.binToDecUnsigned(in);
           }
          private  void setFlag(){
            
               for(int i=12;i<16;i++){
                   fla+= bin.charAt(i);
               }
               flags=Translate.binToDecUnsigned(fla);
           }
          private    void setPar(){
              
               for(int i=16;i<32;i++){
                   pa+= bin.charAt(i);
               }
               parametro=Translate.binToDecSigned(pa);
           }
              public int getOpDec (){
                 
                  return opcode;
              }
              public String getOpBin (){
                  
                  return op;
              }
              public int getIndDec (){
                  
                  return indice;
              }
              public String getIndBin (){
                  
                  return in;
              }
              public int getFlagDec (){
                  
                  return flags;
              }
              public String getFlagBin (){
                  
                  return fla;
              }
              public int getPaDec (){
                  
                  return parametro;
              }
              public String getPaBin (){
                  
                  return pa;
              }
}

