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
public class Fuera extends Estado_ficha{

    public Fuera(){
    super(5);
    
    
    }
    @Override
    public void ejecutar() {
        System.out.println("ohhh una ficha ha sido coronada");
    }
    
}
