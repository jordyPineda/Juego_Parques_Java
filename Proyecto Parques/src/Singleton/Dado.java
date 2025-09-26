
package Singleton;

/**
 *
 * @author jorge malaver
 */
public class  Dado {
    
    private static Dado inst;
    private int valor;
    private int valor2;
   private Dado(){
        
    }    
   public static Dado getDado(){
       if(inst==null){
           inst= new Dado();
   }
       return inst;
}
   
   public void lanzar() {
       
       int n=6;
   this.valor = (int) (Math.random() * n) + 1;
   this.valor2 = (int) (Math.random() * n) + 1;
        
   }
   
   public int getvalor(){
       return valor;
   }
   public int getvalor2(){
       return valor2;
   }
   
}
