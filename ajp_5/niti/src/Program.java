import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class Program {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setSize(300,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JLabel proces1 = new JLabel("Neki tekst");
        JLabel proces2 = new JLabel("Neki tekst");
        JButton dugme = new JButton("Klikni me!");

        /*
        PrviProces pp = new PrviProces(proces1);
        DrugiProces dp = new DrugiProces(proces2);
        Thread t2 = new Thread(dp);
        t2.start();
        pp.start();
         */

        dugme.addActionListener((event) -> {
            proces1.setText("Kliknuto!");
        });

        panel.add(proces1);
        panel.add(proces2);
        panel.add(dugme);
        frame.add(panel);

        while(true) {
            LocalTime lt = LocalTime.now();
            proces2.setText(lt.toString());
        }
    }
}
