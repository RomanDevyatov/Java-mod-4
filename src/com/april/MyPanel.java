package com.april;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel {
    public Game game;
    private Timer timer;
    private Image
            fon,
            telo,
            golova,
            ob,
            endg;
    private JLabel lb;
    private JButton btn1, btn2;

    public MyPanel() {
        try {
            this.fon = ImageIO.read(new File("C:\\Users\\r.devyatov\\Downloads\\Zmeika\\fon.png"));
            this.telo = ImageIO.read(new File("C:\\Users\\r.devyatov\\Downloads\\Zmeika\\telo.png"));
            this.golova = ImageIO.read(new File("C:\\Users\\r.devyatov\\Downloads\\Zmeika\\golova.png"));
            this.ob = ImageIO.read(new File("C:\\Users\\r.devyatov\\Downloads\\Zmeika\\ob.png"));
            this.endg = ImageIO.read(new File("C:\\Users\\r.devyatov\\Downloads\\Zmeika\\endg.png"));
        } catch (Exception e) {
            System.out.println("Файл не прочитался");
        }

        game = new Game();
        game.start();

        timer = new Timer(10, new ActionListener( ) {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
        setLayout(null);

        lb = new JLabel("Счет: 0");
        lb.setForeground(Color.WHITE);
        lb.setFont(new Font("serif", 0, 30));
        lb.setBounds(630, 200, 150, 50);
        add(lb);

        btn1 = new JButton();
        btn1.setText("Новая игра");
        btn1.setForeground(Color.BLUE);
        btn1.setFont(new Font("serif", 0, 20));
        btn1.setBounds(630, 30, 150, 50);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                game.start();
            }
        });
        add(btn1);

        btn2 = new JButton();
        btn2.setText("Выход");
        btn2.setForeground(Color.BLUE);
        btn2.setFont(new Font("serif", 0, 20));
        btn2.setBounds(630, 100, 150, 50);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        add(btn2);
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        gr.drawImage(fon, 0, 0, 800, 650, null);

        for (int i = 0; i < 30; i++) {
            for (int k = 0; k < 30; k++) {
                if (game.getMasByXY(k, i) != 0) {
                    if (game.getMasByXY(k, i) == 1) {
                        gr.drawImage(golova, 10 + k * 20, 10 + i * 20, 20, 20, null);
                    } else if (game.getMasByXY(k, i) == -1) {
                        gr.drawImage(ob, 10 + k * 20, 10 + i * 20, 20, 20, null);
                    }
                }
            }
        }

        gr.setColor(Color.BLUE);
        for (int i = 0; i <= 30; i++) {
            gr.drawLine(10 + i * 20, 10, 10 + i * 20, 610);
            gr.drawLine(10, 10 + i * 20, 610, 10 + i * 20);
        }

        //i = 0: gr.drawLine(10, 10, 10, 610);
        //i = 1: gr.drawLine(30, 10, 30, 610);
        //i = 2: gr.drawLine(50, 10, 50, 610);


    }




}
