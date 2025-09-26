/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author Win 10
 */
public class Final extends Estado_ficha{

    public Final(){
    super(4);
    
    
    }
    @Override
    public void ejecutar() {
        System.out.println("ohhh una ficha ha entrado a la recta final");
    }
    
   
    
}
