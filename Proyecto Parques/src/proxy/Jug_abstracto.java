
package proxy;

import State.Estado_ficha;




public abstract class Jug_abstracto {
    private String Nombre;
    private int jug;
    
    
    public Jug_abstracto(String nom,int jug){//guarda el nombre del jug_1
    Nombre=nom;// trabaja lo mismo con el jug_1 real como con el proxy
    this.jug=jug;
}
    // devuelve el nombre del jug_1
    @Override
    public String toString(){
        return Nombre;
    }
    // metodos que se implementan en las clases que heredan 
    public abstract boolean jugar(int a,String res);
    
    public int getNum(){
    return jug;
    }
    
    public abstract int getNumP();
    
    public abstract int getUlt1();
    public abstract void setUlt();
    
    public abstract int getUlt2();
    public abstract int getPos(int a);
    public abstract int getEst(int a);
     public abstract void setPos(int a,int b);
    public abstract void setEst(int a,Estado_ficha b);

    public abstract void setSujeto(Jug_real jug_1);

    
}
