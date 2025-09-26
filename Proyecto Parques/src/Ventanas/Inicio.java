/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Main.Controlador2;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jp
 */
public class Inicio extends JFrame{
    
    
    private JPanel panel1;
    private JButton op1;
    private JButton op2;
    private JButton op3;
    private JButton op4;
    
    public Inicio (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,300);
        setTitle("Pagina de inicio");
        setLayout(null);
        setLocationRelativeTo(null);
        
        
    }
     
      public void paint(Graphics g) {
          
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/fondoInicio.JPG"));
        g.drawImage(imagenFondo.getImage(), 0, 0, 350, 300, null);
          
        g.setColor( Color.LIGHT_GRAY );
        g.setFont( new Font( "Tahoma", Font.BOLD, 46 ) );
        
        g.drawString("Parquès",90,60);
        
        iniciarComponentes();
          
        op1= new JButton("1 Jugador");
        op1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                Controlador2 c= new Controlador2();
                Ventana frame=new Ventana(c,"1");
                frame.setVisible(true);
                eliminar();
                
            }
        });
        panel1.add(op1);
        op1.setBounds(100,50,140,20);  
          
        op2= new JButton("2 Jugadores"); 
        panel1.add(op2);
        op2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                Controlador2 c= new Controlador2();
                Ventana frame=new Ventana(c,"2");
                frame.setVisible(true);
                eliminar();
                
            }
        });
       
        op2.setBounds(100,80,140,20);
        
        op3= new JButton("3 Jugadores");
        
        op3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                Controlador2 c= new Controlador2();
                Ventana frame=new Ventana(c,"3");
                frame.setVisible(true);
                eliminar();
                
            }
        });
        panel1.add(op3);
        op3.setBounds(100,110,140,20);
        
        op4= new JButton("4 Jugadores");
       
        op4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                Controlador2 c= new Controlador2();
                Ventana frame=new Ventana(c,"4");
                frame.setVisible(true);
                eliminar();
                
            }
        });
        panel1.add(op4);
         op4.setBounds(100,140,140,20);
        
      }
    public void iniciarComponentes(){
        
        AudioClip sonido;
        sonido= java.applet.Applet.newAudioClip(getClass().getResource("/audio/s.wav"));
        sonido.loop();
        
        panel1= new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(0,0,350,300);
        panel1.setLayout(null);
        
        
        this.add(panel1);
    } 
    
    public void eliminar(){
        this.dispose();
    }
    
}
