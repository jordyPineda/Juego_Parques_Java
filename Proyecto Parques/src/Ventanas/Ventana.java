package Ventanas;

import Main.Controlador;
import Main.Controlador2;
import java.applet.AudioClip;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import proxy.Jug_abstracto;
import proxy.Jug_real;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alba
 */
public class Ventana extends JFrame implements ActionListener {

    private Controlador2 ct;
    private Controlador cc;
    private JPanel contentPane;
    private JButton boton;
    private JButton dado2;
    private JButton dado1;
    private JButton ficha1;
    private JButton ficha2;
    private JButton ficha3;
    private JButton ficha4;
    private JLabel turno;
    private int est;
    private int dadop;
    private int dadoq;
    private int dado;
    private boolean salio;
    private boolean jordy;
    private Jug_abstracto jug;
    AudioClip sonido;
        

    public Ventana(Controlador2 a, String j) {
        
        cc = new Controlador(this,j);
        ct = a;
        sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Audio/s.wav"));
        sonido.play();
        jordy=true;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 850, 720);
        setLayout(null);
        setLocationRelativeTo(null);

        this.inicializar();
        
        boton.addActionListener(this);
        boton.setBounds(700, 20, 100, 30);
        add(boton);

        ficha1.addActionListener(this);
        ficha1.setBounds(700, 260, 100, 30);
        ficha1.setEnabled(false);
        add(ficha1);

        ficha2.addActionListener(this);
        ficha2.setBounds(700, 310, 100, 30);
        ficha2.setEnabled(false);
        add(ficha2);

        ficha3.addActionListener(this);
        ficha3.setBounds(700, 360, 100, 30);
        ficha3.setEnabled(false);
        add(ficha3);

        ficha4.addActionListener(this);
        ficha4.setBounds(700, 410, 100, 30);
        ficha4.setEnabled(false);
        add(ficha4);

        dado1.addActionListener(this);
        dado1.setBounds(700, 160, 100, 30);
        dado1.setEnabled(false);
        add(dado1);

        dado2.addActionListener(this);
        dado2.setBounds(700, 210, 100, 30);
        dado2.setEnabled(false);
        add(dado2);

        add(turno);
    }

    @Override
    public void paint(Graphics g) {

        g.clearRect(700, 100, 150, 570);
        g.clearRect(15, 23, 680, 680);
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        g.drawImage(imagenFondo.getImage(), 15, 23, 680, 680, null);

        //pintar fichas Verdes
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/fichaVerde.png"));
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[0][0], ct.getPosiciones()[0][1], 30, 30, null);
        g.drawString("1", ct.getPosiciones()[0][0] + 12, ct.getPosiciones()[0][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[1][0], ct.getPosiciones()[1][1], 30, 30, null);
        g.drawString("2", ct.getPosiciones()[1][0] + 12, ct.getPosiciones()[1][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[2][0], ct.getPosiciones()[2][1], 30, 30, null);
        g.drawString("3", ct.getPosiciones()[2][0] + 12, ct.getPosiciones()[2][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[3][0], ct.getPosiciones()[3][1], 30, 30, null);
        g.drawString("4", ct.getPosiciones()[3][0] + 12, ct.getPosiciones()[3][1] + 18);
        //fin fichas Verdes

        //pintar fichas rojas
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/fichaRoja.png"));
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[4][0], ct.getPosiciones()[4][1], 30, 30, null);
        g.drawString("1", ct.getPosiciones()[4][0] + 12, ct.getPosiciones()[4][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[5][0], ct.getPosiciones()[5][1], 30, 30, null);
        g.drawString("2", ct.getPosiciones()[5][0] + 12, ct.getPosiciones()[5][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[6][0], ct.getPosiciones()[6][1], 30, 30, null);
        g.drawString("3", ct.getPosiciones()[6][0] + 12, ct.getPosiciones()[6][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[7][0], ct.getPosiciones()[7][1], 30, 30, null);
        g.drawString("4", ct.getPosiciones()[7][0] + 12, ct.getPosiciones()[7][1] + 18);
        //fin fichas rojas

        //inicio fichas amarillas
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/fichaAmarilla.png"));
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[8][0], ct.getPosiciones()[8][1], 35, 35, null);
        g.drawString("1", ct.getPosiciones()[8][0] + 12, ct.getPosiciones()[8][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[9][0], ct.getPosiciones()[9][1], 35, 35, null);
        g.drawString("2", ct.getPosiciones()[9][0] + 12, ct.getPosiciones()[9][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[10][0], ct.getPosiciones()[10][1], 35, 35, null);
        g.drawString("3", ct.getPosiciones()[10][0] + 12, ct.getPosiciones()[10][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[11][0], ct.getPosiciones()[11][1], 35, 35, null);
        g.drawString("4", ct.getPosiciones()[11][0] + 12, ct.getPosiciones()[11][1] + 18);
        //fin fichas Amarillas

        //inicio fichas Azules
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/fichaAzul.png"));
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[12][0], ct.getPosiciones()[12][1], 35, 35, null);
        g.drawString("1", ct.getPosiciones()[12][0] + 12, ct.getPosiciones()[12][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[13][0], ct.getPosiciones()[13][1], 35, 35, null);
        g.drawString("2", ct.getPosiciones()[13][0] + 12, ct.getPosiciones()[13][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[14][0], ct.getPosiciones()[14][1], 35, 35, null);
        g.drawString("3", ct.getPosiciones()[14][0] + 12, ct.getPosiciones()[14][1] + 18);
        g.drawImage(imagenFondo.getImage(), ct.getPosiciones()[15][0], ct.getPosiciones()[15][1], 35, 35, null);
        g.drawString("4", ct.getPosiciones()[15][0] + 12, ct.getPosiciones()[15][1] + 18);

        g.drawString(turno.getText(), 700, 130);
        
        if(dado1.getText().equals("Dado 1: 1")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/1.JPG"));
            g.drawImage(imagenFondo.getImage(),700, 150, 35, 35, null);
        }else  if(dado1.getText().equals("Dado 1: 2")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/2.JPG"));
            g.drawImage(imagenFondo.getImage(),700, 150, 35, 35, null);
        }else  if(dado1.getText().equals("Dado 1: 3")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/3.JPG"));
            g.drawImage(imagenFondo.getImage(),700, 150, 35, 35, null);
        }else  if(dado1.getText().equals("Dado 1: 4")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/4.JPG"));
            g.drawImage(imagenFondo.getImage(),700, 150, 35, 35, null);
        }else  if(dado1.getText().equals("Dado 1: 5")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/5.JPG"));
            g.drawImage(imagenFondo.getImage(),700, 150, 35, 35, null);
        }else  if(dado1.getText().equals("Dado 1: 6")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/6.JPG"));
            g.drawImage(imagenFondo.getImage(),700, 150, 35, 35, null);
        }else{
          g.drawString(dado1.getText(), 700, 150);   
        }
        
        
        if(dado2.getText().equals("Dado 2: 1")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/1.JPG"));
            g.drawImage(imagenFondo.getImage(),738, 150, 35, 35, null);
        }else  if(dado2.getText().equals("Dado 2: 2")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/2.JPG"));
            g.drawImage(imagenFondo.getImage(),738, 150, 35, 35, null);
        }else  if(dado2.getText().equals("Dado 2: 3")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/3.JPG"));
            g.drawImage(imagenFondo.getImage(),738, 150, 35, 35, null);
        }else  if(dado2.getText().equals("Dado 2: 4")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/4.JPG"));
            g.drawImage(imagenFondo.getImage(),738, 150, 35, 35, null);
        }else  if(dado2.getText().equals("Dado 2: 5")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/5.JPG"));
            g.drawImage(imagenFondo.getImage(),738, 150, 35, 35, null);
        }else  if(dado2.getText().equals("Dado 2: 6")){
            imagenFondo = new ImageIcon(getClass().getResource("/imagenes/6.JPG"));
            g.drawImage(imagenFondo.getImage(),738, 150, 35, 35, null);
        }else{
            g.drawString(dado2.getText(), 700, 170);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean movio;
        if (ae.getSource() == boton && est == 0) {
            salio = cc.jugar(jug);
            jug = cc.getJug_aux();
            if (salio) {
                est = 1;
                boton.setEnabled(false);
                dado1.setEnabled(true);
                dado2.setEnabled(true);
            }
        } else if ((ae.getSource() == dado1 || ae.getSource() == dado2) && (est == 1)) {
            if (ae.getSource() == dado1) {
                dado = dadop;
                dado1.setEnabled(false);
            } else {
                dado = dadoq;
                dado2.setEnabled(false);
            }
            est = 2;
            ficha1.setEnabled(true);
            ficha2.setEnabled(true);
            ficha3.setEnabled(true);
            ficha4.setEnabled(true);
        } else if ((ae.getSource() == dado1 || ae.getSource() == dado2) && est == 2) {
            if (ae.getSource() == dado1) {
                dado += dadop;
                dado1.setEnabled(false);
            } else {
                dado += dadoq;
                dado2.setEnabled(false);
            }
            est = 3;
        } else if ((ae.getSource() == ficha1 || ae.getSource() == ficha2 || 
                     ae.getSource() == ficha3 || ae.getSource() == ficha4)) {
            if (est == 2) {
                if (ae.getSource() == ficha1) {
                    ficha1.setEnabled(false);
                    movio = cc.Mov(dado, "1");
                } else if (ae.getSource() == ficha2) {
                    ficha2.setEnabled(false);
                    movio = cc.Mov(dado, "2");
                } else if (ae.getSource() == ficha3) {
                    ficha3.setEnabled(false);
                    movio = cc.Mov(dado, "3");
                } else {
                    ficha4.setEnabled(false);
                    movio = cc.Mov(dado, "4");
                }
                if (movio) {
                    if (dado == dadop) {
                        dado = dadoq;
                    } else {
                        dado = dadop;
                    }
                    dado1.setEnabled(false);
                    dado2.setEnabled(false);
                    est = 3;
                    
                }
                if(!jordy){
                    boton.setEnabled(true);
                    ficha1.setEnabled(false);
                    ficha2.setEnabled(false);
                    ficha3.setEnabled(false);
                    ficha4.setEnabled(false);
                    turno.setText("Jugador: " + jug.getNum());
                    repaint();
                    est=0;
                    jordy=true;
                }
            } else if (est == 3) {

                boton.setEnabled(true);
                if (ae.getSource() == ficha1) {
                    movio = cc.Mov(dado, "1");
                } else if (ae.getSource() == ficha2) {
                    movio = cc.Mov(dado, "2");
                } else if (ae.getSource() == ficha3) {
                    movio = cc.Mov(dado, "3");
                } else {
                    movio = cc.Mov(dado, "4");
                }
                if (movio) {
                    est = 0;
                    ficha1.setEnabled(false);
                    ficha2.setEnabled(false);
                    ficha3.setEnabled(false);
                    ficha4.setEnabled(false);
                    turno.setText("Jugador: " + jug.getNum());
                }
                repaint();
            }
        }
        cc.actualizarFichas();
        //if(cc.VerFin(jug)) ganar();
        repaint();
        
        
    }

    public Controlador2 getCont() {
        return ct;
    }

    public void setTurno(int turn) {
        turno.setText("Jugador: " + String.valueOf(turn));
    }

    public void setDados(int d1, int d2) {
        dado1.setText("Dado 1: " + String.valueOf(d1));
        dado2.setText("Dado 2: " + String.valueOf(d2));
        dadop = d1;
        dadoq = d2;
    }

    public void inicializar() {
        
        
        
        jug = cc.getJug_aux();
        est = 0;
        ficha1 = new JButton("Ficha 1");
        ficha2 = new JButton("Ficha 2");
        ficha3 = new JButton("Ficha 3");
        ficha4 = new JButton("Ficha 4");
        boton = new JButton("Iniciar");
        dado1 = new JButton("Dado 1:");
        dado2 = new JButton("Dado 2:");
        turno = new JLabel("Jugador:");

    }

    public void ganar() {
        JOptionPane.showMessageDialog(this, "Felicidades jugador "+jug.getNum()+", ha ganado");
        this.dispose();
    }

    public void par() {
        salio = false;
        est = 1;
        boton.setEnabled(false);
        dado1.setEnabled(true);
        dado2.setEnabled(false);
        jordy=false;
    }
    
    public void unaF() {
        salio = false;
        est = 1;
        boton.setEnabled(false);
        dado1.setEnabled(true);
        dado2.setEnabled(true);
        jordy=false;
    }

    public void par2(){
        salio=false;
    }
    
}