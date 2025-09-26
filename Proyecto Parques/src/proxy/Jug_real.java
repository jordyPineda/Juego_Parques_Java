/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import Prototype.Ficha;
import Prototype.Ficha_abstracta;
import State.Encarcelada;
import State.Estado_ficha;
import javax.swing.JOptionPane;


public class Jug_real extends Jug_abstracto {
    
    private Ficha_abstracta ficha1;
    private Ficha_abstracta ficha2;
    private Ficha_abstracta ficha3;
    private Ficha_abstracta ficha4;
    private int ult1,ult2;
    
    
    
    public Jug_real(String nom,int jug){
     
        super(nom,jug);
        asignarF();
    }

    @Override
    public boolean jugar(int a,String res) {
        boolean pudo;
         switch(res) 
        { 
            case "1": 
                System.out.println("Escogio la ficha 1");
                pudo=Mover(ficha1,a);
                break; 
            case "2": 
                System.out.println("Escogio la ficha 2"); 
                pudo=Mover(ficha2,a);
                break; 
            case "3": 
                System.out.println("Escogio la ficha 3");
                pudo=Mover(ficha3,a);
                break;
            default:
                System.out.println("Escogio la ficha 4"); 
                pudo=Mover(ficha4,a);
                break; 
        } 
        return pudo;
    }
    
    
    
    
    private void asignarF(){
        Estado_ficha estado = new Encarcelada();
        ficha1 =new Ficha(this.getNum(),estado);
        ficha2 =ficha1.clonar();        
        ficha3 =ficha1.clonar();        
        ficha4 =ficha1.clonar();
    }
    
    public int getUlt1(){
    return ult1;
    
    }
    public int getUlt2(){
    return ult2;
    
    }
    
    public void setUlt(){
        switch(getNum()) 
        { 
            case 1:              
                this.ult1=5;
                this.ult2=5;
                break;
            case 2: 
                this.ult1=22;
                this.ult2=22;
                break;
            case 3: 
                this.ult1=39;
                this.ult2=39;
                break;
            case 4: 
                this.ult1=56;
                this.ult2=56;
                break;
            default: 
                System.out.println("no es un numero valido"); 
                
        } 
    
    }
    
    
    
    
    public int getPos(int a){
        
        switch(a) 
        { 
            case 1: 
                return ficha1.getPos();                
                
            case 2: 
                return ficha2.getPos(); 
                
                
            case 3: 
                return ficha3.getPos(); 
                
            case 4: 
                return ficha4.getPos(); 
                             
            default: 
                System.out.println("no es un numero valido"); 
                return -1;
        } 
        
       
    
    }
    
    public int getEst(int a){
        
        switch(a) 
        { 
            case 1: 
                return ficha1.getEstado();
                
            case 2: 
                return ficha2.getEstado();
                
                
            case 3: 
                return ficha3.getEstado();
                
            case 4: 
                return ficha4.getEstado();
                             
            default: 
                System.out.println("no es un numero valido"); 
                return -1;
        } 
        
       
    
    }
    
    public void setPos(int a,int b){
        
        switch(a) 
        { 
            case 1: 
                ficha1.setPos(b);                
                break;
            case 2: 
                ficha2.setPos(b);
                break;
                
            case 3: 
               ficha3.setPos(b);
                break;
            case 4: 
                ficha4.setPos(b);
                  break;           
            default: System.out.println("no es un numero valido (setPos(a,b))"); 
                
        } 
        
       
    
    }
    public void setPos(int a,int b,int c){
        
        switch(c) 
        { 
            case 1: 
                setPos(a,5); 
                break;
                
            case 2:
                setPos(a,22);
                break;
                
            case 3: 
               setPos(a,39);
                break;
            case 4: 
                setPos(a,56);
                 break;            
            default: 
                System.out.println("no es un numero valido (setPos(a,b,c))"); 
                
        } 
        
       
    
    }
    
    public void setEst(int a,Estado_ficha b){
        
        switch(a) 
        { 
            case 1: 
                ficha1.setEstado(b);
                break;
            case 2: 
                ficha2.setEstado(b);
                break;
                
            case 3: 
              ficha3.setEstado(b);
                break;
            case 4: 
                ficha4.setEstado(b);
                  break;           
            default: 
                System.out.println("no es un numero valido(setEstado)"); 
                
        } 
        
       
    
    }
    
    
    
    private boolean Mover(Ficha_abstracta ficha1,int a){
        
        if (ficha1.getEstado()== 1){
                    System.out.println("Esta ficha esta en la carcel madure"); 
                    JOptionPane.showMessageDialog(null, "Esta ficha esta en la carcel madure");
                    return false;
                } else if(ficha1.getEstado()== 5){
                    JOptionPane.showMessageDialog(null, "Esta ficha esta fuera del juego madure");
                    System.out.println("Esta ficha esta fuera del juego madure"); 
                    return false;
                }else{     
                    
                    if(ficha1.getEstado()== 4){
                        System.out.println("Esta ficha ya esta en la recta final, el numero debe ser preciso o se devolvera la ficha");
                        

                            System.out.println("pos inicial:" + ficha1.getPos()); 
                            ficha1.actPosF(a);
                            System.out.println("pos final:" + ficha1.getPos()); 
                            a=0;
                            ult1 =ficha1.getPos();
                
                    }else{


                            System.out.println("pos inicial:" + ficha1.getPos()); 
                            ficha1.actPos(a);
                            System.out.println("pos final:" + ficha1.getPos()); 
                            a=0;
                            ult1 =ficha1.getPos();
                        
                }
                    return true;
        }
    }

    @Override
    public int getNumP() {
        return this.getNum();
    }

    @Override
    public void setSujeto(Jug_real jug_1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
    

    
    
    
    
}
