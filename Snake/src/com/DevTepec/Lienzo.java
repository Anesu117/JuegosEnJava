package com.DevTepec;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jesús on 31/05/2017.
 */
public class Lienzo extends JPanel implements ActionListener {

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;

    /**
     * Constructor
     */
    public Lienzo() {
        //addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
    }

    /**
     * Carga las imagenes del juego
     */
    private void loadImages() {
        ImageIcon imageDot = new ImageIcon("");
        ball = imageDot.getImage();

        ImageIcon imageApple = new ImageIcon("");
        apple = imageApple.getImage();

        ImageIcon imageHead = new ImageIcon("");
        head = imageHead.getImage();
    }

    /**
     * Crear el cuerpo del com.DevTepec.Snake, y llama a el metodo que posiciona alatoriamente una apple
     */
    private void initGame(){
        dots = 3;

        for(int z = 0; z < dots; z++){
            x[z] = 50 - z * 10;
            y[z] = 50;
        }


        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if(inGame) {
            g.drawImage(apple, apple_x, apple_y, this);

            for(int i = 0; i < dots; i++){
                if(i == 0) {
                    g.drawImage(head, x[i], y[i], this);
                } else {
                    g.drawImage(ball, x[i], y[i], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();
        } else {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
