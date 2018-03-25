package atrapados;

import javax.swing.*;
import java.awt.*;

public class Atrapados extends Canvas implements Runnable{

    private static JFrame ventana;

    private static final int ANCHO = 400;
    private static final int ALTO = 400;

    private volatile static boolean juegoTermina = false;
    private static final String NOMBRE = "ATRAPADOS";

    private int aps = 0;
    private int fps = 0;

    private static Thread hilo;

    private Atrapados(){
        setPreferredSize(new Dimension(ANCHO, ALTO));

        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }

    public static void main(String [] args){
        Atrapados atrapados = new Atrapados();
        atrapados.iniciar();
    }

    private synchronized void iniciar() {
        juegoTermina = true;
        hilo = new Thread(this, "Graficos");
        hilo.start();
    }

    private synchronized void detener() {
        juegoTermina = false;

        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void actualizar() {
        aps++;
    }

    private void mostrar() {
        fps ++;
    }

    @Override
    public void run() {

        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta = 0;

        while (juegoTermina) {
            final long iniciobucle = System.nanoTime();

            tiempoTranscurrido = iniciobucle - referenciaActualizacion;
            referenciaActualizacion = iniciobucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            while (delta >= 1) {
                actualizar();
                delta--;
            }

            mostrar();

            if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                ventana.setTitle(NOMBRE + " (APS: " + aps + fps);
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
}
