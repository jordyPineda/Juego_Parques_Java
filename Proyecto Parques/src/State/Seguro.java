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
public class Seguro extends Estado_ficha{

    public Seguro(){
    super(3);
    
    
    }
    @Override
    public void ejecutar() {
        System.out.println("ohhh una ficha esta protegida");
    }
    
}
