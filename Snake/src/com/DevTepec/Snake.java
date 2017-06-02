package com.DevTepec;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Created by Jesús on 31/05/2017.
 */
public class Snake extends JFrame {

    public Snake() {

        add(new Lienzo());

        setResizable(false);
        pack();

        setTitle("com.DevTepec.Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ex = new Snake();
                ex.setVisible(true);
            }
        });
    }
}