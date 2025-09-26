/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Prototype.Ficha_abstracta;
import Ventanas.Ventana;
import proxy.Jug_abstracto;
import proxy.Jug_real;
import proxy.Proxy;
import Singleton.Dado;
import State.Encarcelada;
import State.Estado_ficha;
import State.Fuera;
import State.Inseguro;
import State.Seguro;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javax.swing.JOptionPane;

/**
 *
 * @author Win 10
 */
public class Controlador {

    Dado dado1, dado2;
    Jug_abstracto proxy, jug_1, jug_2, jug_3, jug_4,jug_aux;
    int[] pos;
    int[] est;
    private Ventana tablero;
    private boolean salio;
    private String jugadores;

    public Controlador(Ventana frame, String j) {

        jugadores=j;
        tablero = frame;
        //Dados------------------- 
        dado1 = Dado.getDado();
        dado2 = Dado.getDado();

        //-----------------------------------
        //Proxy y jugadores
        proxy = new Proxy("proxy", 0);
        jug_1 = new Jug_real("jug_1", 1);
        jug_2 = new Jug_real("jug_2", 2);
        jug_3 = new Jug_real("jug_3", 3);
        jug_4 = new Jug_real("jug_4", 4);
        jug_aux = jug_1;
        //Arreglo posicion y arreglo estado
        pos = new int[16];
        est = new int[16];

    }

    private void llenar() {

        pos[0] = jug_1.getPos(1);
        pos[1] = jug_1.getPos(2);
        pos[2] = jug_1.getPos(3);
        pos[3] = jug_1.getPos(4);
        pos[4] = jug_2.getPos(1);
        pos[5] = jug_2.getPos(2);
        pos[6] = jug_2.getPos(3);
        pos[7] = jug_2.getPos(4);
        pos[8] = jug_3.getPos(1);
        pos[9] = jug_3.getPos(2);
        pos[10] = jug_3.getPos(3);
        pos[11] = jug_3.getPos(4);
        pos[12] = jug_4.getPos(1);
        pos[13] = jug_4.getPos(2);
        pos[14] = jug_4.getPos(3);
        pos[15] = jug_4.getPos(4);

        est[0] = jug_1.getEst(1);
        est[1] = jug_1.getEst(2);
        est[2] = jug_1.getEst(3);
        est[3] = jug_1.getEst(4);
        est[4] = jug_2.getEst(1);
        est[5] = jug_2.getEst(2);
        est[6] = jug_2.getEst(3);
        est[7] = jug_2.getEst(4);
        est[8] = jug_3.getEst(1);
        est[9] = jug_3.getEst(2);
        est[10] = jug_3.getEst(3);
        est[11] = jug_3.getEst(4);
        est[12] = jug_4.getEst(1);
        est[13] = jug_4.getEst(2);
        est[14] = jug_4.getEst(3);
        est[15] = jug_4.getEst(4);

    }

    public boolean jugar(Jug_abstracto jug) {

        int ronda = 1;
        boolean fin = true, doble;

        tablero.setTurno(jug.getNum());
        System.out.println("repintando");
        doble = Jugar(jug);
        fin = VerFin(jug);
        
        if (fin  == false) { //Funcion que verifica que todas las fichas de el jugador ingresado 
            tablero.ganar();
        }
        
        
        switch (jugadores){
            case "1":
                
                if (jug == jug_1 && !doble) {
                jug_aux = jug_1;
                }
                
                break;
            case "2":
                
                if (jug == jug_1 && !doble) {
                    jug_aux = jug_2;
                } else if (jug == jug_2 && !doble) {
                    jug_aux = jug_1;
                }
                break;
                
            case "3":
                
                if (jug == jug_1 && !doble) {
                    jug_aux = jug_2;
                } else if (jug == jug_2 && !doble) {
                    jug_aux = jug_3;
                } else if (jug == jug_3 && !doble) {
                       jug_aux = jug_1;
                }
                
                
                break;
            case "4":
                if (jug == jug_1 && !doble) {
                    jug_aux = jug_2;
                } else if (jug == jug_2 && !doble) {
                    jug_aux = jug_3;
                } else if (jug == jug_3 && !doble) {
                     jug_aux = jug_4;
               } else if (jug==jug_4 && !doble){
                     jug_aux = jug_1;
                 }
                break;
                
            default:
                
                if (jug == jug_1 && !doble) {
                    jug_aux = jug_2;
                } else if (jug == jug_2 && !doble) {
                    jug_aux = jug_3;
                } else if (jug == jug_3 && !doble) {
                     jug_aux = jug_4;
               } else if (jug==jug_4 && !doble){
                     jug_aux = jug_1;
                 }
                break;
        }
 //       if (jug == jug_1 && !doble) {
 //           jug_aux = jug_1;
  //      } else if (jug == jug_2 && !doble) {
   ///         jug_aux = jug_1;
//        } else if (jug == jug_3 && !doble) {
//            jug_aux = jug_4;
//        } else if (jug==jug_4 && !doble){
//            jug_aux = jug_1;
      //  }
        
        tablero.setTurno(jug.getNum());
        actualizarFichas();
        //Ganar(jug_1);// funcion que corona todas las fichas del jugador integrado 
        return this.salio;
    }

    private void verificar(int a, int b, int c) {

        Estado_ficha estado = new Encarcelada();

        for (int i = 0; i <= 15; i++) {

            if (pos[i] == a || pos[i] == b) {
                if (est[i] == 2) {

                    if (i >= 0 && i <= 3 && (c == 2 || c == 3 || c == 4)) {
                        
                        cambiar(i, estado);
                        tablero.getCont().setFicha(i, 0, 70);
                        tablero.getCont().setFicha(i, 1, 70);
                    }
                    if (i >= 4 && i <= 7 && (c == 1 || c == 3 || c == 4)) {
                        cambiar(i, estado);
                        tablero.getCont().setFicha(i, 0, 71);
                        tablero.getCont().setFicha(i, 0, 71);
                    }
                    if (i >= 8 && i <= 11 && (c == 1 || c == 2 || c == 4)) {
                        cambiar(i, estado);
                        tablero.getCont().setFicha(i, 0, 72);
                        tablero.getCont().setFicha(i, 0, 72);
                    }
                    if (i >= 12 && i <= 15 && (c == 2 || c == 3 || c == 1)) {
                        cambiar(i, estado);
                        tablero.getCont().setFicha(i, 0, 73);
                        tablero.getCont().setFicha(i, 0, 73);
                    }
                }
            }

        }
    }

    private void cambiar(int i, Estado_ficha a) {
        switch (i) {

            case 0:
                jug_1.setEst(1, a);
                jug_1.setPos(1, 70);

                break;
            case 1:
                jug_1.setEst(2, a);
                jug_1.setPos(2, 70);

                break;
            case 2:
                jug_1.setEst(3, a);
                jug_1.setPos(3, 70);
                break;
            case 3:
                jug_1.setEst(4, a);
                jug_1.setPos(4, 70);
                break;
            case 4:
                jug_2.setEst(1, a);
                jug_2.setPos(1, 71);
                break;
            case 5:
                jug_2.setEst(2, a);
                jug_2.setPos(2, 71);
                break;
            case 6:
                jug_2.setEst(3, a);
                jug_2.setPos(3, 71);
                break;
            case 7:
                jug_2.setEst(4, a);
                jug_2.setPos(4, 71);
                break;
            case 8:
                jug_3.setEst(1, a);
                jug_3.setPos(1, 72);
                break;
            case 9:
                jug_3.setEst(2, a);
                jug_3.setPos(2, 72);
                break;
            case 10:
                jug_3.setEst(3, a);
                jug_3.setPos(3, 72);
                break;
            case 11:
                jug_3.setEst(4, a);
                jug_3.setPos(4, 72);
                break;
            case 12:
                jug_4.setEst(1, a);
                jug_4.setPos(1, 73);
                break;
            case 13:
                jug_4.setEst(2, a);
                jug_4.setPos(2, 73);
                break;
            case 14:
                jug_4.setEst(3, a);
                jug_4.setPos(3, 73);
                break;
            case 15:
                jug_4.setEst(4, a);
                jug_4.setPos(4, 73);
                break;

            default:
        }

    }

    private boolean VerEnc(Jug_abstracto jug) {

        return !(jug.getEst(1) == 1 || jug.getEst(2) == 1 || jug.getEst(3) == 1 || jug.getEst(4) == 1);

    }

    private void Ganar(Jug_abstracto jug) {
        jug.setEst(1, new Fuera());
        jug.setEst(2, new Fuera());
        jug.setEst(3, new Fuera());
        jug.setEst(4, new Fuera());

    }

    public boolean VerFin(Jug_abstracto jug) {

        return !(jug.getEst(1) == 5 && jug.getEst(2) == 5 && jug.getEst(3) == 5 && jug.getEst(4) == 5);

    }

    private boolean VerEnc2(Jug_abstracto jug) {

        return !(jug.getEst(1) == 1 && jug.getEst(2) == 1 && jug.getEst(3) == 1 && jug.getEst(4) == 1);

    }
    
    private boolean VerEnc3(Jug_abstracto jug) {
        int cont=0;
        
        for(int i=1;i<5;i++){
        
            if(jug.getEst(i)==5){
                
                cont++;
            
            }
        
        }
        
        if(cont==3){
            
        
            return true;
        
        }else return false;

    }
    
    private boolean VerEnc4(Jug_abstracto jug) {
        int cont=0;
        for(int i=1;i<5;i++){
        
            if(jug.getEst(i) == 4){
                
                cont++;
            
            }
        
        }
        
        if(cont==1){
            
        
            return true;
        
        }else return false;

    }

    private boolean Jugar(Jug_abstracto jug_1) {

        llenar();
        actualizarFichas();
        proxy.setSujeto((Jug_real) jug_1);
        if (VerEnc(jug_1)) {
            
            if(VerEnc3(jug_1)){
                
                salio=true;
                JOptionPane.showMessageDialog(tablero, "solo tiene una ficha");
                JOptionPane.showMessageDialog(tablero, "Se lanzaran los dados");
                dado1.lanzar();//que sean un boton de lanzar 
                tablero.setDados(dado1.getvalor(), dado2.getvalor2());
                if(VerEnc4(jug_1)){
                    
                                JOptionPane.showMessageDialog(tablero, "solo se movera con un dado");
                                tablero.par();
                                salio=false;
                
                }else {
                
                    if (dado1.getvalor() == dado2.getvalor2()) {

                    JOptionPane.showMessageDialog(tablero, "Saco Par!!!");

                        return true;
                    } else {
                        return false;
                    }
                
                
                }
                
            
            }
            
            salio=true;
            JOptionPane.showMessageDialog(tablero, "Se lanzaran los dados ");
            dado1.lanzar();//que sean un boton de lanzar 
            tablero.setDados(dado1.getvalor(), dado2.getvalor2());
            if (dado1.getvalor() == dado2.getvalor2()) {

                JOptionPane.showMessageDialog(tablero, "Saco Par!!!");

                return true;
            } else {
                return false;
            }

        } else {

            if (VerEnc2(jug_1)) {
                salio=true;
                JOptionPane.showMessageDialog(tablero, "tiene algunas fichas en la carcel ");
                JOptionPane.showMessageDialog(tablero, "Se lanzaran los dados");
                dado1.lanzar();//que sean un boton de lanzar 
                tablero.setDados(dado1.getvalor(), dado2.getvalor2());
                if (dado1.getvalor() == dado2.getvalor2()) {

                    JOptionPane.showMessageDialog(tablero, "Saco Par,Tiene fichas en la carcel, cuantas desea sacar (1 o 2 o ninguna)");
                    String res = JOptionPane.showInputDialog("1 ó 2 ó ninguna");
                    if (null != res) {

                        switch (res) {

                            case "1":
                                Sacar_carcel((Jug_real) jug_1, 1);
                                JOptionPane.showMessageDialog(tablero, "Se movera " + dado2.getvalor2() + " con otra ficha");
                                tablero.par();
                                salio=false;
                                break;
                            case "2":

                                Sacar_carcel((Jug_real) jug_1, 2);
                                llenar();
                                jugar(jug_1);
                                break;
                            case "ninguna":

                                break;
                                
                            case "1 ":
                                Sacar_carcel((Jug_real) jug_1, 1);
                                JOptionPane.showMessageDialog(tablero, "Se movera " + dado2.getvalor2() + " con otra ficha");
                                tablero.par();
                                salio=false;
                                break;
                            case "1  ":
                                Sacar_carcel((Jug_real) jug_1, 1);
                                JOptionPane.showMessageDialog(tablero, "Se movera " + dado2.getvalor2() + " con otra ficha");
                                tablero.par();
                                salio=false;
                                break;
                            case "2 ":
                                Sacar_carcel((Jug_real) jug_1, 2);
                                llenar();
                                jugar(jug_1);
                                break;
                            case "2  ":
                                Sacar_carcel((Jug_real) jug_1, 2);
                                llenar();
                                jugar(jug_1);
                                break;
                            default:
                                break;
                        }
                    }
                    return true;
                } else {
                    return false;
                }

            }else {
                salio=true;
                JOptionPane.showMessageDialog(tablero, "Tiene todas la fichas en la carcel");
                for (int i = 0; i < 3; i++) {

                    JOptionPane.showMessageDialog(tablero, "Se lanzaran los dados ");
                    dado1.lanzar();//que sean un boton de lanzar 
                    tablero.setDados(dado1.getvalor(), dado2.getvalor2());
                    if (dado1.getvalor() == dado2.getvalor2()) {
                        JOptionPane.showMessageDialog(tablero, "Saco par, se sacaran fichas de la carcel");
                        if (dado1.getvalor() == 1 || dado1.getvalor() == 6) {
                            Sacar_carcel((Jug_real) jug_1, 4);

                        } else {
                            Sacar_carcel((Jug_real) jug_1, 2);
                        }
                        jug_1.setUlt();
                        verificar(proxy.getUlt1(), proxy.getUlt2(), proxy.getNumP());
                        llenar();
                        jugar(jug_1);
                        return true;
                    }
                    tablero.repaint();
                }
                
            }
        }
        actualizarFichas();
        salio=false;
        return false;
    }

    private void Sacar_carcel(Jug_real a, int b) {
        int f;
        int c = a.getNum();

        switch (a.getNum()) {

            case 1:
                f = 5;
                break;
            case 2:
                f = 22;
                break;
            case 3:
                f = 39;
                break;
            case 4:
                f = 56;
                break;
            default:
                f = 1000;

        }

        for (int i = 0; i <= 15; i++) {

            if (pos[i] == f) {

                if (i >= 0 && i <= 3 && (c == 2 || c == 3 || c == 4)) {
                    cambiar(i, new Encarcelada());
                }
                if (i >= 4 && i <= 7 && (c == 1 || c == 3 || c == 4)) {
                    cambiar(i, new Encarcelada());
                }
                if (i >= 8 && i <= 11 && (c == 1 || c == 2 || c == 4)) {
                    cambiar(i, new Encarcelada());
                }
                if (i >= 12 && i <= 15 && (c == 2 || c == 3 || c == 1)) {
                    cambiar(i, new Encarcelada());
                }

            }

        }

        for (int i = 0; i < b; i++) {

            for (int j = 1; j < 5; j++) {
                if (a.getEst(j) == 1) {
                    a.setEst(j, new Seguro());
                    a.setPos(j, 0, a.getNum());
                    break;
                }
            }
        }
    }

    public void actualizarFichas() {
        for (int i = 0; i < pos.length; i++) {

            tablero.getCont().setFicha(i, 0, tablero.getCont().getX(pos[i], i % 4));
            tablero.getCont().setFicha(i, 1, tablero.getCont().getY(pos[i], i % 4));
        }

        tablero.repaint();
    }
    public Jug_abstracto getJug_aux() {
        return jug_aux;
    }

    public void setJug_aux(Jug_abstracto jug_aux) {
        this.jug_aux = jug_aux;
    }

    public boolean Mov(int dad,String ficha) {
        boolean ret=proxy.jugar(dad, ficha);
        verificar(proxy.getUlt1(), proxy.getUlt2(), proxy.getNumP());
        llenar();
        return ret;
    }
}
