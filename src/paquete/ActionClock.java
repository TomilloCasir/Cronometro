package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JLabel;

public class ActionClock implements ActionListener {

    private int segundos;
    private int minutos;
    private int horas;
    private JLabel lblTime;
    private JLabel lblDate;
    private boolean runTimer = false;

    public ActionClock(JLabel lblDate, JLabel lblTime) {
        this.lblDate = lblDate;
        this.lblTime = lblTime;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (runTimer) {
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
        }

        lblDate.setText(new Date().toString());
    }
    
    public void enableTimer(boolean flag) {
        runTimer = flag;
        
        if (!runTimer) {
            reset();
        }
    }
    
    public void reset() {
        lblTime.setText("00:00:00");
        segundos = 0;
        minutos = 0;
        horas = 0;
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
