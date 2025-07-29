import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements MouseListener{
    JLabel label;

    MyFrame() {
        this.setTitle("MouseListener...");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        label.setBackground(Color.red);
        label.setOpaque(true);
        label.addMouseListener(this);

        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // invoked when the mouse button has been clicked (pressed and released) on a component
        System.out.println("Mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // invoked when a mouse button has been pressed on a component
        System.out.println("Mouse pressed");
        label.setBackground(Color.green);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // invoked when a mouse button has been released on a component
        System.out.println("Mouse released");
        label.setBackground(Color.blue);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // invoked when a mouse enters a component
        System.out.println("Entered mouse"); // also displays if you hover over it
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // invoked when a mouse exit a component
        System.out.println("Exit");
    }
}
