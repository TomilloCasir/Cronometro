package paquete;

import javax.swing.JLabel;

public class Clock {

    private int segundos;
    private int minutos;
    private int horas;
    private Thread t;
    volatile boolean threadStopper;

    public Clock(int segundos, int minutos, int horas) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    public Clock() {

    }

    public void ejecutarThread(JLabel lblTime) {
        threadStopper = true;
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    segundos = 0;
                    minutos = 0;
                    horas = 0;
                    while (threadStopper) {
                        segundos++;
                        if (segundos > 59) {
                            segundos = 0;
                            minutos++;
                        }
                        if (minutos > 59) {
                            minutos = 0;
                            horas++;
                        }
                        lblTime.setText(horasToString(horas) + ":" + minutosToString(minutos) + ":" + segundosToString(segundos));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                }
            }
        });
        t.start();
    }

    public void frenarThread(JLabel lblTime) {
        threadStopper = false;
        lblTime.setText("00" + ":" + "00" + ":" + "00");
    }

    public static String segundosToString(int segundos) {
        return segundos > 9 ? segundos + "" : "0" + segundos;
    }

    public static String minutosToString(int minutos) {
        return minutos > 9 ? minutos + "" : "0" + minutos;
    }

    public static String horasToString(int horas) {
        return horas > 9 ? horas + "" : "0" + horas;
    }

}
