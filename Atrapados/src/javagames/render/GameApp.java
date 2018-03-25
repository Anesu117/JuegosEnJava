package javagames.render;

import javagames.util.FrameRate;

import javax.swing.*;
import java.awt.*;

public class GameApp extends JFrame{
    private FrameRate frameRate;

    public GameApp(){
        frameRate = new FrameRate();
    }

    protected void createAndshowGUI(){
        GamePanel gamePanel = new GamePanel();
        gamePanel.setBackground(Color.decode("#03CBE5"));
        gamePanel.setPreferredSize(new Dimension(320, 240));
        getContentPane().add(gamePanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("== Game ==");
        pack();
        frameRate.initialize();
        setVisible(true);
    }

    private class GamePanel extends JPanel {
        public void paint(Graphics g){
            super.paint(g);
            onPaint(g);
        }
    }

    protected void onPaint(Graphics g) {
        frameRate.calculate();
        g.setColor(Color.white);
        g.drawString(frameRate.getFrameRate(), 30, 30);
        repaint();
    }

    public static void main(String[] args){
        final GameApp app = new GameApp();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                app.createAndshowGUI();
            }
        });
    }
}

