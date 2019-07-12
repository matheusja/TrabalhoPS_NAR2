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
    private String op="";
    private int indice;
    private String in="";
    private int flags;
    private String fla="";
    private int parametro;
    private String pa="";
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
               P = fla.charAt(0) == '1';
               R = fla.charAt(1) == '1';
               I = fla.charAt(2) == '1';
               N = fla.charAt(3) == '1';
               
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
              
               for(int i=16;i<32;i++){
                   pa+= bin.charAt(i);
               }
               parametro=Translate.binToDecSigned(pa);
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
              public boolean getisJump() {
                  return false; // Implementar
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
                  String inst="";
                  inst=parBin;
                  inst=inst+flagBin;
                  inst=inst+inBin;
                  inst=inst+opBin;
                  
                  return inst;
              }
}

