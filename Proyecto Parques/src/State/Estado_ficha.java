
package State;


public abstract class Estado_ficha {
    int est;
    
    public Estado_ficha(int est){
        this.est=est;   
    }
    
    public int getEstado(){
    return est;
    
    }
    public abstract void ejecutar();//metodo que muestra el estado 

    
}


