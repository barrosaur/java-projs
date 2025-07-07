import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    JRadioButton pizzaBtn;
    JRadioButton baconBtn;
    JRadioButton lechonBtn;
    ButtonGroup buttonGroup;

    MyFrame() {
        this.setTitle("Radio Buttons");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        // TO PREVENT SELECTING ALL RADIO BUTTONS AND LIMITING IT
        buttonGroup = new ButtonGroup();

        pizzaBtn = new JRadioButton("Pizza");
        baconBtn = new JRadioButton("Bacon");
        lechonBtn = new JRadioButton("Lechon");
        buttonGroup.add(pizzaBtn);
        buttonGroup.add(baconBtn);
        buttonGroup.add(lechonBtn);

        pizzaBtn.addActionListener(this);
        lechonBtn.addActionListener(this);
        baconBtn.addActionListener(this);

        this.add(pizzaBtn);
        this.add(baconBtn);
        this.add(lechonBtn);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pizzaBtn) {
            System.out.println("🍕");
        } else if(e.getSource()==baconBtn) {
            System.out.println("🥓");
        } else if(e.getSource()==lechonBtn) {
            System.out.println("🐷");
        }
    }
}
