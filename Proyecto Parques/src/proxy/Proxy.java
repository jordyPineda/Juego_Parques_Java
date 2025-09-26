/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import State.Estado_ficha;

/**
 *
 * @author jorge malaver
 */

//el objeto proxy que es simultaneamente:
// proxy virtual que retrasa la creacion del objeto hasta la invocacion de alguno
//de los metodos.
//Referencia inteligente, raliza un conteo de las veces que de incova el metodo
public class Proxy extends Jug_abstracto{
    
    private Jug_real persoreal;
    private int turnos1 , turnos2, turnos3,turnos4;
    
    public Proxy(String nom,int jug){
        
        super(nom,jug);//inicia la superclase
        turnos1=0;
        turnos2=0;
        turnos3=0;
        turnos4=0;
    }
    //Evita la comprobacion de la existancia del jug_1 real
    private Jug_real obtenersujeto(){
        
        return persoreal;
    }
    
    @Override
    public int getUlt1(){
    return persoreal.getUlt1();
    
    }
    
    @Override
    public int getNumP(){
    return persoreal.getNum();
    
    }
    
    @Override
    public int getUlt2(){
    return persoreal.getUlt2();
    
    }
    
    public void setSujeto(Jug_real jug){
        
        
        this.persoreal=jug;
         
        
    }
    
    
    
    @Override
    public boolean jugar(int a, String b) {
        int c = getNumP();
        boolean pudo;
        switch (c) {
            case 1:
                turnos1++;
                pudo = obtenersujeto().jugar(a, b);
                break;
            case 2:
                turnos2++;
                pudo=obtenersujeto().jugar(a, b);
                break;
            case 3:
                turnos3++;
                pudo=obtenersujeto().jugar(a, b);
                break;
            case 4:
                turnos4++;
                pudo=obtenersujeto().jugar(a, b);
                break;
            default:
                pudo=false;
        }
        return pudo;

    }
    
    
    
    @Override
    public String toString(){ 
        
        return "";
    }

    @Override
    public int getPos(int a) {
        return a;
    }

    @Override
    public int getEst(int a) {
        return a;
    }

    @Override
    public void setPos(int a, int b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void setEst(int a, Estado_ficha b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUlt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

  
    
}//fin clase Proxy
