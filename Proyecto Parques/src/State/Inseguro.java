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
public class Inseguro extends Estado_ficha{

    public Inseguro(){
    super(2);
    
    
    }
    @Override
    public void ejecutar() {
        System.out.println("ohhh una ficha esta expuesta a ser comida");
    }
    
}
