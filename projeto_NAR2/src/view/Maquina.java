package view;

import java.util.ArrayList;

public class Maquina{
    private ArrayList<Integer> mem, regs;
    private int pc, acc;
      
    
    public void addressing(Struct s){
        int data;
        switch (s.getOpDec()){
            //MUA - loads the value into accumulator
            case 1:
                acc = s.getPaDec();
            break;
            //AUM - stores the content of the accumulator
            case 2:
                
            break;
            //PIR - Loads the value into the index register
            case 3:
                
            break;
            //SABF - adds parameter to the accumulator
            case 4:
                acc = acc + s.getPaDec();
            break;
            //ODUF - subtracts the parameter from the accumulator
            case 5:
                acc = acc - s.getPaDec();
            break;
            //MNOF - Multiples the accumulator with the parameter
            case 6:
                acc = acc * s.getPaDec();
            break;
            //DELF  - Divides the accumulator by the parameter
            case 7:
                acc = acc / s.getPaDec();
            break;
            //PZAF  - Changes (flips) the sign of the accumulator
            case 8:
                acc = - acc;
            break;
            //KON - performs logical AND with the parameter and the accumulator and stores the result in the accumulator
            case 9:
            break;  
            //DIS  - performs logical OR with the parameter and the accumulator and stores the result in the accumulator
            case 10:
            break;
            //NEG  - performs logical NOT on the content of the accumulator (ignores the parameter)
            case 11:
            break;
            //POL  - shifts the bits of the accumulator to the left
            case 12:
            break;
            //POD  - shifts the bits of the accumulator to the right
            case 13:
            break;
            //NES - performs a conditional jump to the address specified by the parameter if the current value of the accumulator is negative
            case 14:
            break;
            //BES - performs an unconditional jump to the address specified by the parameter
            case 15:
            break;
            //NUS - performs a conditional jump to the address specified by the parameter if the current value of the accumulator is zero
            case 16:
            break;    
            //ZAR -  stops any further processing; this is the only instruction that ignores the parameter
            case 0:
            break;  
        }        
    }
    
    private int addressingMode(int data, Struct s){
          boolean P = s.getFlagP(), 
                  R = s.getFlagR(), 
                  N = s.getFlagN(),
                  jump = s.getisJump();
          int value = s.getPaDec();
          if (P) {
              value += regs.get(s.getIndDec());
          }
          if (R) {
              value += pc;
          }
          if (!N && !jump) {
              value = mem.get(value);
          }
          return value;
    }
    
    public void step(){
        
        pc = pc+1;
    }

    public ArrayList<Integer> getMem() {
        return mem;
    }

    public void setMem(ArrayList<Integer> mem) {
        this.mem = mem;
    }

    public ArrayList<Integer> getRegs() {
        return regs;
    }

    public void setRegs(ArrayList<Integer> regs) {
        this.regs = regs;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }   
}