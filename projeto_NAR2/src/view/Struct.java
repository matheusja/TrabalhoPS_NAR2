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
    private int indice;
    private int flags;
    private int parametro;
    private String in="";
    private String fla="";
    private bool   flag_N;
    private bool   flag_I; // Nao implementar
    private bool   flag_R;
    private bool   flag_P;
    private String op="";
    private String pa="";
    private String bin="";
    public  Struct(String local) {
        bin=local;
        setOpcode();
        setIndice();
        setFlag();
        setPar();
    }   
    private   void setOpcode() {
        for(int i = 24;i < 32;i++) {
            op += bin.charAt(i);
        }
        opcode = Translate.binToDecUnsigned(op);
    }
    private  void setIndice(){
         for(int i = 20;i < 24;i++) {
             in += bin.charAt(i);
         }
         indice = Translate.binToDecUnsigned(in);
    }
    private  void setFlag() {
         for(int i = 16;i < 20;i++) {
             fla += bin.charAt(i);
         }
         flag_N = fla.charAt(0) == '1';
         flag_I = fla.charAt(1) == '1';
         flag_R = fla.charAt(2) == '1';
         flag_P = fla.charAt(3) == '1';
    }
    private void setPar() {
         for(int i = 0;i < 16;i++){
             pa += bin.charAt(i);
         }
         parametro = Translate.binToDecSigned(pa);
     }
     public int getOpDec() {
         return opcode;
     }
     public String getOpBin() {
         return op;
     }
     public int getIndDec() {
         return indice;
     }
     public String getIndBin() {
         return in;
     }
     public int getFlagDec() {
         return flags;
     }
     public String getFlagBin() {
         return fla;
     }
     public int getPaDec() {
         return parametro;
     }
     public String getPaBin() {
         return pa;
     }
}

