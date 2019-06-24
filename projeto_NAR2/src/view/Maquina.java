package view;

import java.util.ArrayList;

public class Maquina{
    private ArrayList<Integer> mem, regs;
    private int pc, acc;
    private boolean running = true;
      
    
    private void doInstruction(Struct s){
        int data = addressingMode(s);
        switch (s.getOpDec()){
            //MUA - loads the value into accumulator
            case 1:
                acc = data;
            break;
            //AUM - stores the content of the accumulator
            case 2:
                mem.set(data, acc);
            break;
            //PIR - Loads the value into the index register
            case 3:
                regs.set(s.getIndDec(), data);
            break;
            //SABF - adds parameter to the accumulator
            case 4:
                acc = acc + data;
            break;
            //ODUF - subtracts the parameter from the accumulator
            case 5:
                acc = acc - data;
            break;
            //MNOF - Multiples the accumulator with the parameter
            case 6:
                acc = acc * data;
            break;
            //DELF  - Divides the accumulator by the parameter
            case 7:
                acc = acc / data;
            break;
            //PZAF  - Changes (flips) the sign of the accumulator
            case 8:
                acc = - acc;
            break;
            //KON - performs logical AND with the parameter and the accumulator and stores the result in the accumulator
            case 9:
                acc = acc & data;
            break;  
            //DIS  - performs logical OR with the parameter and the accumulator and stores the result in the accumulator
            case 10:
                acc = acc | data;
            break;
            //NEG  - performs logical NOT on the content of the accumulator (ignores the parameter)
            case 11:
                acc = ~acc;
            break;
            //POL  - shifts the bits of the accumulator to the left
            case 12:
                acc = acc<<data;
            break;
            //POD  - shifts the bits of the accumulator to the right
            case 13:
                acc = acc>>data;
            break;
            //NES - performs a conditional jump to the address specified by the parameter if the current value of the accumulator is negative
            case 14:
                if(acc < 0){
                    //lembrando que ao sair dessa função será feito pc= pc+1
                    pc = data-1;
                }
            break;
            //BES - performs an unconditional jump to the address specified by the parameter
            case 15:
                pc = data-1;
            break;
            //NUS - performs a conditional jump to the address specified by the parameter if the current value of the accumulator is zero
            case 16:
                if(acc == 0){
                    pc = data -1;
                }
            break;    
            //ZAR -  stops any further processing; this is the only instruction that ignores the parameter
            case 0:      
                running = false;
            break;  
        }        
    }
    
    private int addressingMode(Struct s){
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
        doInstruction(Translate.decToStruct(mem.get(pc)));
        pc = pc+1;
    }
    
    public void run() {
        running = true;
        while (running) {
            step();
            /* Talvez algum código auxiliar*/
        }
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