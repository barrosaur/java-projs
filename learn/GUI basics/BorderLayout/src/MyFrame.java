import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{

    /*
        Border layout places components in five areas: NORTH, SOUTH, WEST, EAST, CENTER
        All extra space is placed in the center area
     */

    JPanel redPanel = new JPanel();
    JPanel greenPanel = new JPanel();
    JPanel yellowPanel = new JPanel();
    JPanel magentaPanel = new JPanel();
    JPanel bluePanel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    MyFrame() {
        this.setTitle("BorderLayout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(600, 600);

        redPanel.setBackground(Color.red);
        redPanel.setPreferredSize(new Dimension(100, 100));
        greenPanel.setBackground(Color.green);
        greenPanel.setPreferredSize(new Dimension(100, 100));
        yellowPanel.setBackground(Color.yellow);
        yellowPanel.setPreferredSize(new Dimension(100, 100));
        magentaPanel.setBackground(Color.magenta);
        magentaPanel.setPreferredSize(new Dimension(100, 100));
        bluePanel.setBackground(Color.blue);
        bluePanel.setPreferredSize(new Dimension(100, 100));

        this.add(redPanel, BorderLayout.NORTH);
        this.add(greenPanel, BorderLayout.EAST);
        this.add(yellowPanel, BorderLayout.WEST);
        this.add(magentaPanel, BorderLayout.SOUTH);
        this.add(bluePanel, BorderLayout.CENTER);

        // sub panels in the center (blue)
        bluePanel.setLayout(new BorderLayout());

        panel1.setBackground(Color.black);
        panel1.setPreferredSize(new Dimension(50, 50));
        panel2.setBackground(Color.darkGray);
        panel2.setPreferredSize(new Dimension(50, 50));
        panel3.setBackground(Color.gray);
        panel3.setPreferredSize(new Dimension(50, 50));
        panel4.setBackground(Color.lightGray);
        panel4.setPreferredSize(new Dimension(50, 50));
        panel5.setBackground(Color.white);
        panel5.setPreferredSize(new Dimension(50, 50));

        bluePanel.add(panel1, BorderLayout.NORTH);
        bluePanel.add(panel2, BorderLayout.EAST);
        bluePanel.add(panel3, BorderLayout.WEST);
        bluePanel.add(panel4, BorderLayout.SOUTH);
        bluePanel.add(panel5, BorderLayout.CENTER);

        // ----------------------------------
    }
}
