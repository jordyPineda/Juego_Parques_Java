package Prototype;

import State.Estado_ficha;



public class Ficha extends Ficha_abstracta{
    
    public Ficha (int jug,Estado_ficha estado){
        super(jug,estado);
        
    }
    @Override
    public void setEstado(Estado_ficha n){
        
        this.estado=n;
    }
    
    public void Ejecutar(){
        estado.ejecutar();
    }

    public Ficha_abstracta clonar() {
       return new Ficha(this.jug,this.estado);
        
    }
            
}
