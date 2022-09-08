import javax.swing.*;

public class PrviProces extends Thread {
    private JLabel labela;

    public PrviProces(JLabel labela) {
        this.labela = labela;
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            labela.setText(i + "");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
