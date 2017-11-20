package tetris;

import javax.swing.*;
import java.awt.*;

/**
 * Clase principal del juego
 */
public class Tetris extends JFrame {

    JLabel statusBar;

    /**
     * Contructor
     */
    public Tetris() {
        statusBar = new JLabel(" 0");
        add(statusBar, BorderLayout.SOUTH);
     //   Board board = new Board(this);
     //   add(board);
     //   board.start();

        setSize(200, 400);
        setTitle(" T E T R I S ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Obtiene el estado de la barra
     * @return
     */
    public JLabel getStatusBar() {
        return statusBar;
    }

    /**
     * Metodo principal del proyecto
     * @param args
     */
    public static void main(String[] args) {
        Tetris game = new Tetris();
        int [][] tabla = {{0,0}, {0,0}}
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
