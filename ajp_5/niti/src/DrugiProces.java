import javax.swing.*;
import java.time.LocalTime;

public class DrugiProces implements Runnable {
    private JLabel labela;

    public DrugiProces(JLabel labela) {
        this.labela = labela;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            LocalTime lt = LocalTime.now();
            this.labela.setText(lt.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
