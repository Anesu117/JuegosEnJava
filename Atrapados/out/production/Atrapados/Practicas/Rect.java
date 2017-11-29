package Practicas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rect extends JFrame {

    public Rect() {
        super("Intro");
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        this.setSize(250, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        Stroke pincel = new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2D.setStroke(pincel);

        g2D.setColor(Color.RED);
        Rectangle2D rectangle = new Rectangle2D.Float(75, 50, 100, 100);
        g2D.fill(rectangle);
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        g2D.setColor(Color.GREEN);
        g2D.setComposite(alphaComposite);
        rectangle = new Rectangle2D.Float(20, 100, 100, 100);
        g2D.fill(rectangle);
        g2D.setColor(Color.BLUE);
        rectangle = new Rectangle2D.Float(130, 100, 100, 100);
        g2D.fill(rectangle);
        g2D.draw(rectangle);
    }

    public static void main(String [] args){
        Rect ventana = new Rect();
    }

}
