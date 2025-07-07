import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{

    JCheckBox checkbox;
    JButton button;

    MyFrame() {
        this.setTitle("Checkboxes");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        checkbox = new JCheckBox();
        checkbox.setText("I'm not a robot.");
        checkbox.setFocusable(false);

        button = new JButton("submit");
        button.addActionListener(this);

        this.add(checkbox);
        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println(checkbox.isSelected());
        }
    }
}
