import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JLabel label;

    MyFrame() {
        this.setTitle("Color Chooser");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Pick color");
        button.addActionListener(this);

        label = new JLabel();
        label.setBackground(Color.white);
        label.setText("Hello");
        label.setFont(new Font("MV Boli", Font.PLAIN, 50));
        label.setOpaque(true);

        this.add(button);
        this.add(label);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            JColorChooser chooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Pick color", Color.black);
            label.setForeground(color);
        }
    }
}
