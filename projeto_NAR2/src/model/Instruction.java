/*
 Class Instruction recebe do tradutor uma string com tamanho 32 bits
e as divide em opcode, indice, flags e parametros
 */
package model;

/**
 *
 * @author Pablo Sanches
 */
public class Instruction {
    private int opcode;
    private int indice;
    private int flags;
    private int parametro;
    private String bin="";
    private boolean P, R, I, N;
    private String parBin;
    private String inBin;
    private String opBin;
    private String flagBin;
    private boolean pBin,rBin,iBin,nBin;
    
    
        public Instruction() {
          P = R = I = N = false;
          indice = 0;
          opcode = 0;
        }
           public  Instruction(String local) {
               bin=local;
               setOpcode();
               setIndice();
               setFlag();
               setPar();
             
               
           }   
        private   void setOpcode(){
               opBin = "";
               for(int i=24;i<32;i++){
                   opBin+= bin.charAt(i);
               }
               opcode=Translate.binToDecUnsigned(opBin);
           }
          private  void setIndice(){
               inBin = "";
               for(int i=20;i<24;i++){
                   inBin+= bin.charAt(i);
               }
               indice=Translate.binToDecUnsigned(inBin);
           }
          private  void setFlag(){
               flagBin = "";
               for(int i=16;i<20;i++){
                   flagBin+= bin.charAt(i);
               }
               flags=Translate.binToDecUnsigned(flagBin);
               P = flagBin.charAt(0) == '1';
               R = flagBin.charAt(1) == '1';
               I = flagBin.charAt(2) == '1';
               N = flagBin.charAt(3) == '1';
               
           }
          public boolean getFlagP() {
              return P;
          }
          public boolean getFlagR() {
              return R;
          }
          public boolean getFlagI() {
              return I;
          }
          public boolean getFlagN() {
              return N;
          }
          private    void setPar(){
               parBin="";
               for(int i=0;i<16;i++){
                   parBin+= bin.charAt(i);
               }
               parametro=Translate.binToDecSigned(parBin);
           }
          //set os paraetros par atraves de um inteiro
          public void setParBin(int n) {
              parBin=Translate.decTobinN(n, 16);
          }
          //set os opcode par atraves de um inteiro
          public void setOpBin(int n) {
              opBin=Translate.decTobinN(n, 8);
          }
          //set os indice par atraves de um inteiro
          public void setInBin(int n) {
              inBin=Translate.decTobinN(n, 4);
          }
          //set a flag par atraves de um inteiro
          public void setFlagBin(int n) {
              flagBin=Translate.decTobinN(n, 4);
          }
              public int getOpDec (){
                 
                  return opcode;
              }
              public String getOpBin (){
                  
                  return opBin;
              }
              public int getIndDec (){
                  
                  return indice;
              }
              public String getIndBin (){
                  
                  return inBin;
              }
              public int getFlagDec (){
                  
                  return flags;
              }
              public String getFlagBin (){
                  
                  return flagBin;
              }
              public int getPaDec (){
                  
                  return parametro;
              }
              public String getPaBin (){
                  
                  return parBin;
              }
              public boolean getisJump() {
                  
                  return opcode >= 19 && opcode <= 21;
              }
              
               public String getFlagBinEntrada (){
                  
                  return flagBin;
              }
              public String getOpBinEntrada  (){
                  
                  return opBin;
              }
              public String getInBinEntrada (){
                  
                  return inBin;
              }
              public String getPaBinEntrada (){
                  
                  return parBin;
              }
              //retorna uma instrução
               public String getInstructionString (){
                  String inst;
                  inst=parBin;
                  inst=inst+flagBin;
                  inst=inst+inBin;
                  inst=inst+opBin;
                  
                  return inst;
              }
}

