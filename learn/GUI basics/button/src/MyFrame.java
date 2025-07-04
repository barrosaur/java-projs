import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements  ActionListener{
    JButton button;
    JLabel label;

    MyFrame() {
        label = new JLabel();
        label.setText("I appeared after clicking the button");
        label.setBounds(200, 200, 100, 200);
        label.setVisible(false);
        label.setSize(200, 200);

        button = new JButton();
        button.setBounds(200, 100, 100, 50);
        button.addActionListener(this);
        button.setText("Click me");

        // getting rid of the border around the text
        button.setFocusable(false);
        button.setBackground(Color.GRAY);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLayout(null);
        this.add(button);
        this.add(label);
        this.setTitle("Buttons");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            label.setVisible(true);
        }
    }
}
