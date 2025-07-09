import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ProgressBar {
    JFrame frame;
    JProgressBar bar = new JProgressBar();

    ProgressBar() {
        frame = new JFrame("Progress Bar");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bar.setValue(0);
        bar.setBounds(0,0,420,50);
        bar.setStringPainted(true);

        frame.add(bar);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }

    public void fill() {
        int counter = 0;

        while(counter <= 100) {
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter += 1;
        }

        bar.setString("Done!");
    }
}
