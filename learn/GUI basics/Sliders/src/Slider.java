import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class Slider implements ChangeListener{
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;
    Slider() {
        frame = new JFrame("Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(0, 100, 50);

        slider.setPreferredSize(new Dimension(400, 200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli", Font.PLAIN, 15));
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.addChangeListener(this);

        label.setFont(new Font("MV Boli", Font.PLAIN, 25));

        panel.add(slider);
        panel.add(label);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // adjusts the UI if we change the knob
        label.setText("C = " + slider.getValue());
    }
}
