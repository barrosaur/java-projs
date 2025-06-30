import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // set JFrame first
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setTitle("Panels with BorderLayout");

        // RED
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);
        redPanel.setLayout(new BorderLayout());

        JLabel redLabel = new JLabel();
        redLabel.setText("RED");
        redLabel.setVerticalAlignment(JLabel.CENTER);
        redLabel.setHorizontalAlignment(JLabel.CENTER);
        redLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        // BLUE
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250, 0, 250, 250);
        bluePanel.setLayout(new BorderLayout());

        JLabel blueLabel = new JLabel();
        blueLabel.setText("BLUE");
        blueLabel.setVerticalAlignment(JLabel.CENTER);
        blueLabel.setHorizontalAlignment(JLabel.CENTER);
        blueLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        // GREEN
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0, 250, 500, 250);

        JLabel greenLabel = new JLabel();
        greenLabel.setText("GREEN");
        greenLabel.setHorizontalAlignment(JLabel.CENTER);
        greenLabel.setVerticalAlignment(JLabel.CENTER);
        greenLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        // dont forget
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);

        redPanel.add(redLabel);
        bluePanel.add(blueLabel);
        greenPanel.add(greenLabel);
    }
}