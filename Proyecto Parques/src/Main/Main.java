/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Ventanas.Inicio;
import Ventanas.Ventana;
/**
 *
 * @author jorge malaver
 */
// El cliente (clase real) del sujeto solo conoce que maneja un objeto de la clase
// Persona. Por  lo tanto funciona indistintamente con la con la personareal

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Inicio ven= new Inicio();
        ven.setVisible(true);
        
        
        
    }
    
}
