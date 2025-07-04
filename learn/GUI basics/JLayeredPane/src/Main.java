import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        /*
            JLayeredPane = provides a third dimension for positioning components
            depth, z-index
        */

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground((Color.RED));
        label1.setBounds(50, 50, 200, 200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground((Color.BLUE));
        label2.setBounds(100, 100, 200, 200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground((Color.GREEN));
        label3.setBounds(150, 150, 200, 200);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 500);
        layeredPane.add(label1, Integer.valueOf(2));
        layeredPane.add(label2, Integer.valueOf(0));
        layeredPane.add(label3, Integer.valueOf(1));

        JFrame frame = new JFrame();
        frame.setTitle("JLayeredPane");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(layeredPane);
    }
}